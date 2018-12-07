/**
 * 
 */
package metier.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.beans.Badge;
import metier.beans.Client;
import metier.beans.Compte;
import metier.beans.Employe;
import metier.beans.Groupe;
import metier.beans.Operation;
import metier.interfaces.IBanqueDAO;


/**
 * Auteur HDN Crée le Nov 25, 2018
 *
 * Cette classe permet de ...
 * 
 */
public class BanqueDAOImpl implements IBanqueDAO {

	private EntityManager em;

	public Client addClient(Client client) {
		Client unClient = null;
		List<Client> clients = consulterClients();
		if (!clients.contains(client)) {
			em.persist(client);
			unClient = client;
		}
		else {
			// recup du client
			unClient = this.consulterClientsParNomParPrenom(client.getNom(), client.getPrenom());
		}
		return unClient;
	}

	public boolean addEmploye(Employe employe) {
		boolean employeCree = false;
		if (employe != null) {
			List<Employe> liste = consulterEmployesParNomParPrenom(employe.getNomEmploye(), employe.getPrenomEmploye());
			if (liste.isEmpty()) {
				em.persist(employe);
				employeCree = true;
			}
		}
		return employeCree;
	}

	public void addGroupe(Groupe groupe) {
		List<Groupe> groupes = consulterGroupes();
		// ajout des groupe ssi cle unique et nom unique
		if (groupes.isEmpty() || !groupes.contains(groupe)) {
			em.persist(groupe);
		}
	}


	public void addEmployeToGroupe(Groupe groupe, Employe employe) {
		if (groupe != null && employe != null) {			
			if (groupe.getEmployes() != null) {
				if (!groupe.getEmployes().contains(employe)) {
					groupe.getEmployes().add(employe);
					employe.getGroupes().add(groupe);
				}
			}
		}
	}

	public void addCompte(Compte compte, Client client, Long numEmp) {
		if (compte != null && client != null) {
			compte.setClient(client);
			compte.setEmploye(consulterEmploye(numEmp));
			em.persist(compte);
		}
	}

	public void addOperation(Operation op, Long numCpte, Long numEmp) {
		Compte compte = em.find(Compte.class, numCpte);
		Employe employe = em.find(Employe.class, numEmp);
		
		if (compte != null && employe != null) {
			op.setCompte(compte);
			op.setEmploye(employe);
			em.persist(op);
		}
	}

	public Client consulterClientsParNomParPrenom(String nom, String prenom) {
		Query req = em.createQuery("select c from Client c where c.nom like :x and c.prenom like :y");
		req.setParameter("x", nom);
		req.setParameter("y", prenom);
		return (Client) req.getSingleResult();
	}

	public List<Client> consulterClients() {
		return em.createQuery("select c from Client c").getResultList();
	}

	public List<Groupe> consulterGroupes() {
		return em.createQuery("select g from Groupe g").getResultList();
	}

	public Groupe consulterGroupeParId(Long numGroupe) {
		Query req = em.createQuery("select g from Groupe g where g.numGroupe = :x");
		req.setParameter("x", numGroupe);
		return (Groupe) req.getSingleResult();
	}

	public List<Employe> consulterEmployes() {
		return em.createQuery("select e from Employe e").getResultList();
	}

	public List<Employe> consulterEmployesParNomParPrenom(String nom, String prenom) {
		Query req = em.createQuery("select e from Employe e where e.nomEmploye like :x and e.prenomEmploye like :y");
		req.setParameter("x", nom);
		req.setParameter("y", prenom);
		return req.getResultList();
	}

	public Employe consulterEmploye(Long idEmp) {		
		return  em.find(Employe.class, idEmp);
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return this.em;
	}
	
	/**
	 * @param em
	 *           the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void creerBadge(Badge badge, Employe employe) {
		if (badge != null && employe != null) {
			badge.setEmploye(employe);
			em.persist(badge);
		}
	}

}
