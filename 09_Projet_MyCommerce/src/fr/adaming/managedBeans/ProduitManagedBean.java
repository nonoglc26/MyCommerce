package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;


/**
 * ManagedBean Administrateur
 * Amandine
 * 
 */

@ManagedBean(name="adMB")
@RequestScoped
public class ProduitManagedBean implements Serializable{

	@EJB
	private IProduitService adService;
	
	//Attributs
	private Administrateur ad;
	private Produit p;
	
	
	
	//Constructeur vide
	/**
	 * 
	 */
	public ProduitManagedBean() {
		super();
	}


	
	//getters et Setters
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



	/**
	 * @return the p
	 */
	public Produit getP() {
		return p;
	}



	/**
	 * @param p the p to set
	 */
	public void setP(Produit p) {
		this.p = p;
	}
	
	

	

	
	
	
	
	
	
	
	
}
