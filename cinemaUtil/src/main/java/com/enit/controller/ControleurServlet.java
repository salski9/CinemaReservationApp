package com.enit.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import jakarta.ejb.EJB;
import jakarta.ejb.SessionContext;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.enit.entities.Film;
import com.enit.entities.SalleProg;
import com.enit.service.IRemoteCinema;
import com.enit.service.IRemoteUtilisateur;

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

        // Fetch list of films
        Set<Film> setFilms = metierCinema.list();
        List<Film> listeFilm = new ArrayList<>(setFilms);
        listeFilm.sort(Comparator.comparing(film -> Integer.valueOf(film.getId_film())));

        // Fetch list of SalleProg
        Set<SalleProg> setSalleProgs = metierCinema.getAllSalleProg();
        List<SalleProg> listSalleProgs = new ArrayList<>(setSalleProgs);
        
        // Set attributes for JSP
        context.setAttribute("TousLesFilms", listeFilm);
       // context.setAttribute("TousLesSalleDeProg", listSalleProgs);

        // Forward to JSP page
        context.getRequestDispatcher("/listeFilm.jsp").forward(request, response);
    }


	
    
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		context= request.getSession().getServletContext();
	
		

        String action=request.getParameter("action"); 
		 
		if(action.equals("ajouter"))
		{ 
			Integer idFilm= Integer.parseInt(request.getParameter("id_film"));
			String nomFilm= request.getParameter("nom");
			String realisateurFilm= request.getParameter("realisateur"); 
				
			Film nvFilm= new Film(idFilm,nomFilm, realisateurFilm);
			metierCinema.update(nvFilm);
			request.setAttribute("cinemaBean", nvFilm);
				
	        List<Film> listeFilms = new ArrayList<>(metierCinema.list());
	        listeFilms.sort(Comparator.comparing(film -> Integer.valueOf(film.getId_film())));

			context.setAttribute("TousLesFilms", listeFilms);
		} 
			

          // context.getRequestDispatcher("/listeFilm.jsp").forward(request, response);
           context.getRequestDispatcher("/listeFilm.jsp").forward(request, response);
	} 
}
