package fr.dawan.ioc.dao;

public class DaoImpl implements IDao{

	public double getValue() {
		//Se connecter à la base de données pour récuperer la temperature
		double data = 5;
		return data;
	}

}
