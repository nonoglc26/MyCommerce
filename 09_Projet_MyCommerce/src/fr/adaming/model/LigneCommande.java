package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe Ligne de Commande
 * 	Classe persistante
 * Assocaiation avec la classe produit et la classe commande
 */


@Entity
@Table(name="ligneCommandes")
public class LigneCommande {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lc")
	private long idLigne;
	private int quantite;
	private double prix;
	
	
	//Transformation des associations UML en Java
	@ManyToOne
	@JoinColumn(name="p_id", referencedColumnName="id_p")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name="co_id", referencedColumnName="id_co")
	private Commande commande;

	
	//Construsteurs
	/**
	 * Constructeur vide
	 */
	public LigneCommande() {
		super();
	}


	/**
	 * Constructeur avec paramètres
	 * @param idLigne
	 * @param quantite
	 * @param prix
	 */
	public LigneCommande(long idLigne, int quantite, double prix) {
		super();
		this.idLigne = idLigne;
		this.quantite = quantite;
		this.prix = prix;
	}


	/**
	 *Constructeur avec paramètres
	 * @param quantite
	 * @param prix
	 */
	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	//Getters et Setters
	/**
	 *getters
	 * @return the idLigne
	 */
	public long getIdLigne() {
		return idLigne;
	}


	/**
	 *Setters
	 * @param idLigne the idLigne to set
	 */
	public void setIdLigne(long idLigne) {
		this.idLigne = idLigne;
	}


	/**
	 * Getters
	 * Constructeur avec paramètres
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}


	/**
	 * 
	 * Setters
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	/**
	 * Getters
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}


	/**
	 * Setters
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}


	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}


	/**
	 * @param produit the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	/**
	 * @return the commande
	 */
	public Commande getCommande() {
		return commande;
	}


	/**
	 * @param commande the commande to set
	 */
	public void setCommande(Commande commande) {
		this.commande = commande;
	}




	
	
	
	
	
	

	
	
	
	
	
}
