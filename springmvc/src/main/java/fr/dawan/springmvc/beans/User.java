package fr.dawan.springmvc.beans;

import javax.persistence.Entity;

/*
 * @Entity est une annotation qui est fournie par JPA (elle est obligatoire)
 * Specifie que la classe User correspond à une table 
 */
@Entity
public class User extends AbstractEntity {
	
	private String prenom;
	private String nom;
	private String email;
	private String password; 
	
	private Role role;

	public User() {
		super();
		this.role = Role.USER;
	}

	public User(String prenom, String nom, String email, String password) {
		this();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
