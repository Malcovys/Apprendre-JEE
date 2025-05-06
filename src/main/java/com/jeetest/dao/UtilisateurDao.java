package com.jeetest.dao;

import java.util.List;

import com.jeetest.beans.Utilisateur;

public interface UtilisateurDao {
	void ajouter(Utilisateur utilisateur) throws DaoException;
	List<Utilisateur> lister() throws DaoException;
}
