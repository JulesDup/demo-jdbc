package fr.diginamic.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.entities.Fournisseur;

public class TestMain {

	public static void main(String[] args) {

		// Ajout dans bdd
		String fournisseur = "La Maison de la Peinture";
		int idFournisseur = 4;
		int rslt = 0;
		try {
			rslt = ConnexionJDBC.ajouterFournisseur(fournisseur, idFournisseur);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("test ajout " + rslt);

		// modif dans bdd
		String fournisseur2 = "La Maison des Peintures";
		try {
			rslt = ConnexionJDBC.updateFournisseur(idFournisseur, fournisseur2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("test update " + rslt);

		// suppression dans bdd
		try {
			rslt = ConnexionJDBC.deleteFournisseur(idFournisseur);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();		
		}

		System.out.println("test suppresion " + rslt);

		// renvois liste de fournisseur
		List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
		String table = "fournisseur";
		try {
			listFournisseurs = ConnexionJDBC.getAllListTable(table);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("------------Liste de " + table + "---------------");
		for (Fournisseur courante : listFournisseurs) {
			System.out.println(courante);
		}

	}

}
