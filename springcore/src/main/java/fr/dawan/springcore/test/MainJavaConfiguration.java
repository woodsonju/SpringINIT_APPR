package fr.dawan.springcore.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.dawan.springcore.beans.Contact;
import fr.dawan.springcore.beans.Formation;
import fr.dawan.springcore.configuration.AppConf;

public class MainJavaConfiguration {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConf.class);
		context.refresh();
		
//		Formation f1 = context.getBean("formation1", Formation.class);
//		System.out.println(f1);
		
		Formation f1 = context.getBean("formationExcel", Formation.class);
		System.out.println(f1);
		
		Formation f2 = context.getBean("formationExcel", Formation.class);
		System.out.println(f2);
		
		Contact c1 = context.getBean("contact1", Contact.class);
		System.out.println(c1);
		
		Contact c2 = context.getBean("contact2", Contact.class);
		System.out.println(c2);
		
		context.close();
		
	}

}
