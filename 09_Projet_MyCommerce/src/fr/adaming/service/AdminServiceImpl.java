package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Administrateur;


@Stateless
public class AdminServiceImpl implements IAdminService{

	@EJB
	private IAdminDao adDao;
	
	
	@Override
	public Administrateur isExist(Administrateur ad) {
		
		return adDao.isExist(ad);
	}

}
