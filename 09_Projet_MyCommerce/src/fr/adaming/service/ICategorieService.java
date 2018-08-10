package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Categorie;

@Local
public interface ICategorieService {
	
	/**
	 * M�thode d'ajout d'une categorie
	 * @param cat, correspondant � une categorie
	 * @return Categorie
	 */
	public Categorie ajouterCat(Categorie cat);
	
	/**
	 * M�thode pour recuperer la liste des categories
	 * @return liste d'objet categorie
	 */
	public List<Categorie> getAllCategories();
	
	/**
	 * M�thode pour rechercher les donn�es d'un objet categorie
	 * @param cat, correspondant � une categorie
	 * @return Categorie
	 */
	public Categorie getCatById(Categorie cat);
	
	/**
	 * Methode de modification d'une cat�gorie
	 * @param objet categorie, cat
	 * @return int
	 */
	public int modifierCat(Categorie cat);
	
	/**
	 * Methode de suppression d'une cat�gorie
	 * @param objet categorie, cat
	 * @return categorie
	 */
	public Categorie supprimerCat(Categorie cat);

}
