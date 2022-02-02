package fr.dawan.springmvc.dao;

import java.util.List;

import fr.dawan.springmvc.beans.AbstractEntity;
import fr.dawan.springmvc.beans.User;

/*
 * Amelioration du code : Création d'une interface Générique
 * Une interface générique c'est une interface qu'on pourra utiliser pour n'importe quelle entité
 * 
 */
public interface EntityRepository<T extends AbstractEntity> {
	public void saveAndUpdate(T entity);
	public List<T> findAll();
	public T findOn(Long id);
	public void delete(Long id);	
}
