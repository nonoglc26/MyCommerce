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
	
	
	@Override
	public List<Produit> getAllProduit() {
		return pDao.getAllProduit();
	}


	@Override
	public Produit addProduit(Produit p) {
		return pDao.addProduit(p);
	}


	@Override
	public Produit getProduitById(Produit p) {
		return pDao.getProduitById(p);
	}


	@Override
	public Produit deleteProduit(Produit p) {
		return pDao.deleteProduit(p);
	}


	@Override
	public Produit updateProduit(Produit p) {
		return pDao.updateProduit(p);
	}

	

}
