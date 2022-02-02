package fr.dawan.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.dawan.springcore.beans.Contact;
import fr.dawan.springcore.beans.Formation;

public class MainAnnotation {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("confAnnotation.xml");
		Contact contact = context.getBean("c1", Contact.class);
		System.out.println(contact);
		
		Formation f = context.getBean("f1", Formation.class);
		System.out.println(f);
		
		((AbstractApplicationContext) context).close();
		
		
	}

}
