package fr.dawan.springmvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fr.dawan.springmvc.beans.User;

/*
 * Agit comme un filter (filter ou intercepteur de requêtes) permet de limiter certains types 
 * d'utilisateur d'acceder à un URL donné. Par exemple : seulement autoriser un utilisateur dont la 
 * variable est ADMIN aux URL (tâches) d'administration du site (suppression de visiteurs, modification
 * de visiteurs, ajout, modifications ou suppression de produits etc...)
 * Un client ne peut pas modifier le prix d'un produit. Dans cet exemple, les administrateurs disposent
 * destaches d'administrations du site (autorisés). Les clients non (non autorisés)
 * 
 * 
 * HttpSession : Définit un objet qui represente une session
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Boolean isConnected = (Boolean) session.getAttribute("isConnected");
		
		if(isConnected == null || !isConnected) {
			request.getRequestDispatcher("/login").forward(request, response);
		}
		return super.preHandle(request, response, handler);
	}
	

}
