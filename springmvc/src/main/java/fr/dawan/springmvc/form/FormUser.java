package fr.dawan.springmvc.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@Size(min=8, max=40)
	private String password; 
}
