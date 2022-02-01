package fr.dawan.ioc.presentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.dawan.ioc.metier.IMetier;

public class PresentationWithSpring {

	public static void main(String[] args) {
		
		/*
		 * Lecture du fichier de configuration : config.xml
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
		
		//Appel du bean metier 
		IMetier metier =   (IMetier) context.getBean("metier");
		
		//Appel de ma méthode calcul
		System.out.println(metier.calcul());
		
	}

}
