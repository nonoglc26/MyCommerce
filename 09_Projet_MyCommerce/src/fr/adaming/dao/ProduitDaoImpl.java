package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao{

	
	@PersistenceContext(unitName="PU_MyCommerce")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduit() {
		String req="Select p From Produit as p";
		
		Query query=em.createQuery(req);
		
		
		
		 List<Produit>  listeProduits=query.getResultList();
		 for(Produit pr: listeProduits){
			 pr.setImage("data:image/png;base64,"+Base64.encodeBase64String(pr.getPhoto()));
		 }
		 
		 return listeProduits;
	}

	@Override
	public Produit addProduit(Produit p) {
		em.persist(p);
		return p;
	}

	@Override
	public Produit getProduitById(Produit p) {
		Produit pr=em.find(Produit.class, p.getIdProduit());
		 pr.setImage("data:image/png;base64,"+Base64.encodeBase64String(pr.getPhoto()));
		return pr;
	}

	@Override
	public Produit deleteProduit(Produit p) {
		Produit pr=em.find(Produit.class, p.getIdProduit());
		try{
			em.remove(pr);
			return pr;
			
		}catch(Exception ex){
		ex.printStackTrace();
		}
		return null;
	}
		

	@Override
	public Produit updateProduit(Produit p) {
		Produit pr=em.find(Produit.class, p.getIdProduit());
		pr.setImage("data:image/png;base64,"+Base64.encodeBase64String(pr.getPhoto()));
		em.merge(p);
		return p;
	}

	
	
	
}
