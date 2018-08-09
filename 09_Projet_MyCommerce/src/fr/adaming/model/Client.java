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
 * Classe Client
 * 	Classe persistante
 * 	association OneToMany avec la classe Commande
 * 	
 */

@Entity
@Table(name="clients")
public class Client {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cl")
	private long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;
	private String mdp;
	
	
	//Transformation de l'association UML en Java
	@ManyToOne
	@JoinColumn(name="co-id", referencedColumnName="id_co")
	private Commande commande;
	
	
	//Constructeurs
	
	/**
	 * Constructeur vide
	 */
	public Client() {
		super();
	}


	/**
	 * Constructeur avec parametres avec id
	 * @param idClient
	 * @param nomClient
	 * @param adresse
	 * @param email
	 * @param tel
	 * @param mdp
	 */
	public Client(long idClient, String nomClient, String adresse, String email, String tel, String mdp) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.mdp = mdp;
	}


	/**
	 * Constructeur avec parametres sans id
	 * @param nomClient
	 * @param adresse
	 * @param email
	 * @param tel
	 * @param mdp
	 */
	public Client(String nomClient, String adresse, String email, String tel, String mdp) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.mdp = mdp;
	}


	/**
	 * Constructeur avec parametres 
	 * @param email
	 * @param mdp
	 */
	public Client(String email, String mdp) {
		super();
		this.email = email;
		this.mdp = mdp;
	}


	
	//Getters et Setters
	/**
	 * 
	 * getters
	 * @return the idClient
	 */
	public long getIdClient() {
		return idClient;
	}


	/**
	 * Setters
	 * @param idClient the idClient to set
	 */
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}


	/**
	 * getters
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}


	/**
	 * setters
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	/**
	 * getters
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * setters
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * getters
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * setters
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * getters
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}


	/**
	 * setters
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}


	/**
	 * getters
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}


	/**
	 * setters
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}




	
	
	
	
}
