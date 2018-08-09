package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Adminsitrateur
 * Auteur: NGLC Adaming INTI
 */
@Entity
@Table(name="administrateurs")
public class Administrateur implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_a")
	private Long idAdmin;
	private String nom;
	private String mdp;

	
	//declaration des constructeurs
	/**
	 * Constructeur vide
	 */
	public Administrateur() {
		super();
	}

	/**
	 * Constructeur avec paramètres sans id
	 * @param nom
	 * @param mdp
	 */
	public Administrateur(String nom, String mdp) {
		super();
		this.nom = nom;
		this.mdp = mdp;
	}


	/**
	 * Constructeur avec paramètres
	 * @param idAdmin
	 * @param nom
	 * @param mdp
	 */
	public Administrateur(Long idAdmin, String nom, String mdp) {
		super();
		this.idAdmin = idAdmin;
		this.nom = nom;
		this.mdp = mdp;
	}

	//declaration des getter et setter
	/**
	 * getter de l'attribut id de l'administrateur
	 * @return the idAdmin
	 */
	public Long getIdAdmin() {
		return idAdmin;
	}

	/**
	 * setter de l'attribut id de l'administrateur
	 * @param idAdmin the idAdmin to set
	 */
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	/**
	 * getter de l'attribut nom de l'administrateur
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * setter de l'attribut nom de l'administrateur
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * getter de l'attribut mdp de l'administrateur
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * setter de l'attribut mdp de l'administrateur
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	
	//methode toString
	@Override
	public String toString() {
		return "Administrateur [idAdmin=" + idAdmin + ", nom=" + nom + ", mdp=" + mdp + "]";
	}
	
	

}
