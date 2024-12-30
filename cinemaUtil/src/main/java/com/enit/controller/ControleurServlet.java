package com.enit.controller;
import java.io.IOException;
import java.util.ArrayList;
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
        System.out.println("List of films: " + setFilms);

        // Fetch list of SalleProg
        Set<SalleProg> setSalleProgs = metierCinema.getAllSalleProg();
        List<SalleProg> listSalleProgs = new ArrayList<>(setSalleProgs);

        // Set attributes for JSP
        context.setAttribute("TousLesFilms", listeFilm);
       // context.setAttribute("TousLesSalleDeProg", listSalleProgs);

        // Forward to JSP page
        request.getRequestDispatcher("/listeFilm.jsp").forward(request, response);
    }


	/*
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		context= request.getSession().getServletContext();
	
	   List<Enseignant> listeEnseignants=	metierEnseignant.lesEnseignants();
		
		String action=request.getParameter("action"); 
		 
			if(action.equals("ajouter"))
		
			{ 
				Integer idCours= Integer.parseInt(request.getParameter("id"));
				String label= request.getParameter("label");
				String debut=request.getParameter("debut");
				String duree=request.getParameter("duree");
				String enseignantString = request.getParameter("choice");
				
				Enseignant enseignantSelectionne=   metierEnseignant.chercherEnseignant( Integer.parseInt(enseignantString));
				 
				
				Cours cours= new Cours(idCours, label, duree, debut);
				
				cours.setIntervenant(enseignantSelectionne);
				metierCours.ajoutCours(cours);
				request.setAttribute("beanCours", cours);
				   List<Cours> listeCours=metierCours.tousLesCours();

				context.setAttribute("listeCours", listeCours);
				context.setAttribute("listeEnseignants", listeEnseignants);
		    } 
			
		
	     //  request.getRequestDispatcher("/listeCours.jsp").forward(request, response); 
           context.getRequestDispatcher("/listeCours.jsp").forward(request, response);
	} */
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		context= request.getSession().getServletContext();
	
		Set<Film> listeFilm =	metierCinema.list();
        String action=request.getParameter("action"); 
		 
		if(action.equals("ajouter"))
		{ 
			Integer idFilm= Integer.parseInt(request.getParameter("idFilm"));
			String nomFilm= request.getParameter("nomFilm");
			
				
			Film nvFilm= new Film(idFilm,nomFilm);
			listeFilm.add(nvFilm);
				
			request.setAttribute("beanFilm", listeFilm);
			context.setAttribute("listeFilm", listeFilm);
		} 
			

           context.getRequestDispatcher("/listeFilm.jsp").forward(request, response);
	} 
}
