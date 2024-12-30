package com.enit.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
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
	
	@OneToMany(mappedBy="film")
	private List<SalleProg> SalleProg ;
	
	
    public Film() {
		
	}
    public Film(String nom) {
		this.nom=nom;
	}
	
	public Film(int id_film, String nom) {
		super();
		this.id_film = id_film;
		this.nom = nom;
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


}