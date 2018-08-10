package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

@Stateful
public class ProduitServiceImpl implements IProduitService{

	@EJB
	private IProduitDao pDao;
	
	/**
	 * Methode liste OK
	 * 
	 */
	@Override
	public List<Produit> getAllProduit() {
		return pDao.getAllProduit();
	}
	
	/**
	 * Methode ajouter produit Ok
	 * 
	 */
	@Override
	public Produit addProduit(Produit p) {
		return pDao.addProduit(p);
	}

	/**
	 * Methode Chercher un produit par son Id
	 * 
	 */
	@Override
	public Produit getProduitById(Produit p) {
		return pDao.getProduitById(p);
	}

	/**
	 * Methode supprimer un produit par son Id
	 * 
	 */
	@Override
	public Produit deleteProduit(Produit p) {
		return pDao.deleteProduit(p);
	}

	/**
	 * Methode modifier un produit par son Id
	 * 
	 */
	@Override
	public Produit updateProduit(Produit p) {
		return pDao.updateProduit(p);
	}

	

}
