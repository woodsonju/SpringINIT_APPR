package fr.dawan.springcore.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Contact implements Serializable{

	private String prenom;
	private String nom;

	@Autowired
//	@Qualifier("adr2")   //Quand il y a plusieurs bean on priorise (ex :ici adr
	//@Resource(name="adr2")  //Injection d'un bean par nom
//	@Inject  //equivalent en JavaEE de l'autowire en Spring
//	@Named("adr2")  //equivalent à Qualifier en JavaEE
	private Adresse adr;

	private List<String> emailList;


	public Contact() {
		super();
		emailList = new ArrayList<String>();
	}

	public Contact(String prenom, String nom, Adresse adr) {
		this();
		this.prenom = prenom;
		this.nom = nom;
		this.adr = adr;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}

	public List<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}

	public void init() {
		System.out.println("Methode init");
	}

	public void destroy() {
		System.out.println("Methode destruction");
	}

	@Override
	public String toString() {
		return "Contact [prenom=" + prenom + ", nom=" + nom + ", adr=" + adr + "]";
	}



}
