/**
 * 
 */
package metier.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Auteur HDN
 * Crée le Nov 24, 2018
 *
 * Cette classe permet de ...

 */

@Entity
@DiscriminatorValue("VERS")	
public class Versement extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9015705049354886327L;

}
