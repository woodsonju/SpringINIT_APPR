package fr.dawan.springmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.springmvc.beans.Role;
import fr.dawan.springmvc.beans.User;
import fr.dawan.springmvc.form.FormUser;
import fr.dawan.springmvc.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IUserService service;
	
	/*
	 * ModelAndView permet de transmettre la vue et les attributs avec un seul return
	 */
	@GetMapping("/users")
	public ModelAndView listUser() {
		List<User> users = service.getAllUsers();
		ModelAndView modelView = new ModelAndView();
		
		modelView.setViewName("usersview");
		
		modelView.addObject("users", users);
		return modelView;
		
	}
	
	/*
	 * Admin pourra effacer un user par son id
	 * 
	 * @PathVariable : 
	 * @PathVariable est une annotation Spring qui indique qu'un param�tre de la m�thode
	 * doit �tre li� � une variable de la requete
	 */
	@GetMapping("/users/delete/{id}")
	public String deleteUser(Model model, @PathVariable Long id) {
		User user = service.getUser(id);
		if(user != null) {
			service.deleteUser(id);
		}
		return "redirect:/admin/users";
	}
	
	/*
	 * Le Model permet de fournir des attributs utilis�s dans la vue grace 
	 * � la m�thode addAtribute
	 * 
	 * Si on veut afficher un formulaire avec donn�es par defaut (vide) il suffit 
	 * d'acceder � la m�thode addAtribute, et ajouter un attribut formuser 
	 * dont sa valeur est  new FormUser()
	 * Ensuite la vue va se servir de l'attribut pour acceder � sa valeur (ici new FormUser())
	 * 
	 */
	@GetMapping("/users/add")
	public String addUser(Model model) {
		model.addAttribute("formuser", new FormUser());
		return "adduser";
	}
	
	/*
	 * @Valid : C'est une annotation Spring 
	 * 			On va demander � Spring de valider , de verifier si cet objet est correcte
	 * 
	 * En m�me temps s'il y a des messages d'erreurs on les r�cup�re dans un objet 
	 * BindingResult
	 * Ceci permet de r�cuperer les r�sultat de la validation dans un objet BindingResult
	 * 
	 * Les champs sont r�cup�r�s dans un objet annot� @ModelAttribut
	 * @ModelAttribute : Objet post� par un formulaire
	 */
	@PostMapping("/users/add")
	public ModelAndView addUser(@Valid  @ModelAttribute("formuser") FormUser formuser, 
			BindingResult result, Model model) {
		ModelAndView modelView = new ModelAndView();
		if(result.hasErrors()) {
			modelView.addObject("error", result);
			modelView.addObject("formuser", formuser);
			modelView.setViewName("adduser");
		} else {
			User u = new User(formuser.getPrenom(), formuser.getNom(), formuser.getEmail(),
					formuser.getPassword());
			service.saveAndUpdate(u);
			modelView.setViewName("redirect:/admin/users");
		}
		
		return modelView;
	}
	
}
