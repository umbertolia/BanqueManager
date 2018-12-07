/**
 * 
 */
package metier.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * Auteur HDN Crée le Nov 24, 2018
 *
 * Cette classe permet de ...
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
@Table(name="COMPTES")
public abstract class Compte extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6018606633336713932L;

	@Id
	@Column(name = "NUM_CPT")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Size(min = 6, max = 12)
	private Long numero;

	@Column(precision = 10, scale = 2)
	private double solde;

	@Basic
	@Temporal(TemporalType.DATE)
	@NotEmpty
	private Date dateCreation;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	@NotNull
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "NUM_EMP")
	private Employe employe;
	
	@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
	private List<Operation> operations;

	/**
	 * @return the numero
	 */
	public Long getNumero() {
		return this.numero;
	}

	/**
	 * 
	 * 
	 * @param numero the numero to set
	 */
	public void setNumero(Long numero) {
		this.numero = numero;
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
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return this.dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return this.client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
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

	/**
	 * @return the operations
	 */
	public List<Operation> getOperations() {
		return this.operations;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	@Transient
	public String getTypeCompte(){
	    DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );
	    return val == null ? null : val.value();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nCompte "+getTypeCompte());
		sb.append("\nSolde : "+getSolde());
		sb.append("\nConseiller : "+getEmploye().getPrenomEmploye() + " "+ getEmploye().getNomEmploye());
		sb.append("\n");
		return sb.toString();
	}
	
	
	
	
	
	

}
