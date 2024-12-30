package com.enit.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="SalleP")
public class SalleProg implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id_salleProg;

	@ManyToOne
	@JoinColumn(name="id_film")
    private Film film;
	
	@OneToMany(mappedBy="salleProg", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Seance> seances;

	
	@OneToOne
	@JoinColumn(name = "salle_id", nullable = false)
	private Salle salle;
	
	@Column
	private int maxCapacite;
	
	public SalleProg() {
		
	}
	public SalleProg(int id_salleProg) {
		super();
		this.id_salleProg = id_salleProg;
	}
	
	@OneToOne(mappedBy="SalleP")
	public int getId() {
		return id_salleProg;
	}

	public void setId(int id_salleProg) {
		this.id_salleProg = id_salleProg;
	}
	
	public void setMaxCapacite(int capacite) {
		this.maxCapacite = capacite;
	}
	
	public int getMaxCapacite() {
		return maxCapacite;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_salleProg;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalleProg other = (SalleProg) obj;
		if (id_salleProg != other.id_salleProg)
			return false;
		return true;
	}
    
	
	
	
	@Override
	public java.lang.String toString() {
		return ("SalleProg [id_salleProg=" + id_salleProg + "]");
		 
	}
	
	
	public Salle getSalle() {
		// TODO Auto-generated method stub
		return salle;
	}

	public List<Seance> getSeances(){
		return this.seances;
	}
	

}