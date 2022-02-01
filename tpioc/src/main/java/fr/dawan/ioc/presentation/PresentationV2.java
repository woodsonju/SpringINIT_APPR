package fr.dawan.ioc.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import fr.dawan.ioc.dao.IDao;
import fr.dawan.ioc.metier.IMetier;

/*
 * On va utiliser l'instanciation dynamique
 * et un fichier de configuration
 */
public class PresentationV2 {

	public static void main(String[] args) {
		try {
			//new File("config.txt") :
			//	va permettre de lire le fichier config.txt
			Scanner input = new Scanner(new File("config.txt"));
			
			//Lire la classe DaoImpl
			//La méthode next lit la première ligne
			String daoClassName = input.next();
			
			//Lire la classe MetierImpl
			//La méthode next lit la ligne suivante
			String metierClassName = input.next();
			
			System.out.println(daoClassName);
			System.out.println(metierClassName);
			
			//Charger dynamiquement la classe DaoImpl en mémoire
			Class cDao = Class.forName(daoClassName);
			
			//Instanciation de la classe DaoImpl : Utilisation de la méthode newInstance
			IDao dao  = (IDao) cDao.newInstance();
			
			//Pour verifier si ça fonctionne j'apppelle la méthode getValue
			System.out.println(dao.getValue());
			
			//Charger dynamiquement la class MetierIml en memoire 
			Class cMetier = Class.forName(metierClassName);
			
			//Instanciation de la MetierIml : Utilisataion de la méthode new Instance
			IMetier metier   = (IMetier) cMetier.newInstance();
			
			//La méthode setDao, on va l'appeler par reflexon
			//Puis, on va créer un objet de type Méthode
			Method m1 = cMetier.getMethod("setDao", new Class[] {IDao.class});
			
			//Execution de la méthode : appel de la méthode invoke
			//Premier paramètre la méthode invoke : L'instance sur laquelle la méthode doit être invoquée(métier)
			//On fait l'injection de dependance en associant l'objet métier et l'objet Dao 
			m1.invoke(metier, new Object[] {dao});
			
			//Afficher le resultat en appelant la méthode calcul
			
			System.out.println(metier.calcul());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
