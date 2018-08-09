package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Client;

@Local
public interface IClientService {
	
	/**
	 * M�thode d'ajout du client
	 * @param cl correspondant au client � ajouter
	 * @return client
	 */
	public Client ajouterCl(Client cl);
	
	/**
	 * M�thode de suppression du client
	 * @param cl correspondant au client � supprimer
	 * @return client
	 */
	public  int supprimerCl(Client cl);
	
	/**
	 * M�thode modifier un client
	 * @param cl correspondant au client � modifier
	 * @return client
	 */
	public int modifierCl(Client cl);
	
	/**
	 * M�thode de recuperation de la liste des clients
	 * @return liste de clients
	 */
	public List<Client> getAllClients();
	
	/**
	 * M�thode de recuperation des donn�es d'un client
	 * @param cl, dont on veut chercher les informations
	 * @return Client avec ses informations
	 */
	public Client getById (Client cl);
	
}
