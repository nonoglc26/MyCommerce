package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

/**
 * Managed Bean du Client
 * 
 * @author Noelia Adaming
 *
 */

@ManagedBean(name = "clMB")
@RequestScoped
public class ClientManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	// transfo de l'asso UML en JAVA
	@EJB
	private IClientService clService;

	// declaration d'un client
	private Client client;

	private List<Client> liste = new ArrayList<Client>();

	// declaration d'un constructeur
	/**
	 * Constructeur vide dans lequel on instancie un client
	 * 
	 * @param client
	 */
	public ClientManagedBean() {
		super();
		this.client = new Client();
	}

	/**
	 * Methode init() qui s'effectura en PostConstruct
	 */
	@PostConstruct
	public void init() {
		liste = clService.getAllClients();
	}

	// declaration des getter et setter

	/**
	 * getter du client instancié dans le Managed Bean
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * setter du client instancié dans le Managed Bean
	 * 
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * getter de la liste de clients
	 * 
	 * @return the liste
	 */
	public List<Client> getListe() {
		return liste;
	}

	/**
	 * setter de la liste de clients
	 * 
	 * @param liste
	 *            the liste to set
	 */
	public void setListe(List<Client> liste) {
		this.liste = liste;
	}

	// declaration des méthodes
	public String ajouterClient() {
		Client clAjout = clService.ajouterCl(this.client);
		if (clAjout != null) {
			return "accueil";
		} else {
			// afficher un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout du client a échoué"));
			return "ajoutCl";
		}
	}

	public String modifierClient() {
		int retour = clService.modifierCl(this.client);
		if (retour != 0) {
			return "accueil";
		} else {
			// afficher un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La modification du client a échoué"));
			return "modifCl";
		}
	}

	public String supprimerClient() {
		int retour = clService.supprimerCl(this.client);
		if (retour != 0) {
			return "accueil";
		} else {
			// afficher un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La suppression du client a échoué"));
			return "supprCl";
		}
	}

	public String ficheClient() {
		Client clOut = clService.getById(this.client);
		if (clOut != null) {
			this.client = clOut;
		} else {
			// afficher un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("La recherche a échoué : ID incorrect ?"));
		}
		return "ficheCl";
	}

	public String connexionClient() {
		Client clOut = clService.authentifier(this.client);
		if (clOut != null) {
			return "accueil";
		} else {
			// afficher un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email ou mot de passe incorrect"));
			return "connectClient";
		}

	}

}
