package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Administrateur;


@Stateless
public class AdminDaoImpl implements IAdminDao{

	@PersistenceContext(unitName="PU_MyCommerce")
	private EntityManager em;
	
	@Override
	public Administrateur isExist(Administrateur ad) {

		try {
			String req = "select ad from Administrateur as ad where ad.nom=:pNom and ad.mdp=:pMdp";

		
			// recuperer le Query (de persistence)
			Query query = em.createQuery(req);

			// Passage des paramètres
			query.setParameter("pNom", ad.getNom());
			query.setParameter("pMdp", ad.getMdp());

			//try catch car getSingleResult retourne beaucoup d'exceptions que l'on doit gérer
			return  (Administrateur) query.getSingleResult();

		} catch (NoResultException ex) {

			ex.printStackTrace();
		}
		return null;

}
	}
