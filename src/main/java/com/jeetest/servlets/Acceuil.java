package com.jeetest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/Acceuil")
public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// LIRE COOKIE
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("prenom")) {
                    request.setAttribute("prenom", cookie.getValue());
                }
            }
        }
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		// COOKIE
		Cookie cookie = new Cookie("prenom", prenom);
		cookie.setMaxAge(60 * 60 * 24 * 30); // supprimer dans 30 jour
		response.addCookie(cookie);
		
		
		// CREE UNE SESSION		
//		HttpSession session = request.getSession();
//		session.setAttribute("nom", nom);
//		session.setAttribute("prenom", prenom);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
	}

}
