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

import org.primefaces.model.UploadedFile;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

/**
 * Managed Bean de la classe Categorie
 * 
 * @author Noélia Adaming
 *
 */
@ManagedBean(name = "catMB")
@RequestScoped
public class CategorieManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	// transfo de l'asso UML en JAVA
	@EJB
	private ICategorieService catService;

	// declaration des attributs
	private Categorie categorie;
	private List<Categorie> listeCat = new ArrayList<Categorie>();

	private UploadedFile file;

	// declaration des constructeurs
	/**
	 * Constructeur vide dans lequel on instancie une categorie
	 */
	public CategorieManagedBean() {
		super();
		this.categorie = new Categorie();
	}

	/**
	 * Methode init() qui s'effectura en PostConstruct
	 */
	@PostConstruct
	public void init() {
		listeCat = catService.getAllCategories();
	}

	// declaration des getter et setter
	/**
	 * getter de l'attribut categorie
	 * 
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * setter de l'attribut categorie
	 * 
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * getter de la liste de categorie
	 * 
	 * @return the listeCat
	 */
	public List<Categorie> getListeCat() {
		return listeCat;
	}

	/**
	 * setter de la liste de categorie
	 * 
	 * @param listeCat
	 *            the listeCat to set
	 */
	public void setListeCat(List<Categorie> listeCat) {
		this.listeCat = listeCat;
	}

	/**
	 * getter de l'attribut file
	 * 
	 * @return the file
	 */
	public UploadedFile getFile() {
		return file;
	}

	/**
	 * setter de l'attribut file
	 * 
	 * @param file
	 *            the file to set
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	// declaration des méthodes

	public String ajouterCategorie() {
		this.categorie.setPhoto(file.getContents());
		Categorie catAjout = catService.ajouterCat(this.categorie);
		if (catAjout != null) {
			return "accueil";
		} else {
			// afficher un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout de la categorie a échoué"));
			return "ajoutCat";
		}
	}

	public String rechercherCategorie() {
		Categorie catSearch = catService.getCatById(this.categorie);
		if (catSearch != null) {
			this.categorie = catSearch;
		} else {
			// afficher un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("La recherche a échoué: Id incorrect ?"));
		}
		return "ficheCat";
	}

	public String modifierCategorie() {
		this.categorie.setPhoto(file.getContents());
		int retour = catService.modifierCat(this.categorie);
		if (retour != 0) {
			return "accueil";
		} else {
			// afficher un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("La modification de la categorie a échoué"));
			return "modifCat";
		}
	}

	public String supprimerCategorie() {
		Categorie catOut = catService.supprimerCat(this.categorie);
		if (catOut != null) {
			// afficher un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("La suppression de la categorie a échoué"));
			return "supprCat";
		}else{
			return "accueil";
		}
	}

}
