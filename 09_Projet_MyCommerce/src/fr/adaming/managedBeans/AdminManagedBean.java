package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Administrateur;
import fr.adaming.service.IAdminService;


/**
 * Administrateur JavaBean
 * Amandine
 * Methode identification mot de passe
 */

@ManagedBean(name="adMB")
@RequestScoped
public class AdminManagedBean implements Serializable{

	@EJB
	private IAdminService adService;
	
	//Declaration des attributs
	private Administrateur ad;

	
	
	//Constructeur vide
	/**
	 * Constructeur vide
	 */
	public AdminManagedBean() {
		super();
	}


	//Getter et Setters
	/**
	 * @return the ad
	 */
	public Administrateur getAd() {
		return ad;
	}



	/**
	 * @param ad the ad to set
	 */
	public void setAd(Administrateur ad) {
		this.ad = ad;
	}
	

	public String seConnecter(){
		//Vérifier l'existance de l'administrateur 
		Administrateur adExist=adService.isExist(ad);
		if(adExist!=null){
			return "accueilAd";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'administrateur est introuvable!"));
			return "loginAd";
		}
		
		
	}
	
	
}
