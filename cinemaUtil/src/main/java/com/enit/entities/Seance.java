package com.enit.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id_seance ;
	
	private Date horaire;
	private int places ;
	private float tarif ;
	
	
	@ManyToOne
	@JoinColumn(name="id_salleprog", nullable = false)
	private SalleProg salleProg;
	
    public Seance() {
		
	}
	
	public Seance(int id_seance, Date horaire, int places, float tarif) {
		this.id_seance = id_seance;
		this.horaire = horaire;
		this.places = places;
		this.tarif = tarif;
	}
	
	public SalleProg getSalleProg() {
		return this.salleProg;
	}
	public int getId_seance() {
		return id_seance;
	}
	
	public void setId_seance(int id_seance) {
		this.id_seance = id_seance;
	}
	
	public Date getHoraire() {
		return horaire;
	}
	
	public void setHoraire(Date horaire) {
		this.horaire = horaire;
	}
	
	public int getPlaces() {
		return places;
	}
	
	public void setPlaces(int places) {
		this.places = places;
	}
	public float getTarif() {
		return tarif;
	}
	
	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
}
