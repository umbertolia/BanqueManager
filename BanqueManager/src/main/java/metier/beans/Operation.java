/**
 * 
 */
package metier.beans;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * Auteur HDN Crée le Nov 24, 2018
 *
 * Cette classe permet de ...
 * 
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP", discriminatorType = DiscriminatorType.STRING, length = 4)
public abstract class Operation extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3132232821439665965L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NUM_OP")
	@NotEmpty
	private Long numOperation;

	@Basic
	@Temporal(TemporalType.DATE)
	@NotEmpty
	private Date dateOperation;

	@Column(precision = 10, scale = 2)
	private double montant;

	@ManyToOne
	@JoinColumn(name = "NUM_CPT")
	private Compte compte;

	@ManyToOne
	@JoinColumn(name = "NUM_EMP")
	private Employe employe;

	/**
	 * @return the numOperation
	 */
	public Long getNumOperation() {
		return this.numOperation;
	}

	/**
	 * @param numOperation
	 *           the numOperation to set
	 */
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}

	/**
	 * @return the dateOperation
	 */
	public Date getDateOperation() {
		return this.dateOperation;
	}

	/**
	 * @param dateOperation
	 *           the dateOperation to set
	 */
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	/**
	 * @return the montant
	 */
	public double getMontant() {
		return this.montant;
	}

	/**
	 * @param montant
	 *           the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return this.compte;
	}

	/**
	 * @param compte
	 *           the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
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

	@Transient
	public String getTypeVersement() {
		DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);
		return val == null ? null : val.value();
	}

}
