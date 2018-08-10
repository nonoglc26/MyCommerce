package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class LigneCoDaoImpl implements ILigneCoDao {
	
	//transfo de l'asso UML en JAVA
	@PersistenceContext(unitName = "PU_MyCommerce")
	private EntityManager em;



}
