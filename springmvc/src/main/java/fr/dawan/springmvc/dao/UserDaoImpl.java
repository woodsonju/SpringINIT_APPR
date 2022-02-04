package fr.dawan.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.springmvc.beans.User;

/*
 * @Repository : C'est pour dire que c'est une doit être instancier par Spring 
 * 				Sinon Spring ne traitera pas cette classe au demarrage de l'application
 * 				C'est un composant qui est fait pour la couche DAO, pour le Mapping
 * 				Objet Relationnel
 */
@Repository
public class UserDaoImpl implements IUserDAO{

	//Dans la méthode getLogger, on va specifier la classe à partir de laquelle on va logger
	private static Logger myRootLogger = LogManager.getLogger(UserDaoImpl.class);
	
	/*
	 * Pour gérer la gestion des entités j'aurais besoin de créer un variable 
	 * de type EntityManager
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Transactional
	@Override
	public void saveAndUpdate(User user) {
		if(user.getId() ==null || user.getId() == 0) {
			entityManager.persist(user);
		} else {
			entityManager.merge(user);
		}
	}

	/*
	 * Par defaut, les transactions Spring sont en lecture-ecriture, mais on peut configuter 
	 * explicitement pour qu'elles soients exécutées dans un contexte de lecture seule
	 * 
	 * Les méthodes permettant la lecture en base de données sont en lecture seul 
	 * Les autres méthodes sont en lecture/ecriture qui est le mode par defaut
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		String sql = "SELECT u from User u";
		Query req = entityManager.createQuery(sql);
		return req.getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public User findOn(Long id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	@Transactional
	@Override
	public void delete(Long id) {
		User user = entityManager.find(User.class, id);
		if(user != null) {
			entityManager.remove(user);
		} else {
			//TODO Logger
			myRootLogger.info("L'utilisateur n'existe pas dans l'application");
		}
	}

	@Override
	public User getUserByPasswordAndUEmail(String email, String password) {
		String sql = "SELECT u from User u where u.email=: x and u.password=: y";
		Query req = entityManager.createQuery(sql);
		req.setParameter("x", email);
		req.setParameter("y", password);
		return (User) req.getSingleResult();
	}

}
