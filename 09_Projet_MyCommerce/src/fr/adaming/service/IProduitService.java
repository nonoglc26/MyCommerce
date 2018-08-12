package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Local
public interface IProduitService {

	/**
	 * Methode liste 
	 * 
	 */
	public List<Produit> getAllProduit ();
	
	/**
	 * Methode ajouter produit
	 * 
	 */
	public Produit addProduit(Produit p);
	
	/**
	 * Methode Chercher un produit par son Id
	 * 
	 */
	public Produit getProduitById(Produit p);
	
	/**
	 * Methode supprimer un produit par son Id
	 * 
	 */
	public Produit deleteProduit(Produit p);
	
	/**
	 * Methode modifier un produit par son Id
	 * 
	 */
	public Produit updateProduit(Produit p);
	
	/**
	 * Méthode d'ajout d'un produit au panier
	 * @param p un objet produit
	 * @param nbr un int pour la quantité à ajouter
	 * @return une ligne de commande
	 */
	public LigneCommande ajoutProduitPanier(Produit p, int nbr);
	
}
