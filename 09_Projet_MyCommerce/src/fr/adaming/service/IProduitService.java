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

	
	
	
	
}
