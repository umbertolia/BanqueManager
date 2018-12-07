import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.beans.Client;
import metier.beans.CompteCourant;
import metier.beans.CompteEpargne;
import metier.beans.Employe;
import metier.beans.Groupe;
import metier.beans.Operation;
import metier.beans.Versement;
import metier.impl.BanqueDAOImpl;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


/**
 * 
 */

/**
 * Auteur HDN Crée le Nov 25, 2018
 *
 * Cette classe permet de ...
 * 
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BanqueDaoTest {

	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	private BanqueDAOImpl dao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("BANK");
			entityManager = entityManagerFactory.createEntityManager();
			dao = new BanqueDAOImpl();
			dao.setEm(entityManager);
			assertTrue("connection a la base OK via EntityManager", true);
		} catch (Exception e) {
			fail("connection a la base KO via EntityManager");
		}

	}

	@Test
	//@Ignore("TESTED")
	public void test0_JdbcConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque", "root", "admin");
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("show tables from banque");
			rs.close();
			assertTrue("connection a la base OK via DriverManager", true);
		} catch (Exception exception) {
			fail("connection a la base KO via DriverManager");
		}
	}

	@Test
	//@Ignore("TESTED")
	public void test1_AddEmployeBadge() {
		try {
			dao.getEm().getTransaction().begin();
			TestUtils.creerEmployes(dao);
			dao.getEm().getTransaction().commit();
			assertTrue("beans ajoutes a la base", dao.consulterEmployes().size() == 7);
		} catch (Exception exception) {
			dao.getEm().getTransaction().rollback();
			fail(exception.getMessage());
			exception.printStackTrace();
		}
	}

	@Test
	//@Ignore("TESTED")
	public void test2_AddGroupes() {
		try {
			dao.getEm().getTransaction().begin();
			// creation des groupes
			Groupe groupe = new Groupe();
			groupe.setNumGroupe(1L);
			groupe.setNomGroupe("Developpeurs");
			dao.addGroupe(groupe);
			groupe = new Groupe();
			groupe.setNumGroupe(2L);
			groupe.setNomGroupe("Managers");
			dao.addGroupe(groupe);
			//
			dao.getEm().getTransaction().commit();
			assertTrue("2 groupes ajoutes a la base", dao.consulterGroupes().size() == 2);

		} catch (Exception exception) {
			dao.getEm().getTransaction().rollback();
			fail(exception.getMessage());
			exception.printStackTrace();
		}
	}

	@Test
	//@Ignore("TESTED")
	public void test3_LiaisonEmployesGroupes() {
		try {
			dao.getEm().getTransaction().begin();

			Groupe devs = dao.consulterGroupeParId(1L);
			Groupe managers = dao.consulterGroupeParId(2L);

			for (Employe employe : dao.consulterEmployes()) {
				if (employe.getSalaire() > 3000) {
					dao.addEmployeToGroupe(managers, employe);
				} else {
					dao.addEmployeToGroupe(devs, employe);
				}
			}
			dao.getEm().getTransaction().commit();
		} catch (Exception exception) {
			dao.getEm().getTransaction().rollback();
			fail(exception.getMessage());
			exception.printStackTrace();
		}

	}

	@Test
	//@Ignore("TESTED")
	public void test4_ClientComptes() {
		try {
			dao.getEm().getTransaction().begin();

			Client client = new Client();
			client.setNom("DE AMORIN");
			client.setPrenom("Umberto");
			client = dao.addClient(client);

			CompteCourant compte = new CompteCourant();
			compte.setDateCreation(new Date());
			compte.setDecouvert(1000);
			compte.setSolde(15000);
			dao.addCompte(compte, client, 5L);
			
			CompteEpargne epargne = new CompteEpargne();
			epargne.setDateCreation(new Date());
			epargne.setTaux(1.5);
			epargne.setSolde(8645);
			dao.addCompte(epargne, client, 3L);
			
			epargne = new CompteEpargne();
			epargne.setDateCreation(new Date());
			epargne.setTaux(0.25);
			epargne.setSolde(1750.45);
			dao.addCompte(epargne, client, 3L);
			
			dao.getEm().getTransaction().commit();
		} catch (Exception exception) {
			dao.getEm().getTransaction().rollback();
			fail(exception.getMessage());
			exception.printStackTrace();
		}

	}
	
	@Test
	//@Ignore("TESTED")
	public void test5_QuiGereCompteDe() {
		try {
			dao.getEm().getTransaction().begin();
			
			List<Client> clients = dao.consulterClients();
			if (!clients.isEmpty()) {
				Client client = clients.get(0);
				System.out.println(client);
				System.out.println("----- COMPTES -----");
				System.out.println(client.getComptes());
			}
			// AFFICHAGES LIEN GROUPES-EMPLOYES
			System.out.println(dao.consulterGroupeParId(1L));
			System.out.println(dao.consulterGroupeParId(2L));
			
			
	
		} catch (Exception exception) {
			dao.getEm().getTransaction().rollback();
			fail(exception.getMessage());
			exception.printStackTrace();
		}	
	}
	
	@Test
	//@Ignore("TESTED")
	public void test6_Operations() {
		try {
			this.
			dao.getEm().getTransaction().begin();
			
			Operation versement = new Versement();
			versement.setDateOperation(new Date());
			versement.setMontant(1000);
			dao.addOperation(versement, 2L, 1L);
			
			dao.getEm().getTransaction().commit();

		
			
		} catch (Exception exception) {
			dao.getEm().getTransaction().rollback();
			fail(exception.getMessage());
			exception.printStackTrace();
		}	
	}
	

}
