package com.enit.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.enit.entities.Compte;
import com.enit.entities.Film;
import com.enit.entities.SalleProg;
import com.enit.entities.Seance;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CinemaBean implements IRemoteCinema {
	
	
	@PersistenceContext 
	private EntityManager em ;

	public CinemaBean() {
		super();
		
	}

	
		
		@SuppressWarnings("unchecked")
		@Override
		public Set<Film> list() {
		    Query req = em.createQuery("select f from Film f");
		    return (Set<Film>) req.getResultList().stream().collect(Collectors.toSet());
		}

	

	@Override
	public Set<Film> findByPattern (String pattern){

		Query q = em.createNamedQuery("findFilmByPattern");
		q.setParameter("nom",pattern);
		@SuppressWarnings("unchecked")
		List<Film> res = (List<Film>)q.getResultList();
		Set<Film> reqset= (Set<Film>) res.stream().collect(Collectors.toSet());
		return reqset;
	}

	@Override
	public Film findFilm(int id) {
		Film film=em.find(Film.class, id);
	    return film;
	}

	@Override
	public void reserve(Seance seance, IRemoteUtilisateur u) throws PlusDePlaceException, UserNotFoundException, SoldeNegatifException, SoldeInsuffisantException {
		
		int places = seance.getPlaces();
		int actualCapacite = seance.getSalleProg().getMaxCapacite();
		if( u.solde() < seance.getTarif() ) {
			throw new SoldeInsuffisantException();
		}
		else {
			if (places> actualCapacite) {
				throw new PlusDePlaceException();
			}
			else {
				String nom = u.getName();
				Compte c = new Compte(nom);
				u.init(nom, c.getPassword());
				u.debiter(seance.getTarif());
				places++;
			}
		}
		
	}

	@Override
	public Set<SalleProg> getAllSalleProg() {
		Query req=em.createQuery("select c from SalleProg c");
		@SuppressWarnings("unchecked")
		List<SalleProg> reqlist=(List<SalleProg>)req.getResultList();
		Set<SalleProg> reqset= (Set<SalleProg>) reqlist.stream().collect(Collectors.toSet());
		return reqset;
	}

	@Override
	public Film createFilm(String name) {
		Film F= new Film(name);
		return F;
		
	}

	@Override
	public void update(Film film) {
		em.persist(film);
	}

	@Override
	public float getTarif() {
	
		
		float sum=0;
		for(SalleProg s : this.getAllSalleProg()) {
			float sum1 = 0;
			for (Seance se: s.getSeances()) {
				sum1 += se.getTarif();
			}
			sum += sum1;	
	    }
		return sum;
	
	}
}
