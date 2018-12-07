/**
 * 
 */
package metier.interfaces;

import java.util.List;

import metier.beans.Badge;
import metier.beans.Client;
import metier.beans.Compte;
import metier.beans.Employe;
import metier.beans.Groupe;
import metier.beans.Operation;

/**
 * Auteur HDN
 * Crée le Nov 25, 2018
 *
 * Cette classe permet de ...

 */
public interface IBanqueDAO {
	
	public Client addClient(Client c);
	
	public boolean addEmploye(Employe e);
	
	public void addGroupe(Groupe g);
	
	public void addEmployeToGroupe(Groupe groupe, Employe employe) ;
	
	public void addCompte(Compte c, Client client, Long numEmp );
	
	public void addOperation(Operation op,Long numCpte,Long numEmp);
	
	public Client consulterClientsParNomParPrenom(String nom, String prenom);
	
	public List<Client> consulterClients();
	
	public List<Groupe> consulterGroupes();
	
	public Groupe consulterGroupeParId(Long numGroupe);
	
	public List<Employe> consulterEmployes();
	
	public List<Employe> consulterEmployesParNomParPrenom(String nom, String prenom);
	
	public Employe consulterEmploye(Long idEmp);
	
	public void creerBadge(Badge badge, Employe employe);
}
