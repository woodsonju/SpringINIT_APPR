package fr.dawan.springcore.beans;

public class Stagiaire extends Contact{
	
	private String code;
	
	public Stagiaire() {
		super();
	}



	public Stagiaire(String code) {
		super();
		this.code = code;
	}


	public Stagiaire(String prenom, String nom, Adresse adr, String code) {
		super(prenom, nom, adr);
		this.code = code;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public String toString() {
		return "Stagiaire [code=" + code + ", getPrenom()=" + getPrenom() + ", getNom()=" + getNom() + ", getAdr()="
				+ getAdr() + "]";
	}
	
	
}
