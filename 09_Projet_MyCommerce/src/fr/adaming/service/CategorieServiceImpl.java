package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

@Stateful
public class CategorieServiceImpl implements ICategorieService{
	
	//transfo de l'asso UML en JAVA
	@EJB
	private ICategorieDao catDao;

	@Override
	public Categorie ajouterCat(Categorie cat) {
		return catDao.ajouterCat(cat);
	}

	@Override
	public List<Categorie> getAllCategories() {
		return catDao.getAllCategories();
	}

	@Override
	public Categorie getCatById(Categorie cat) {
		return catDao.getCatById(cat);
	}

	@Override
	public int modifierCat(Categorie cat) {
		return catDao.modifierCat(cat);
	}

	@Override
	public Categorie supprimerCat(Categorie cat) {
		return catDao.supprimerCat(cat);
	}

}
