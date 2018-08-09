package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;

@Local
public interface IClientDao {
	
	/**
	 * M�thode ajouter un produit dans la ligne de commande
	 * @param lc, correspondant � la ligne de coommande � ajouter dans la commande
	 * @return int, qui sera la quantit� de produit ajout�
	 */
	public int ajoutProduitLc(LigneCommande lc);
	
	/**
	 * M�thode d'ajout du client
	 * @param cl correspondant au client � ajouter
	 * @return client
	 */
	public Client ajouterCl(Client cl);
	
	/**
	 * Methode supprimer un client
	 * @param cl correspondant au client � supprimer
	 * @return client
	 */
	public  Client supprimerCl(Client cl);
	
	/**
	 * M�thode modifier un client
	 * @param cl correspondant au client � modifier
	 * @return int
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
