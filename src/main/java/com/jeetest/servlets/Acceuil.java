package com.jeetest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Acceuil")
public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
	}

}
