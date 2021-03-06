package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;

@Stateless
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext(unitName = "PU_MyCommerce")
	private EntityManager em;

	@Override
	public Client ajouterCl(Client cl) {
		em.persist(cl);
		return cl;
	}

	@Override
	public int supprimerCl(Client cl) {
		Client clOut=em.find(Client.class, cl.getIdClient());
		try{
			em.remove(clOut);
			return 1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int modifierCl(Client cl) {
		// creation de la requete JPQL
		String req = "UPDATE Client cl SET cl.nomClient=:pNom, cl.adresse=:pAdr, cl.email=:pMail, cl.tel=:pTel, cl.mdp=:pMdp WHERE cl.idClient=:pId";

		// envoi de la requete et passage des paramètres
		Query query = em.createQuery(req);
		query.setParameter("pNom", cl.getNomClient());
		query.setParameter("pAdr", cl.getAdresse());
		query.setParameter("pMail", cl.getEmail());
		query.setParameter("pTel", cl.getTel());
		query.setParameter("pMdp", cl.getMdp());
		query.setParameter("pId", cl.getIdClient());

		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClients() {
		// requete JPQL
		String req = "SELECT cl FROM Client cl";

		// envoi de la requete
		Query query = em.createQuery(req);

		return query.getResultList();
	}

	@Override
	public Client getById(Client cl) {
		return em.find(Client.class, cl.getIdClient());
	}

	@Override
	public Client authentifier(Client cl) {
		// creation de la requete
		String req="SELECT cl FROM Client cl WHERE cl.email=:pMail AND cl.mdp=:pMdp";
		
		//envoi de la requete
		Query query=em.createQuery(req);
		query.setParameter("pMail", cl.getEmail());
		query.setParameter("pMdp", cl.getMdp());
		
		return (Client) query.getSingleResult();
	}

}
