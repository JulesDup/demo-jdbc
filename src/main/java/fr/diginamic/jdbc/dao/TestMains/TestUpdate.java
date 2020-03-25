package fr.diginamic.jdbc.dao.TestMains;

import java.sql.SQLException;

import fr.diginamic.entities.Fournisseur;
import fr.diginamic.jdbc.ConnexionJDBC;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestUpdate {
	public static void main(String[] args) {

		FournisseurDaoJdbc fourDao = new FournisseurDaoJdbc();
		Fournisseur fournisseur = new Fournisseur("L’Espace Création", 4);
		int rep = 0;
		try {
			rep = fourDao.update("L’Espace Création", "Les Espaces de creation");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		boolean rslt = false;
		if (rep == 1) {
			rslt = true;
		}
		System.out.println("test update " + rslt);

	}

}
