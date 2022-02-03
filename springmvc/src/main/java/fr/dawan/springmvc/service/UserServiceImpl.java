package fr.dawan.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.dawan.springmvc.beans.User;
import fr.dawan.springmvc.dao.IUserDAO;

public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDAO dao;

	

	@Override
	public void saveAndUpdate(User user) {
		dao.saveAndUpdate(user);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public User getUser(Long id) {
		return dao.findOn(id);
	}

	@Override
	public void deleteUser(Long id) {
		dao.delete(id);
		
	}

	@Override
	public User getUserByPasswordAndUEmail(String email, String password) {
		return dao.getUserByPasswordAndUEmail(email, password);
	}

}
