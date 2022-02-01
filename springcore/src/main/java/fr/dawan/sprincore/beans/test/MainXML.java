package fr.dawan.sprincore.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.dawan.springcore.beans.Contact;
import fr.dawan.springcore.beans.Formation;
import fr.dawan.springcore.beans.Stagiaire;

public class MainXML {

	public static void main(String[] args) {
		
		/*
		 * Context : Récuperation du fichier beans.xml
		 * ApplicationContext : interface qui represente le conteneur Spring qui est 
		 * 						responsable de l'instanciation, de la configuration et de 
		 * 						l'assemblge des beans 
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//On lui demande de nous donner un bean
		Formation f1 = context.getBean("formation1", Formation.class);
		
		System.out.println(f1.toString());
		
		
		//Recuperation du bean
		Formation f2 =   context.getBean("formation2", Formation.class);
		System.out.println(f2);
		
		Formation f3 = context.getBean("formation2", Formation.class);
		System.out.println(f3);
		
		Contact c1 = context.getBean("contact1", Contact.class);
		System.out.println(c1);
		
		Contact c2 = context.getBean("contact2", Contact.class);
		System.out.println(c2);
		
		Contact c3 = context.getBean("contact3", Contact.class);
		System.out.println(c3);
		
//		Contact c4 = context.getBean("contact4", Contact.class);
//		System.out.println(c4);
		
		Stagiaire st1 = context.getBean("stagiaire1", Stagiaire.class);
		System.out.println(st1);
		
		((AbstractApplicationContext) context).close();
		

	}

}
