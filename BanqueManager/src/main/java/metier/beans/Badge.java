/**
 * 
 */
package metier.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 * Auteur HDN
 * Crée le Nov 25, 2018
 *
 * Cette classe permet de ...

 */

@Entity
public class Badge extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8426536563775424983L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numeroBadge;
	
	private Date dateExpiration;
	
	private double solde;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Employe employe;

	/**
	 * @return the numeroBadge
	 */
	public Long getNumeroBadge() {
		return this.numeroBadge;
	}

	/**
	 * @param numeroBadge the numeroBadge to set
	 */
	public void setNumeroBadge(Long numeroBadge) {
		this.numeroBadge = numeroBadge;
	}

	/**
	 * @return the dateExpiration
	 */
	public Date getDateExpiration() {
		return this.dateExpiration;
	}

	/**
	 * @param dateExpiration the dateExpiration to set
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return this.solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return the employe
	 */
	public Employe getEmploye() {
		return this.employe;
	}

	/**
	 * @param employe the employe to set
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	
}
