package com.enit.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
@Entity
@NamedQueries({
@NamedQuery(name = "findAllComptes", query = "SELECT c FROM Compte c"),
@NamedQuery(name = "findCompteByName", query = "SELECT c FROM Compte c WHERE c.name = :cname"),
@NamedQuery(name = "findCompteById", query = "SELECT c FROM Compte c WHERE c.id = :cid")
})
public class Compte implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//le nom du propriétaire du compte bancaire
	private String name;
	//Mot de passe du propriétaire du compte
	private String password;
	private float solde;
	public Compte() {
	super();
	}
	public Compte(String nom) {
        this.name=nom;
    }
	
	
	public Compte(int id, String name, String pwd, float solde) {
		this.id = id;
		this.name = name; 
		this.password = pwd; 
		this.solde = solde;
	}
	
	
	public int getId() {
	return this.id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getName() {
	return this.name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public float getSolde() {
	return this.solde;
	}
	public void setSolde(float solde) {
	this.solde = solde;
	}
	public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Compte[id=").append(getId()).append(", name=").append(getName()).append("]");
	return sb.toString();
	}

	

	public void setPassword(String password) {
	this.password = password;
	}
	public String getPassword() {
	return password;
	}
}


