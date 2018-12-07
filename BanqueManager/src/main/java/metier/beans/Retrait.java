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
@DiscriminatorValue("RETR")	
public class Retrait extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7929324104783298063L;

}
