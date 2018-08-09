package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao{

	
	@PersistenceContext(unitName="PU_MyCommerce")
	private EntityManager em;
	
	@Override
	public List<Produit> getAllProduit() {
		String req="Select p From Produit as p";
		
		Query query=em.createQuery(req)
;
		return query.getResultList();
	}

	@Override
	public Produit addProduit(Produit p) {
		em.persist(p);
		return p;
	}

	
	
	
}
