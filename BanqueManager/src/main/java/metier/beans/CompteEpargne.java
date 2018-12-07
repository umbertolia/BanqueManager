/**
 * 
 */
package metier.beans;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Auteur HDN
 * Crée le Nov 24, 2018
 *
 * Cette classe permet de ...

 */

@Entity
@DiscriminatorValue("CE")	
public class CompteEpargne extends Compte {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2395787559753786407L;
	@Column(precision=4, scale=2)
	private double taux;

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return this.taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	

	
}
