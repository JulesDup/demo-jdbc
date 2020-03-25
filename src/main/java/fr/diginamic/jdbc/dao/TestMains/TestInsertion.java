package fr.diginamic.jdbc.dao.TestMains;

import java.sql.SQLException;

import fr.diginamic.entities.Fournisseur;
import fr.diginamic.jdbc.ConnexionJDBC;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestInsertion {

	public static void main(String[] args) {

		FournisseurDaoJdbc fouDao = new FournisseurDaoJdbc();
		Fournisseur fournisseur = new Fournisseur("L’Espace Création", 5);

		int rslt = 0;
		try {
			fouDao.insert(fournisseur);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("test ajout ");

	}

}
