package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

/**
 * ManagedBean Administrateur Amandine
 * 
 */

@ManagedBean(name = "pMB")
@RequestScoped
public class ProduitManagedBean implements Serializable {

	@EJB
	private IProduitService pService;

	// Attributs
	private Administrateur ad;
	private Produit p;

	private UploadedFile file;

	private List<Produit> listeProduit;

	// Constructeur vide
	/**
	 * 
	 */
	public ProduitManagedBean() {
		super();
		this.p = new Produit();
	}

	// getters et Setters
	/**
	 * @return the ad
	 */
	public Administrateur getAd() {
		return ad;
	}

	/**
	 * @param ad
	 *            the ad to set
	 */
	public void setAd(Administrateur ad) {
		this.ad = ad;
	}

	/**
	 * @return the p
	 */
	public Produit getP() {
		return p;
	}

	/**
	 * @return the file
	 */
	public UploadedFile getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	/**
	 * @param p
	 *            the p to set
	 */
	public void setP(Produit p) {
		this.p = pService.getProduitById(this.p);
	}
	
	

	/**
	 * @return the listeProduit
	 */
	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	/**
	 * @param listeProduit the listeProduit to set
	 */
	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	public String rechercherProduit() {

		
		Produit pOut = pService.getProduitById(this.p);

		if (pOut != null) {
			// reccuperer le produit rechercgé
			this.p = pOut;

		} else {
			// ajouter un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La recherche a échoué"));
		}
		return "rechercheProduit";
	}


	/**
	 * Methode ajouter OK
	 * 
	 */
	public String ajouterProduit() {
		this.p.setPhoto(file.getContents());
		Produit pAjout = pService.addProduit(this.p);

		if (pAjout != null) {
			// recuperer la liste des produits
			
			listeProduit= pService.getAllProduit();
			return "listeProduit";

		} else {
			// ajouter un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout a échoué"));
			return "ajoutProduit";
		}

	}
	
	/**
	 * Methode supprimer OK
	 * 
	 */

	public String SupprimerProduit() {
		Produit pSup = pService.deleteProduit(this.p);
		if (pSup != null) {
			listeProduit = pService.getAllProduit();
			return "listeProduit";
		} else {
			// ajouter un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La modification a échoué"));
			return "supprimerProduit";
		}
	}
	/**
	 * Methode afficher liste
	 * 
	 */

	public String AfficherListe() {
		@SuppressWarnings("unused")
		List<Produit> listeProduit = pService.getAllProduit();
		return "listeProduit";
	}
	


	/**
	 * Methode modifier
	 * 
	 */
	
	public String ModifierProduit(){
		this.p.setPhoto(file.getContents());
		Produit pModif =pService.updateProduit(this.p);
		if(pModif!=null){
			listeProduit= pService.getAllProduit();
			return "listeProduit";
		}else{
			// ajouter un message d'erreur
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La modification a échoué"));
				return "modifierProduit";
		}
	}
	
}
