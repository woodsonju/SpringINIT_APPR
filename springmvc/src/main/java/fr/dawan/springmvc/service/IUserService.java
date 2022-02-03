package fr.dawan.springmvc.service;

import java.util.List;

import fr.dawan.springmvc.beans.User;

public interface IUserService {
	public void saveAndUpdate(User user);
	public List<User> getAllUsers();
	public User getUser(Long id);
	public void deleteUser(Long id);
	public User getUserByPasswordAndUEmail(String email, String password);

}
