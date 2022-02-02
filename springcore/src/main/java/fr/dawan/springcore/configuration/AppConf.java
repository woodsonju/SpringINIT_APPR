package fr.dawan.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import fr.dawan.springcore.beans.Adresse;
import fr.dawan.springcore.beans.Contact;
import fr.dawan.springcore.beans.Formation;

@Configuration
@ComponentScan(basePackages = "fr.dawan.springcore")  //Permet à Spring de savoir où trouver les beans
public class AppConf {
	
	//@Bean
	@Bean(name= {"formationExcel"}, initMethod = "init", destroyMethod = "destroy")
	@Scope("prototype")
	public Formation formation1() {
		return new Formation();
	}

	@Bean
	public Adresse adr() {
		return new Adresse();
	}
	
	@Bean
	public Contact contact1(Adresse adr) {
		return new Contact("John", "Doe", adr);
	}
	
	@Bean
	public Contact contact2() {
		return new Contact("Jacques", "DoIt", adr());
	}
}
