package fr.adaming.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Panier
 * classe transiente
 * association avec la classe ligne de commande
 * 	@author Adaming
 */

public class Panier {

	
	//Transformation de l'association UML en java
	private List<LigneCommande> listeLigneCommande= new ArrayList<LigneCommande>();

	//declaration du constructeur vide
	/**
	 * Constructeur vide
	 */
	public Panier() {
		super();
	}

	//declaration des getter et setter
	/**
	 * getter de la liste de ligne de commande
	 * @return the listeLigneCommande
	 */
	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}

	/**
	 * setter de la liste de ligne de commande
	 * @param listeLigneCommande the listeLigneCommande to set
	 */
	public void setListeLigneCommande(List<LigneCommande> listeLigneCommande) {
		this.listeLigneCommande = listeLigneCommande;
	}

	
	
	//methode toString
	@Override
	public String toString() {
		return "Panier [listeLigneCommande=" + listeLigneCommande + "]";
	}
	
	
	
}
