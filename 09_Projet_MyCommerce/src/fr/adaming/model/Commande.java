package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe Commande
 * 	Classe persistante
 * 	association OneToMany avec la classe LigneCommande
 * 	association OneToMany avec la classe Client
 * 	
 */

@Entity
@Table(name="commandes")
public class Commande {

	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_co")
	private long idCommande;
	@Temporal(TemporalType.DATE)
	private Date dateComande;
	
	//Tranformation de l'association UML en Java
	@ManyToOne
	@JoinColumn(name="cl_id", referencedColumnName="id_cl")
	private Client client;
	
	@OneToMany(mappedBy="commande")
	private List<LigneCommande> listeLigne;
	
	
	//Constructeurs
	/**
	 * Constructeur vide
	 */
	public Commande() {
		super();
	}



	/**
	 * Constructeurs avec paramètres
	 * @param idCommande
	 * @param dateComande
	 */
	public Commande(long idCommande, Date dateComande) {
		super();
		this.idCommande = idCommande;
		this.dateComande = dateComande;
	}



	/**
	 *Constructeurs avec paramètres
	 * @param dateComande
	 */
	public Commande(Date dateComande) {
		super();
		this.dateComande = dateComande;
	}



	/**
	 * Constructeurs avec paramètres
	 * @param idCommande
	 */
	public Commande(long idCommande) {
		super();
		this.idCommande = idCommande;
	}

	
	//Getters et Setters

	/**
	 * Getters
	 * @return the idCommande
	 */
	public long getIdCommande() {
		return idCommande;
	}



	/**
	 * Setters
	 * @param idCommande the idCommande to set
	 */
	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}



	/**
	 * Getters
	 * @return the dateComande
	 */
	public Date getDateComande() {
		return dateComande;
	}



	/**
	 * Setters
	 * @param dateComande the dateComande to set
	 */
	public void setDateComande(Date dateComande) {
		this.dateComande = dateComande;
	}





	/**
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}



	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}



	/**
	 * @return the listeLigne
	 */
	public List<LigneCommande> getListeLigne() {
		return listeLigne;
	}



	/**
	 * @param listeLigne the listeLigne to set
	 */
	public void setListeLigne(List<LigneCommande> listeLigne) {
		this.listeLigne = listeLigne;
	}
	

	
	
	
	
	
	
	
}
