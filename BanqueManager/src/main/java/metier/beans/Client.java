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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Auteur HDN
 * Crée le Nov 24, 2018
 *
 * Cette classe permet de ...

 */

@Entity
@Table(name="CLIENTS")
public class Client extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5422542371034876673L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CLIENT")
	private long idClient;
	
	@NotEmpty
	@Column(name="NOM_CLIENT")
	private String nom;

	@NotEmpty
	@Column(name="PRENOM_CLIENT")
	private String prenom;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Compte> comptes;

	/**
	 * @return the idClient
	 */
	public long getIdClient() {
		return this.idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the comptes
	 */
	public List<Compte> getComptes() {
		return this.comptes;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (this.getNom() == other.getNom())
			return true;
		if (this.getPrenom().equals(other.getPrenom()))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nClient "+getPrenom()+ " "+getNom());
		sb.append("\nNombre de comptes : "+getComptes().size());
		return sb.toString();
	}
	
	
}
