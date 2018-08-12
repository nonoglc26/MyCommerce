package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Classe Categorie
 * Association OneToMany avec la classe produit
 * Auteur: NGLC Adaming
 */
@Entity
@Table(name="categories")
public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ca")
	private Long idCategorie;
	private String nomCategorie;
	@Lob
	private byte[] photo;
	private String description;
	@Transient
	private String image;
	
	//transfo de l'asso UML en JAVA
	@OneToMany(mappedBy="categorie")
	private List<Produit> listeProduit;
	
	//declaration des constructeurs
	/**
	 * Constructeur vide
	 */
	public Categorie() {
		super();
	}

	/**
	 * Constructeur avec paramètres, sans l'id
	 * @param nomCategorie
	 * @param photo
	 * @param description
	 */
	public Categorie(String nomCategorie, byte[] photo, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}

	/**
	 * Constructeur avec tous les paramètres
	 * @param idCategorie
	 * @param nomCategorie
	 * @param photo
	 * @param description
	 */
	public Categorie(Long idCategorie, String nomCategorie, byte[] photo, String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}

	//declaration des getter et setter

	/**
	 * getter de l'id de la categorie
	 * @return the idCategorie
	 */
	public Long getIdCategorie() {
		return idCategorie;
	}

	/**
	 * setter de l'id de la categorie
	 * @param idCategorie the idCategorie to set
	 */
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	/**
	 * getter du nom de la categorie
	 * @return the nomCategorie
	 */
	public String getNomCategorie() {
		return nomCategorie;
	}

	/**
	 * setter du nom de la categorie
	 * @param nomCategorie the nomCategorie to set
	 */
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	/**
	 * getter de la photo de la categorie
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}

	/**
	 * setter de la photo de la categorie
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * getter de la description de la categorie
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * setter de la description de la categorie
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * getter de la liste de produit lié à l'association avec la classe produit
	 * @return the listeProduit
	 */
	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	/**
	 * setter de la liste de produit lié à l'association avec la classe produit
	 * @param listeProduit the listeProduit to set
	 */
	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	/**
	 * getter de l'image
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 *  setter de l'image
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	//methode toString
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", photo="
				+ Arrays.toString(photo) + ", description=" + description + "]";
	}
	

}
