package fr.dawan.springmvc.dao;

import fr.dawan.springmvc.beans.User;

public interface IUserDAO extends EntityRepository<User>{
	public User getUserByPasswordAndUEmail(String email, String password);
}
