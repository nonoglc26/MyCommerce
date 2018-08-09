package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Produit;

@Local
public interface IProduitService {

	public List<Produit> getAllProduit ();
	public Produit addProduit(Produit p);
	public Produit getProduitById(Produit p);
	public Produit deleteProduit(Produit p);
	public Produit updateProduit(Produit p);

//	public Produit getProduitByNom (Produit p);
//	public Produit updateProduit(Produit p);
	

//	public List<Categorie> getAllCategorie(Administrateur ad);
//	public Categorie getCategorieById (Categorie ca, Administrateur ad);
//	public Categorie getCategorieByNom (Categorie ca,Administrateur ad);
//	public Categorie addCategorie(Categorie ca,Administrateur ad);
//	public Categorie updateCategorie(Categorie ca, Administrateur ad);
//	public Categorie deleteCategorie(Categorie ca, Administrateur ad);
	
	
	
	
}
