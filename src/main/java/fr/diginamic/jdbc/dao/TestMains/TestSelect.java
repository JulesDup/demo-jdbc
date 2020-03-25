package fr.diginamic.jdbc.dao.TestMains;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.entities.Fournisseur;
import fr.diginamic.jdbc.ConnexionJDBC;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestSelect {
	public static void main(String[] args) {
		FournisseurDaoJdbc fourDao = new FournisseurDaoJdbc();

		List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
		try {
			listFournisseurs = fourDao.extraire();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("------------Liste---------------");
		for (Fournisseur courante : listFournisseurs) {
			System.out.println(courante);
		}
	}

}
