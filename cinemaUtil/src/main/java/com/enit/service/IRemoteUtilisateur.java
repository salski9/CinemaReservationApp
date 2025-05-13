package com.enit.service;





import com.enit.entities.Compte;
import com.enit.entities.Seance;

import jakarta.ejb.Remote;

@Remote
public interface IRemoteUtilisateur {
	public Compte getCompte(int id);
	//Initialiser le bean compte bancaire utilisateur (authentification)
	public int init(String name, String passwd) throws UserNotFoundException;
	public String getName() throws UserNotFoundException; public float solde()
	throws SoldeNegatifException,UserNotFoundException; 
	public void createCompte(String nom, String motDePasse);
	public void debiter(float f) throws SoldeNegatifException,UserNotFoundException;
	//public void payer(float f) throws SoldeNegatifException,UserNotFoundException;
	//public void reserverSeance(Seance seance) throws SoldeNegatifException; 
	public int getUser_id();
}


