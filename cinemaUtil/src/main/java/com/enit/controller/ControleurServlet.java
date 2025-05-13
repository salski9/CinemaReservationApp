package com.enit.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import jakarta.ejb.EJB;
import jakarta.ejb.SessionContext;
import jakarta.persistence.Query;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import com.enit.entities.Compte;
import com.enit.entities.Film;
import com.enit.entities.SalleProg;
import com.enit.entities.Seance;
import com.enit.service.IRemoteCinema;
import com.enit.service.IRemoteUtilisateur;
import com.enit.service.SoldeNegatifException;
import com.enit.service.UserNotFoundException;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
maxFileSize = 1024 * 1024 * 5,     // 5MB
maxRequestSize = 1024 * 1024 * 10) // 10MB

@WebServlet(name = "cs", urlPatterns = {"/controleur"})
public class ControleurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ServletContext context;

    @EJB
    private IRemoteCinema metierCinema;

    @EJB
    private IRemoteUtilisateur metierUtilisateur;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        context = request.getSession().getServletContext();
    	String filmId = request.getParameter("filmId");
    	String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        
        
        String page = request.getParameter("page");
        
     // Determine the target page (default is home.jsp)
        
        if (page == null || page.isEmpty()) {
            page = "home.jsp"; // Default page
        }
        
        if (page.equals("home.jsp")) {
        	
        	// Fetch list of films
	        Set<Film> setFilms = metierCinema.list();
	        List<Film> listeFilm = new ArrayList<>(setFilms);
	        listeFilm.sort(Comparator.comparing(film -> Integer.valueOf(film.getId_film())));
	        
	        
	        

	        // Set attributes for JSP
	        context.setAttribute("TousLesFilms", listeFilm);
	        //context.setAttribute("TousLesSalleDeProg", listSalleProgs);
        }else if(page.equals("user.jsp")) {
        	 int id;
			try {
				id = metierUtilisateur.init(name, pwd);
				Compte compte = metierUtilisateur.getCompte(id);
				context.setAttribute("compte", compte);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        	
        }else if(page.equals("reserver.jsp")) {
        	
        	
	        //context.setAttribute("TousLesSalleDeProg", listSalleProgs);
        	 Film film = metierCinema.findFilm(Integer.parseInt(filmId));
        	 /*List<Film> listeFilms = new ArrayList<Film>();
        	 listeFilms.add(film);*/
        	 context.setAttribute("film", film);
        	 
        	 Set<SalleProg> setSalleProgs = metierCinema.getAllSalleProg();
 	         List<SalleProg> listSalleProgs = new ArrayList<>(setSalleProgs);
 	         context.setAttribute("TousLesSalleDeProg", listSalleProgs);
        	
        }
        
	        // Forward to JSP page
	        context.getRequestDispatcher("/" + page).forward(request, response);
	        
        
    }


	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        context = request.getSession().getServletContext();
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        String action = request.getParameter("action");
        String targetPage = "home.jsp"; // Default page
        String filmId = request.getParameter("filmId");
        
     

        if (action != null) {
            if (action.equals("ajouter")) {
                // Handle adding a film
            	targetPage = "listeFilm.jsp";
                String nomFilm = request.getParameter("nom");
                String realisateurFilm = request.getParameter("realisateur");
                String dateProj = request.getParameter("dateProj");
                LocalDate projectionDate = LocalDate.parse(dateProj);
                // Save image to a folder
                Part filePart = request.getPart("filmImage");
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                String uploadPath = getServletContext().getRealPath("") + File.separator + "uploadedImages";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdir();
                
                String filePath = uploadPath + File.separator + fileName;
                filePart.write(filePath);
                
                String imageUrl = "uploadedImages/" + fileName;
                Film nvFilm = new Film(nomFilm, realisateurFilm, projectionDate, imageUrl);
                metierCinema.update(nvFilm);

                List<Film> listeFilms = new ArrayList<>(metierCinema.list());
                listeFilms.sort(Comparator.comparing(film -> Integer.valueOf(film.getId_film())));
                context.setAttribute("TousLesFilms", listeFilms);

                
            }else if (action.equals("login")) {
                name = request.getParameter("name");
                pwd = request.getParameter("password");

                try {
                    int id = metierUtilisateur.init(name, pwd);
                    Compte compte = metierUtilisateur.getCompte(id);

                    HttpSession session = request.getSession(true);
                    session.setAttribute("compte", compte);
                    session.setAttribute("isLoggedIn", true);

                    response.sendRedirect("home.jsp"); // Redirect after successful login
                    return;
                } catch (UserNotFoundException e) {
                    request.setAttribute("isLoggedIn", false);
                    request.setAttribute("errorMsg", "Nom ou mot de passe incorrect.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
            }

            else if (action.equals("logout")) {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
                response.sendRedirect("home.jsp");
                return;
            }
            

            else if ("debiter".equals(action)) {
                float debitAmount = Float.parseFloat(request.getParameter("debitAmount"));
                HttpSession session = request.getSession(false);
                if (session == null || session.getAttribute("compte") == null) {
                    // Not logged in → redirect to login
                    response.sendRedirect("home.jsp");
                    return;
                }
                try {
                    // Perform the debit
                    metierUtilisateur.debiter(debitAmount);
                    // Reload the updated compte from the service
                    Compte compte = (Compte) session.getAttribute("compte");
                    int id = compte.getId();  // assuming Compte has getId()
                    Compte updated = metierUtilisateur.getCompte(id);
                    session.setAttribute("compte", updated);

                    // Show success on the same page
                    request.setAttribute("successMsg",
                        "Le montant de " + debitAmount + " € a été débité avec succès !");
                } catch (UserNotFoundException e) {
                    request.setAttribute("errorMsg",
                        "Erreur : Utilisateur non trouvé. Veuillez vous reconnecter.");
                    session.invalidate();
                } catch (Exception e) {
                    request.setAttribute("errorMsg",
                        "Une erreur inattendue : " + e.getMessage());
                }
                // Forward back—keeps you on gestionUtilisateur.jsp
                request.getRequestDispatcher("user.jsp")
                       .forward(request, response);
                return;
            }

            else if (action.equals("reserver")){
            	
            	
            	int idFilm = Integer.parseInt(filmId);
            	Film film = metierCinema.findFilm(idFilm); 
            	 List<Film> listeFilms = new ArrayList<Film>();
            	 listeFilms.add(film);
            	request.setAttribute("liste", listeFilms);	
            	targetPage = "reserver.jsp";
            	
        }else if (action.equals("register")) {
        	String nameNv = request.getParameter("name");
            String pwdNv = request.getParameter("password");
            metierUtilisateur.createCompte(nameNv, pwdNv);
			targetPage="home.jsp"; 
        }

        // Forward to the target page
        context.getRequestDispatcher("/" + targetPage).forward(request, response);
    }
}
}

