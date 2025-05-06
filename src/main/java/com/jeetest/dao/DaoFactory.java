package com.jeetest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	/* 
	 * Cette class est responsable de la connection avec la base de donnée
	 */
	private String url;
	private String username;
	private String password;
	
	DaoFactory(String url, String username, String password) {
		/* 
		 * Parametres
		 * @url : url vers la base de donnée
		 * @username : nom d'utilisateur de la base de donnée
		 * @password : mot de passe de la base de donnée
		 */
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch(ClassNotFoundException e) {
			
		}
		
		DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/javaee", "root", "Malcovys12;");
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		Connection connexion = DriverManager.getConnection(url, username, password);
		connexion.setAutoCommit(false);
		return connexion;
	}
	
	// Recuperer le Dao
	public UtilisateurDao getUtilisateurDao() {
		return new UtilisateurDaoImpl(this);
	}
}