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
@DiscriminatorValue("CC")	
public class CompteCourant extends Compte {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3827506824915436431L;
	@Column(precision=10, scale=2)
	private double decouvert;

	/**
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return this.decouvert;
	}

	/**
	 * @param decouvert the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
	
}
