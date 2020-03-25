package fr.diginamic.entities;

public class Fournisseur {
	/**nom : nom fournisseur */
	String nom;
	/**id : id du fournisseur */
	int id;
	
	
	/**Constructeur
	 * @param nom
	 * @param id
	 */
	public Fournisseur(String nom, int id) {
		super();
		this.nom = nom;
		this.id = id;
	}


	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Fournisseur [nom=" + nom + ", id=" + id + "]";
	}
	
	
}
