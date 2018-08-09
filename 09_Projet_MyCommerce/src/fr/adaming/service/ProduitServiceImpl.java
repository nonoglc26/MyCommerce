package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

@Stateful
public class ProduitServiceImpl implements IProduitService{

	@EJB
	private IProduitDao adDao;
	
	
	@Override
	public List<Produit> getAllProduit() {
		return adDao.getAllProduit();
	}

	

}
