package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Produit;

/**
 * IProduitDao
 * Amandine
 * 
 */

@Local
public interface IProduitDao {

	public List<Produit> getAllProduit (Produit p);
	public int addProduit(Produit p);
	public Produit getProduitById(Produit p);
	public Produit deleteProduit(Produit p);
	public Produit updateProduit(Produit p);
	
	

//	public Produit getProduitByNom (Administrateur ad);


	
	
}
