package fr.dawan.ioc.presentation;

import fr.dawan.ioc.dao.DaoImpl;
import fr.dawan.ioc.dao.extensions.DaoImplV2;
import fr.dawan.ioc.metier.MetierImpl;

/*
 * Mauvaise méthode : Utilisation de l'instanciation statique
 * 
 */
public class PresentationV1 {

	public static void main(String[] args) {
		
		//Création d'un objet dao
		DaoImpl dao = new DaoImpl();
		
		//Creation d'un objet daoV2 (deuxième version)
		DaoImplV2 daoV2 = new DaoImplV2();
		
		//Création d'un objet métier
		MetierImpl metier = new MetierImpl();
		

		/*
		 * 	L'association entre l'objet metier et l'objet dao 
		 *  ===> Injection de dependance
		 */
		metier.setDao(daoV2);
		
		System.out.println(metier.calcul());
	}

}
