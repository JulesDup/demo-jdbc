package fr.diginamic.jdbc.dao.TestMains;

import java.sql.SQLException;

import fr.diginamic.entities.Fournisseur;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestDelete {

	public static void main(String[] args) {
		FournisseurDaoJdbc fourDao = new FournisseurDaoJdbc();
		Fournisseur fournisseur = new Fournisseur("Les Espaces de creation", 4);
		boolean rslt = false;
		try {
			rslt = fourDao.delete(fournisseur);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("test delete : " + rslt);

	}

}
