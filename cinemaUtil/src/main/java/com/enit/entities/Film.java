package com.enit.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "iDFilm")
	private int id_film;

	
	@Column(name="nomFilm",length = 30)
	private String nom ;
	
	@Column(name="realisateurFilm",length = 30)
	private String realisateur;
	
	@Column(name="dateProj")
	private LocalDate dateProj;
	
	@OneToMany(mappedBy="film")
	private List<SalleProg> SalleProg ;
	
	@Column(name="urlPhoto")
	private String urlPhoto;
	
    public Film() {
		
	}
    public Film(String nom) {
		this.nom=nom;
	}
	
	public Film(int id_film, String nom,String realisateur, LocalDate dateProj) {
		super();
		this.id_film = id_film;
		this.nom = nom;
		this.realisateur = realisateur; 
		this.dateProj = dateProj;
		
	}
    
	public Film(String nom,String realisateur, LocalDate dateProj) {
		super();
		this.nom = nom;
		this.realisateur = realisateur; 
		this.dateProj = dateProj;
		
	}
	public Film(String nom,String realisateur, LocalDate dateProj, String filmImage) {
		super();
		this.nom = nom;
		this.realisateur = realisateur; 
		this.dateProj = dateProj;
		this.urlPhoto = filmImage;
		
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
	public String getUrlPhoto() {
		return this.urlPhoto;
	}
	
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public void setRealisateur(String nom) {
		this.realisateur = nom;
	}
	
	public String getRealisateur() {
		return this.realisateur;
	}
	
	
	public LocalDate getDateProj() {
		return this.dateProj;
	}
	
	public void setDateProj(LocalDate date) {
		this.dateProj = date;
	}
	@Override
	public String toString() {
		return "Film [id_film=" + id_film + ", nom=" + nom + ", realisateur= "+realisateur+ ", date de projection= "+ dateProj +"]";
	}

	


}