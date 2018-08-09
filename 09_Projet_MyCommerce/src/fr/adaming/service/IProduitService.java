package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Produit;

@Local
public interface IProduitService {

	public List<Produit> getAllProduit ();
//	public Produit getProduitById (Produit p, Administrateur ad);
//	public Produit getProduitByNom (Produit p,Administrateur ad);
//	public Produit addProduit(Produit p, Administrateur ad);
//	public Produit updateProduit(Produit p,Administrateur ad);
//	public Produit deleteProduit(Produit p, Administrateur ad);
//	
//	
//	public List<Categorie> getAllCategorie(Administrateur ad);
//	public Categorie getCategorieById (Categorie ca, Administrateur ad);
//	public Categorie getCategorieByNom (Categorie ca,Administrateur ad);
//	public Categorie addCategorie(Categorie ca,Administrateur ad);
//	public Categorie updateCategorie(Categorie ca, Administrateur ad);
//	public Categorie deleteCategorie(Categorie ca, Administrateur ad);
	
	
	
	
}
