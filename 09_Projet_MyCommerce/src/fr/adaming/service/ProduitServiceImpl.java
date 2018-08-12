package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;


/**
 * Classe produit Service
 * @author Amandine Adaming
 * 
 */
@Stateful
public class ProduitServiceImpl implements IProduitService{

	@EJB
	private IProduitDao pDao;
	
	
	@Override
	public List<Produit> getAllProduit(Produit p) {
		return pDao.getAllProduit(p);
	}
	
	
	@Override
	public int addProduit(Produit p) {
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

	@Override
	public LigneCommande ajoutProduitPanier(Produit p, int nbr) {
		// instancier une ligne de commande
		LigneCommande LC=new LigneCommande();
		
		//verifier que la quantite demandée est inférieur ou égale à la quantité en stock
		if(nbr <= p.getQuantite()){
			LC.setProduit(p);
			LC.setQuantite(nbr);
			LC.setPrix(p.getPrix()*nbr);
			return LC;
		}else{
			return null;
		}
	}

	

}
