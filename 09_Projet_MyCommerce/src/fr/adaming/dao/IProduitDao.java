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

	public List<Produit> getAllProduit ();
	public Produit addProduit(Produit p);
	public Produit getProduitById(Produit p);
	public Produit deleteProduit(Produit p);
	public Produit updateProduit(Produit p);
	
	

//	public Produit getProduitByNom (Administrateur ad);
//	public Produit updateProduit(Administrateur ad);

//	
//	
//	public List<Categorie> getAllCategorie(Administrateur ad);
//	public Categorie getCategorieById (Administrateur ad);
//	public Categorie getCategorieByNom (Administrateur ad);
//	public Categorie addCategorie(Administrateur ad);
//	public Categorie updateCategorie(Administrateur ad);
//	public Categorie deleteCategorie(Administrateur ad);
	
	
	
}
