package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

import fr.adaming.model.Categorie;

@Stateless
public class CategorieDaoImpl implements ICategorieDao {

	@PersistenceContext(unitName = "PU_MyCommerce")
	private EntityManager em;

	@Override
	public Categorie ajouterCat(Categorie cat) {
		em.persist(cat);
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getAllCategories() {
		// creation de la requete
		String req = "SELECT cat FROM Categorie cat";

		// envoi de la requete
		Query query = em.createQuery(req);

		// recup les resultats
		List<Categorie> listeCat = query.getResultList();
		for (Categorie cate : listeCat) {
			cate.setImage("data:image/png;base64," + Base64.encodeBase64String(cate.getPhoto()));
		}

		return listeCat;
	}

	@Override
	public Categorie getCatById(Categorie cat) {
		Categorie cate = em.find(Categorie.class, cat.getIdCategorie());
		cate.setImage("data:image/png;base64," + Base64.encodeBase64String(cate.getPhoto()));
		return cate;
	}

	@Override
	public int modifierCat(Categorie cat) {
		// creation de la requete JPQL
		String req = "UPDATE Categorie ca SET ca.nomCategorie=:pNom, ca.photo=:pPhoto, ca.description=:pDesc WHERE ca.idCategorie=:pId";

		// envoi de la requete et passage des paramètres
		Query query = em.createQuery(req);
		query.setParameter("pNom", cat.getNomCategorie());
		query.setParameter("pPhoto", cat.getPhoto());
		query.setParameter("pDesc", cat.getDescription());
		query.setParameter("pId", cat.getIdCategorie());
		

		return query.executeUpdate();
	}

	@Override
	public Categorie supprimerCat(Categorie cat) {
		Categorie catOut = em.find(Categorie.class, cat.getIdCategorie());
		try {
			em.remove(catOut);
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return catOut;

	}

}
