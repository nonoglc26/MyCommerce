package fr.adaming.dao;

import javax.ejb.Local;

import fr.adaming.model.Categorie;

@Local
public interface ICategorieDao {
	
	public Categorie ajouterCat(Categorie cat);

}
