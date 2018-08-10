package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Categorie;

@Local
public interface ICategorieService {
	
	/**
	 * Méthode d'ajout d'une categorie
	 * @param cat, correspondant à une categorie
	 * @return Categorie
	 */
	public Categorie ajouterCat(Categorie cat);
	
	/**
	 * Méthode pour recuperer la liste des categories
	 * @return liste d'objet categorie
	 */
	public List<Categorie> getAllCategories();
	
	/**
	 * Méthode pour rechercher les données d'un objet categorie
	 * @param cat, correspondant à une categorie
	 * @return Categorie
	 */
	public Categorie getCatById(Categorie cat);
	
	/**
	 * Methode de modification d'une catégorie
	 * @param objet categorie, cat
	 * @return int
	 */
	public int modifierCat(Categorie cat);
	
	/**
	 * Methode de suppression d'une catégorie
	 * @param objet categorie, cat
	 * @return categorie
	 */
	public Categorie supprimerCat(Categorie cat);

}
