package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;


import fr.adaming.model.Produit;

/**
 * Classe produit
 * @author Amandine Adaming
 * 
 */

@Stateless
public class ProduitDaoImpl implements IProduitDao{

	
	@PersistenceContext(unitName="PU_MyCommerce")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduit(Produit p) {
		String req="Select p From Produit as p where ca_id=?";
		
		Query query=em.createQuery(req);
		
		query.setParameter("pCa_id", p.getCategorie().getIdCategorie());
		
		 List<Produit>  listeProduits=query.getResultList();
		 for(Produit pr: listeProduits){
			 pr.setImage("data:image/png;base64,"+Base64.encodeBase64String(pr.getPhoto()));
		 }
		 
		 return listeProduits;
	}

	@Override
	public int addProduit(Produit p) {
		String req="Insert Into Produits p (p.designation=:pDesignation, p.description=:pDescription, p.prix=:pPrix, p.quantite=:pQuantite, p.photo=:pPhoto, p.nomCategorie=:pNomCategorie ) Values ( ?, ?, ?, ?, ?, ?)";
	
		Query query=em.createQuery(req);
		
		//Passage des paramètres
		query.setParameter("pDesignation", p.getDesignation());
		query.setParameter("pDescription", p.getDescription());
		query.setParameter("pPrix", p.getPrix());
		query.setParameter("pQuantite", p.getQuantite());
		query.setParameter("pPhoto", p.getPhoto());
		query.setParameter("pCa_id", p.getCategorie().getNomCategorie());
		
		return query.executeUpdate();
		
	
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
