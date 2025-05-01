package com.jeetest.foms;

import javax.servlet.http.HttpServletRequest;

public class LoginForm {
	private String resultat;
	
	public void verifierIdentifiants(HttpServletRequest request) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		if(pass.equals(login+"123")) {
			this.resultat = "Vous êtes bien connecté";
			return;
		}
		
		this.resultat = "Indentifiant incorrecte";
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
}
