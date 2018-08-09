package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;

@Local
public interface IClientDao {
	
	/**
	 * Méthode ajouter un produit dans la ligne de commande
	 * @param lc, correspondant à la ligne de coommande à ajouter dans la commande
	 * @return int, qui sera la quantité de produit ajouté
	 */
	public int ajoutProduitLc(LigneCommande lc);
	
	/**
	 * Méthode d'ajout du client
	 * @param cl correspondant au client à ajouter
	 * @return client
	 */
	public Client ajouterCl(Client cl);
	
	/**
	 * Methode supprimer un client
	 * @param cl correspondant au client à supprimer
	 * @return client
	 */
	public  Client supprimerCl(Client cl);
	
	/**
	 * Méthode modifier un client
	 * @param cl correspondant au client à modifier
	 * @return int
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
