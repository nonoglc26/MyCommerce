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
import javax.servlet.http.HttpSession;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

/**
 * Managed Bean du Panier
 * 
 * @author NGLC Adaming
 *
 */
@ManagedBean(name="paMB")
@RequestScoped
public class PanierManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//transfo de l'asso UML en JAVA
	@EJB
	private IProduitService pService;

	// declaration des attributs
	private Panier panier;
	private Produit produit;
	private int nbr;
	private LigneCommande ligneCo;
	private List<LigneCommande> listeCom= new ArrayList<LigneCommande>();

	// declarer une session pour y mettre ensuite le panier
	private HttpSession maSession;

	// declaration du constructeur
	/**
	 * Constructeur vide dans lequel on instancie un panier, un produit et une
	 * ligne de commande
	 */
	public PanierManagedBean() {
		super();
		this.panier = new Panier();
		this.panier.setListeLigneCommande(listeCom);
		this.produit = new Produit();
		this.ligneCo = new LigneCommande();
	}

	@PostConstruct
	public void init() {
		// recuperer la session
		maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		// creer un attribut panier dans la session
		panier = (Panier) maSession.getAttribute("panierSession");
	}
	

	// declaration des getter et setter
	/**
	 * getter du panier
	 * @return the panier
	 */
	public Panier getPanier() {
		return panier;
	}

	/**
	 * setter du panier
	 * 
	 * @param panier
	 *            the panier to set
	 */
	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	/**
	 * getter du produit
	 * 
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}

	/**
	 * setter du produit
	 * 
	 * @param produit
	 *            the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	/**
	 * getter du nbr, c'est à dire de la quantité demandée du produit
	 * 
	 * @return the nbr
	 */
	public int getNbr() {
		return nbr;
	}

	/**
	 * setter du nbr, c'est à dire de la quantité demandée du produit
	 * 
	 * @param nbr
	 *            the nbr to set
	 */
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	/**
	 * getter de la ligne de commande
	 * @return the ligneCo
	 */
	public LigneCommande getLigneCo() {
		return ligneCo;
	}

	/**
	 * setter de la ligne de commande
	 * @param ligneCo the ligneCo to set
	 */
	public void setLigneCo(LigneCommande ligneCo) {
		this.ligneCo = ligneCo;
	}

	// declaration de la méthode
	public String ajouterProdPanier() {
		Panier panierSession = (Panier) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("panierSession");

		List<LigneCommande> newListe = new ArrayList<LigneCommande>();

		// si le panier de la session existe et si il n'est pas vide, on va
		// ajouter chaque element de la vieille liste (lignes de commande deja
		// presentes) dans la nouvelle
		if (panierSession != null) {
			if (panierSession.getListeLigneCommande() != null) {
				List<LigneCommande> oldListe = panierSession.getListeLigneCommande();

				for (LigneCommande elem : oldListe) {
					newListe.add(elem);
				}
			}
		}
		
		//on va ensuite recuperer l'id du produit que le client veut ajouter
		Produit newProd=pService.getProduitById(this.produit);
		
		//creation de la nouvelle ligne de commande
		ligneCo=pService.ajoutProduitPanier(newProd, nbr);
		
		if(ligneCo!=null){
			//ajout de la nouvelle ligne de commande à la newListe
			newListe.add(ligneCo);
			
			//on attribue la nouvelle liste de ligne de commande avec tous les produits, au panier
			panier.setListeLigneCommande(newListe);
			
			//sauvegarde de ce nouveau panier dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("panierSession", panier);
			
			return "panier";
		}else{
			//message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout du produit à votre panier a échoué !"));
			
			return "accueil";
		}
		
	}

}
