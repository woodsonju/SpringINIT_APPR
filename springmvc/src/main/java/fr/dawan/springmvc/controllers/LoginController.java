package fr.dawan.springmvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.springmvc.beans.User;
import fr.dawan.springmvc.form.FormLogin;
import fr.dawan.springmvc.service.IUserService;

/*
 * L'annotation @SessionAttributes est utilis�e pou stoker l'attibut de mod�le dans 
 * la session
 * Cette annotation est utilis� au niveau de la classe contr�leur
 */
@Controller
@SessionAttributes({"user", "isConnected"})
public class LoginController {

	@Autowired
	private IUserService service;

	@GetMapping("/login")
	public String loginGet(Model model) {
		model.addAttribute("formlogin", new FormLogin());
		return "login";
	}
	
	
	/*
	 * @Valid : C'est une annotation Spring 
	 * 			On va demander � Spring de valider , de verifier 
	 * 			si cet objet est correcte
	 * 
	 * En m�me temps s'il y a des messages d'erreurs on les r�cup�re dans un objet 
	 * BindingResult
	 * Ceci permet de r�cuperer les r�sultat de la validation dans un objet BindingResult
	 * 
	 * Les champs sont r�cup�r�s dans un objet annot� @ModelAttribut
	 * @ModelAttribute : Objet post� par un formulaire
	 */
	@PostMapping("/login")
	public ModelAndView loginPost(@Valid @ModelAttribute("formLogin") FormLogin login,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			modelAndView.addObject("errors", result);
			modelAndView.addObject("formlogin", login);
			modelAndView.setViewName("login");
		} else {
			User u = service.getUserByPasswordAndUEmail(login.getEmail(), login.getPassword());
			
			if(u!=null) {
				modelAndView.addObject("user", u);
				modelAndView.addObject("isConnected", true);
				modelAndView.setViewName("redirect:/admin/users");
			} else {
				modelAndView.addObject("formlogin", new FormLogin());
				modelAndView.setViewName("login");
			}
		}
		return modelAndView;
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("isConnected", false);
		return("redirect:/");
	}

}
