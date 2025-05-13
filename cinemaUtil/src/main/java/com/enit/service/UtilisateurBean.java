package com.enit.service;

import java.util.List;

import com.enit.entities.Compte;

import jakarta.ejb.Stateful;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateful
public class UtilisateurBean implements IRemoteUtilisateur {
@PersistenceContext
private EntityManager em = null;
private int user_id;
public UtilisateurBean() {
super();
}
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public void debiter(float somme) throws SoldeNegatifException,UserNotFoundException{
float solde;
solde = solde();
if( solde+somme <= 0 ){

throw new SoldeNegatifException();

}else{

Compte compte;
Query q = em.createNamedQuery("findCompteById");
q.setParameter("cid",user_id);
@SuppressWarnings("unchecked")
List<Compte> res = (List<Compte>)(q.getResultList());
if(res.size()==0){



throw new UserNotFoundException();
}else{
compte = res.get(0);
compte.setSolde(solde+somme);
em.merge(compte);
}
}
}




@TransactionAttribute(TransactionAttributeType.REQUIRED)
public void payer(float somme) throws SoldeNegatifException,UserNotFoundException{
float solde;
solde = solde();
if( solde - somme < 0 ){

throw new SoldeNegatifException();

}else{

Compte compte;
Query q = em.createNamedQuery("findCompteById");
q.setParameter("cid",user_id);
@SuppressWarnings("unchecked")
List<Compte> res = (List<Compte>)(q.getResultList());
if(res.size()==0){



throw new UserNotFoundException();
}else{
compte = res.get(0);
compte.setSolde(solde-somme);
em.merge(compte);
}
}
}


public void createCompte(String nom, String motDePasse) {
    // Crée une instance de Compte
    Compte nouveauCompte = new Compte();
    nouveauCompte.setName(nom);
    nouveauCompte.setPassword(motDePasse);

    
   
    em.merge(nouveauCompte); // Insère le compte dans la base de données
   
}




public Compte getCompte(int id) {
	Query q = em.createNamedQuery("findCompteById");
	q.setParameter("cid", id);
	List<Compte> res = (List<Compte>)(q.getResultList());
	return res.get(0);
	
}
public String getName() throws UserNotFoundException{
String nom;
Query q = em.createNamedQuery("findCompteById");
q.setParameter("cid",user_id);

List<Compte> res = (List<Compte>)(q.getResultList());
if(res.size()==0){
throw new UserNotFoundException();
}else{
nom = res.get(0).getName();
}
return nom;
}
	public int init(String name, String passwd) throws UserNotFoundException{
		Query q = em.createNamedQuery("findCompteByName");
		q.setParameter("cname",name);
		List<Compte> res = (List<Compte>)q.getResultList();
		if (res==null || res.size()==0) {
			throw new UserNotFoundException();
		}else{
			if (res.get(0).getName().equals(name) && res.get(0).getPassword().equals(passwd)){
				user_id = res.get(0).getId();
			}else {
				throw new UserNotFoundException();
			}
		}
		return user_id;
	}
	public float solde() throws UserNotFoundException{
		float sld;
		Query q = em.createNamedQuery("findCompteById");
		q.setParameter("cid",user_id);
		List<Compte> res = (List<Compte>)(q.getResultList());
		if(res.size()==0)
			throw new UserNotFoundException();
		else
			sld = res.get(0).getSolde();
	
		return sld;

}
	public int getUser_id(){
		return this.user_id;
	}
}