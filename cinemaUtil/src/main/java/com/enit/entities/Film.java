package com.enit.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;

@Entity 
public class Film implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name = "iDFilm")
	private int id_film ;
	
	@Column(name="nomFilm",length = 30)
	private String nom ;
	
	@Column(name="realisateurFilm",length = 30)
	private String realisateur;
	
	@OneToMany(mappedBy="film")
	private List<SalleProg> SalleProg ;
	
	
    public Film() {
		
	}
    public Film(String nom) {
		this.nom=nom;
	}
	
	public Film(int id_film, String nom,String realisateur) {
		super();
		this.id_film = id_film;
		this.nom = nom;
		this.realisateur = realisateur; 
	}
    
	public int getId_film() {
		return this.id_film;
	}

	public void setId_film(int id_film) {
		this.id_film = id_film;
	}

	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setRealisateur(String nom) {
		this.realisateur = nom;
	}
	
	public String getRealisateur() {
		return this.realisateur;
	}
	
	@Override
	public String toString() {
		return "Film [id_film=" + id_film + ", nom=" + nom + ", realisateur= "+realisateur+ "]";
	}

	


}