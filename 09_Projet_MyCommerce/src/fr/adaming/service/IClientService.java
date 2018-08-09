package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Client;

@Local
public interface IClientService {
	
	/**
	 * Méthode d'ajout du client
	 * @param cl correspondant au client à ajouter
	 * @return client
	 */
	public Client ajouterCl(Client cl);
	
	/**
	 * Méthode de suppression du client
	 * @param cl correspondant au client à supprimer
	 * @return client
	 */
	public  int supprimerCl(Client cl);
	
	/**
	 * Méthode modifier un client
	 * @param cl correspondant au client à modifier
	 * @return client
	 */
	public int modifierCl(Client cl);
	
	/**
	 * Méthode de recuperation de la liste des clients
	 * @return liste de clients
	 */
	public List<Client> getAllClients();
	
	/**
	 * Méthode de recuperation des données d'un client
	 * @param cl, dont on veut chercher les informations
	 * @return Client avec ses informations
	 */
	public Client getById (Client cl);
	
}
