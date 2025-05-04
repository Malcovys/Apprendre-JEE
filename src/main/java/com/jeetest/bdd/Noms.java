package com.jeetest.bdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jeetest.beans.Utilisateur;

public class Noms {
	private Connection connexion;
	
	public List<Utilisateur> recupererUtilisateur() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Statement statement = null;
		ResultSet resultat = null;
		
		this.loadDatabase();
		
		try {
			statement = this.connexion.createStatement();
			
			// Execution de la requête
			resultat = statement.executeQuery("select nom, prenom from noms");
			
			// Récupération des données
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				
				utilisateurs.add(utilisateur);
			}
		} catch(SQLException e) {
			
		} finally {
			try {
				if(resultat != null) resultat.close();
				if(statement != null) statement.close();
				if(connexion != null) connexion.close();
			} catch(SQLException e) {
				
			}
		}
		
		return utilisateurs;
	}
	
	private void loadDatabase() {
		// Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
		}
		
		try {
			this.connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "Malcovys12;");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		this.loadDatabase();
		
		try {
			PreparedStatement preparedStatement = this.connexion.prepareStatement("insert into noms(nom,prenom) values(?,?);");
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
