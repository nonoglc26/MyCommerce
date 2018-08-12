package fr.adaming.service;

import javax.ejb.Local;

import fr.adaming.model.Client;

@Local
public interface ICommandeService {
	
	/**
	 * Méthode d'envoi d'un mail après commande passée
	 * @param client
	 */
	public void envoyerMail(Client cl);

}
