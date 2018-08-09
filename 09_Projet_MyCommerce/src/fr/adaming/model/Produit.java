package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Classe Produit
 * Auteur: NGLC Adaming INTI
 */
@Entity
@Table(name="produits")
public class Produit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private Long idProduit;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	@Transient
	private boolean selectionne;
	@Lob
	private byte[] photo;
	
	//transformation de l'asso UML en JAVA
	@ManyToOne
	@JoinColumn(name="ca_id", referencedColumnName="id_ca")
	private Categorie categorie;
	
	
	//declaration des constructeurs
	/**
	 * Constructeur vide
	 */
	public Produit() {
		super();
	}
	
	/**
	 * Constructeur avec tous les paramètres
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selectionne
	 * @param photo
	 */
	public Produit(String designation, String description, double prix, int quantite, boolean selectionne, byte[] photo) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
	}

	/**
	 * Constructeur avec tous les paramètres, y compris l'id
	 * @param idProduit
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selectionne
	 * @param photo
	 */
	public Produit(Long idProduit, String designation, String description, double prix, int quantite,
			boolean selectionne, byte[] photo) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
	}

	//declaration des getter et setter
	/**
	 * getter de l'id du produit
	 * @return the idProduit
	 */
	public Long getIdProduit() {
		return idProduit;
	}
	
	/**
	 * setter de l'id du produit
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	/**
	 * getter de la désignation du produit
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * setter de la désignation du produit
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * getter de la description du produit
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * setter de la description du produit
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * getter du prix du produit
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}
	/**
	 * setter du prix du produit
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	/**
	 * getter de la quantité du produit
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	/**
	 * setter de la quantité du produit
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	/**
	 * getter de la selection du produit
	 * @return the selectionne
	 */
	public boolean isSelectionne() {
		return selectionne;
	}
	/**
	 * setter de la selection du produit
	 * @param selectionne the selectionne to set
	 */
	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}
	/**
	 * getter de la photo du produit
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}
	/**
	 * setter de la photo du produit
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	/**
	 * getter de l'attribut de l'association avec categorie
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/**
	 * setter de l'attribut de l'association avec categorie
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	//declaration de la methode toString
		@Override
		public String toString() {
			return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", description=" + description
					+ ", prix=" + prix + ", quantite=" + quantite + ", selectionne=" + selectionne + ", photo="
					+ Arrays.toString(photo) + "]";
		}

	
}
