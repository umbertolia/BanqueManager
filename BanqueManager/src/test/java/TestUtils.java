import java.util.GregorianCalendar;

import metier.beans.Badge;
import metier.beans.Employe;
import metier.impl.BanqueDAOImpl;

/**
 * 
 */

/**
 * Auteur HDN
 * Crée le Nov 26, 2018
 *
 * Cette classe permet de ...

 */
public class TestUtils {
	
	public static void creerEmployes(BanqueDAOImpl dao) {
		
		// NOUVEL EMPLYE / BADGE
		Employe employe = new Employe();
		employe.setNomEmploye("Doe");
		employe.setPrenomEmploye("John");
		employe.setSalaire(2500.0);
		boolean employeCree = dao.addEmploye(employe);
		if (employeCree) {
			Badge badge = new Badge();
			badge.setSolde(100);
			GregorianCalendar gc = new GregorianCalendar(2018, 11, 31);
			badge.setDateExpiration(gc.getTime());
			dao.creerBadge(badge, employe);
		}
		
		// NOUVEL EMPLYE / BADGE
		employe = new Employe();
		employe.setNomEmploye("Michel");
		employe.setPrenomEmploye("Jean");
		employe.setSalaire(2200.0);
		employeCree = dao.addEmploye(employe);
		//
		if (employeCree) {
			Badge badge = new Badge();
			badge.setSolde(200);
			GregorianCalendar gc = new GregorianCalendar(2018, 11, 31);
			badge.setDateExpiration(gc.getTime());
			dao.creerBadge(badge, employe);
		}		
		
		
		// NOUVEL EMPLYE / BADGE
		employe = new Employe();
		employe.setNomEmploye("Ravin");
		employe.setPrenomEmploye("JC");
		employe.setSalaire(1500.0);
		employeCree = dao.addEmploye(employe);
		if (employeCree) {
			Badge badge = new Badge();
			badge.setSolde(300);
			GregorianCalendar gc = new GregorianCalendar(2018, 11, 31);
			badge.setDateExpiration(gc.getTime());
			dao.creerBadge(badge, employe);
		}
		
		// NOUVEL EMPLYE / BADGE
		employe = new Employe();
		employe.setNomEmploye("Pion");
		employe.setPrenomEmploye("Tartan");
		employe.setSalaire(1450.0);
		employeCree = dao.addEmploye(employe);
		//
		if (employeCree) {
			Badge badge = new Badge();
			badge.setSolde(185);
			GregorianCalendar gc = new GregorianCalendar(2018, 11, 31);
			badge.setDateExpiration(gc.getTime());
			dao.creerBadge(badge, employe);
		}
		
		// NOUVEL EMPLYE / BADGE
		employe = new Employe();
		employe.setNomEmploye("Torria");
		employe.setPrenomEmploye("Vic");
		employe.setSalaire(3410.0);
		employeCree = dao.addEmploye(employe);
		if (employeCree) {
			Badge badge = new Badge();
			badge.setSolde(421);
			GregorianCalendar gc = new GregorianCalendar(2018, 11, 31);
			badge.setDateExpiration(gc.getTime());
			dao.creerBadge(badge, employe);
		}
		
		// NOUVEL EMPLYE / BADGE
		employe = new Employe();
		employe.setNomEmploye("Oton");
		employe.setPrenomEmploye("Pierre");
		employe.setSalaire(1250.0);
		employeCree = dao.addEmploye(employe);
		if (employeCree) {
			Badge badge = new Badge();
			badge.setSolde(85);
			GregorianCalendar gc = new GregorianCalendar(2018, 11, 31);
			badge.setDateExpiration(gc.getTime());
			dao.creerBadge(badge, employe);
		}	
		
		// NOUVEL EMPLYE / BADGE
		employe = new Employe();
		employe.setNomEmploye("Atan");
		employe.setPrenomEmploye("Charles");
		employe.setSalaire(8050.0);
		employeCree = dao.addEmploye(employe);
		if (employeCree) {
			Badge badge = new Badge();
			badge.setSolde(785);
			GregorianCalendar gc = new GregorianCalendar(2018, 11, 31);
			badge.setDateExpiration(gc.getTime());
			dao.creerBadge(badge, employe);
		}	
	}

}
