package fr.dawan.springmvc.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * Pour la validation du Formulaire
 */
public class FormUser implements Serializable{
	@NotNull
	@Size(min=2, max=40)
	private String prenom;
	
	@NotNull
	@Size(min=2, max=40)
	private String nom;
	
	@NotNull
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", 
					message="L'émail n'est pas valide")
	private String email;
	
	@NotNull
	@Size(min=6, max=40)
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 
	
}
