package com.enit.service;





import jakarta.ejb.Remote;

@Remote
public interface IRemoteUtilisateur {
	
	//Initialiser le bean compte bancaire utilisateur (authentification)
	public void init(String name, String passwd) throws UserNotFoundException;
	public String getName() throws UserNotFoundException; public float solde()
	throws SoldeNegatifException,UserNotFoundException; 
	
	public void debiter(float f) throws SoldeNegatifException,UserNotFoundException;
}


