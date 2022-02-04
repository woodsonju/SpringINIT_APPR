package fr.dawan.springmvc.beans;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/*
 * @MappedSuperclass  : Dans ce cas la classe n'est pas une entit� JPA, mais ses champs 
 * 						seront enregistr�s en base.
 */
@MappedSuperclass
public class AbstractEntity implements Serializable{
	/*
	 * L�annotation @Id permet de sp�cifier que � l�attribut id � sera la cl� primaire dans la table.
	 * IDENTITY: Il va incrementer de 1 � chaque ajout d'un �lement dans la table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	/*
	 * @Version : permet de detecter des modifications simultan�es sur la meme ligne de la table
	 */
	@Version
	private int version;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
