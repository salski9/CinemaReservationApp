package com.enit.service;


import java.util.Set;

import com.enit.entities.Film;
import com.enit.entities.SalleProg;
import com.enit.entities.Seance;
import jakarta.ejb.Remote;

@Remote
public interface IRemoteCinema {
	
	// Lister l'ensemble de films disponible au cinema.
	public Set<Film> list ();
	// Trouver les films correspondants au pattern donné en entrée.
	public Set<Film> findByPattern (String pattern);
	// Trouver un film à partir d'un id.
	public Film findFilm (int id);
	// Réserver une séance pour un utilisateur.
	public void reserve (Seance seance, IRemoteUtilisateur u)
	throws PlusDePlaceException, SoldeInsuffisantException,
	UserNotFoundException, SoldeNegatifException;
	public Set<SalleProg> getAllSalleProg ();
	public Film createFilm (String name);
	public void update (Film f);
	public float getTarif ();
}