package fr.dawan.ioc.metier;

import fr.dawan.ioc.dao.IDao;

public class MetierImpl implements IMetier{

	//Déclare un variable IDao permettant le couplage faible
	private IDao dao;
	
	//Injection de dependance par setter
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	
	public double calcul() {
		double temp = dao.getValue();
		return temp*12;
	}

	
}
