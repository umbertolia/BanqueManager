/**
 * 
 */
package metier.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * Auteur HDN Crée le Nov 25, 2018
 *
 * Cette classe permet de ...
 * 
 */

@Entity
@Table(name = "GROUPES")
public class Groupe extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 633748697433216174L;

	@Id
	@Column(name = "NUM_GROUPE")
	private Long numGroupe;

	@Column(name = "NOM_GROUPE")
	private String nomGroupe;

	@ManyToMany(mappedBy = "groupes")
	private List<Employe> employes;

	/**
	 * @return the numGroupe
	 */
	public Long getNumGroupe() {
		return this.numGroupe;
	}

	/**
	 * @param numGroupe
	 *           the numGroupe to set
	 */
	public void setNumGroupe(Long numGroupe) {
		this.numGroupe = numGroupe;
	}

	/**
	 * @return the nomGroupe
	 */
	public String getNomGroupe() {
		return this.nomGroupe;
	}

	/**
	 * @param nomGroupe
	 *           the nomGroupe to set
	 */
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	/**
	 * @return the employes
	 */
	public List<Employe> getEmployes() {
		return this.employes;
	}

	/**
	 * @param employes
	 *           the employes to set
	 */
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groupe other = (Groupe) obj;
		if (this.numGroupe == other.numGroupe)
			return true;
		if (this.nomGroupe.equals(other.nomGroupe))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\nGROUPE "+this.getNumGroupe() + " : " + this.getNomGroupe());
		if (this.getEmployes() != null) {
			for (Employe employe : this.employes) {
				sb.append("\n"+employe.getPrenomEmploye() + " "+employe.getNomEmploye());
			}
		}
		return sb.toString();
	}
	
	

}
