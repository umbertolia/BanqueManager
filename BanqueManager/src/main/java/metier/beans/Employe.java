/**
 * 
 */
package metier.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Auteur HDN Crée le Nov 25, 2018
 *
 * Cette classe permet de ...
 * 
 */

@Entity
@Table(name = "EMPLOYES")
public class Employe extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4209828807570766254L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NUM_EMP")
	private Long codeEmploye;

	@Column(name = "NOM_EMP")
	private String nomEmploye;
	
	@Column(name = "PRENOM_EMP")
	private String prenomEmploye;

	private double salaire;

	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Compte> comptes;

	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Operation> operations;
	
	@OneToOne(mappedBy="employe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn (name = "NUM_EMP")
	private Badge badgeEmploye;

	@ManyToMany
	@JoinTable(name = "EMP_GROUPES", joinColumns = @JoinColumn(name = "NUM_EMP"), inverseJoinColumns = @JoinColumn(name = "NUM_GROUPE"))
	private List<Groupe> groupes;

	/**
	 * @return the codeEmploye
	 */
	public Long getCodeEmploye() {
		return this.codeEmploye;
	}

	/**
	 * @param codeEmploye
	 *           the codeEmploye to set
	 */
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}

	/**
	 * @return the nomEmploye
	 */
	public String getNomEmploye() {
		return this.nomEmploye;
	}

	/**
	 * @param nomEmploye
	 *           the nomEmploye to set
	 */
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	
	

	/**
	 * @return the prenomEmploye
	 */
	public String getPrenomEmploye() {
		return this.prenomEmploye;
	}

	/**
	 * @param prenomEmploye the prenomEmploye to set
	 */
	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	/**
	 * @return the salaire
	 */
	public double getSalaire() {
		return this.salaire;
	}

	/**
	 * @param salaire
	 *           the salaire to set
	 */
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	/**
	 * @return the comptes
	 */
	public List<Compte> getComptes() {
		return this.comptes;
	}

	/**
	 * @param comptes
	 *           the comptes to set
	 */
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
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

	/**
	 * @return the groupes
	 */
	public List<Groupe> getGroupes() {
		return this.groupes;
	}

	/**
	 * @param groupes
	 *           the groupes to set
	 */
	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	/**
	 * @return the badgeEmploye
	 */
	public Badge getBadgeEmploye() {
		return this.badgeEmploye;
	}

	/**
	 * @param badgeEmploye
	 *           the badgeEmploye to set
	 */
	public void setBadgeEmploye(Badge badgeEmploye) {
		this.badgeEmploye = badgeEmploye;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nEmploye "+this.getPrenomEmploye() + " "+ this.getNomEmploye());
		sb.append("\nBadge n°"+this.getBadgeEmploye().getNumeroBadge());
		sb.append("\nSalaire : "+this.getSalaire());

		return sb.toString();
		
	}

	
}
