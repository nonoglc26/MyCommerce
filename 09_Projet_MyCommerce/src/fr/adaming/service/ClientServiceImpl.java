package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Stateful
public class ClientServiceImpl implements IClientService{
	
	//transfo de l'asso UML en JAVA
	@EJB
	private IClientDao clDao;

	@Override
	public Client ajouterCl(Client cl) {
		return clDao.ajouterCl(cl);
	}

	@Override
	public int supprimerCl(Client cl) {
		return clDao.supprimerCl(cl);
	}

	@Override
	public int modifierCl(Client cl) {
		return clDao.modifierCl(cl);
	}

	@Override
	public List<Client> getAllClients() {
		return clDao.getAllClients();
	}

	@Override
	public Client getById(Client cl) {
		return clDao.getById(cl);
	}

	@Override
	public Client authentifier(Client cl) {
		return clDao.authentifier(cl);
	}

}
