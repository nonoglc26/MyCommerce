package fr.adaming.service;

import javax.ejb.Local;

import fr.adaming.model.Client;

@Local
public interface ICommandeService {
	
	/**
	 * M�thode d'envoi d'un mail apr�s commande pass�e
	 * @param client
	 */
	public void envoyerMail(Client cl);

}
