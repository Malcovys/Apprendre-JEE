package com.jeetest.dao;

import java.sql.*;
import java.util.*;

import com.jeetest.beans.BeanException;
import com.jeetest.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
	private DaoFactory daoFactory;
	
	UtilisateurDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("insert into noms(nom,prenom) values(?,?);");
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			
			preparedStatement.executeUpdate();
			connexion.commit();
		} catch(SQLException e) {
			try {
				if(connexion != null) {
					connexion.rollback();
				}
			} catch(SQLException e2) {
			}
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if(connexion != null) {
					connexion.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}
		
	}

	@Override
	public List<Utilisateur> lister() throws DaoException {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("select nom, prenom from noms;");
			
			while(resultat.next()) {
				String nom = resultat.getNString("nom");
				String prenom = resultat.getString("prenom");
				
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				
				utilisateurs.add(utilisateur);
			}
		} catch(SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} catch (BeanException e) {
            throw new DaoException("Les données de la base sont invalides");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }

        return utilisateurs;
	}
	
}
