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
	public int ajoutProduitLc(LigneCommande lc) {
		// creation de la requete en JPQL
		String req = "INSERT INTO LigneCommande lc (lc.quantite, lc.produit, lc.prix) VALUES (pQuantite, pProduit, pPrix) WHERE lc.commande=:pCommande";

		// envoi de la requete et passage des paramètres
		Query query = em.createQuery(req);
		query.setParameter("pQuantite", lc.getQuantite());
		query.setParameter("pProduit", lc.getProduit().getIdProduit());
		query.setParameter("pPrix", lc.getPrix());
		query.setParameter("pCommande", lc.getCommande().getIdCommande());

		query.executeUpdate();

		return lc.getQuantite();
	}

	@Override
	public Client ajouterCl(Client cl) {
		em.persist(cl);
		return cl;
	}

	@Override
	public Client supprimerCl(Client cl) {
		Client clOut = em.find(Client.class, cl.getIdClient());
		em.remove(clOut);
		return clOut;
	}

	@Override
	public int modifierCl(Client cl) {
		Client clOut=em.find(Client.class, cl.getIdClient());
		
		//creation de la requete JPQL
		String req="UPDATE Client cl SET cl.nomClient=:pNom, cl.adresse=:pAdr, cl.email=:pMail, cl.tel=:pTel, cl.mdp=:pMdp ";
				
		//envoi de la requete et passage des paramètres
		Query query=em.createQuery(req);
		query.setParameter("pNom", clOut.getNomClient());
		query.setParameter("pAdr", clOut.getAdresse());
		query.setParameter("pMail", clOut.getEmail());
		query.setParameter("pTel", clOut.getTel());
		query.setParameter("pMdp", clOut.getMdp());
		
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
		// requete JPQL
		String req = "SELECT cl FROM Client cl WHERE cl.idClient=:pId";

		// envoi de la requete
		Query query = em.createQuery(req);
		query.setParameter("pId", cl.getIdClient());

		return (Client) query.getSingleResult();
	}

}
