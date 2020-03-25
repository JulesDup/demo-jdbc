package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.entities.Fournisseur;

public class ConnexionJDBC {

	public static void isConnect(Connection connection) throws SQLException {
		// test connexion
		boolean reachable = connection.isValid(500);
		if (!reachable) {
			System.out.println(reachable + "probléme de connexion a la base de donnee");
		} else {
			System.out.println(connection + ": connexion a la base reussi ! ");
		}
	}

	public static int ajouterFournisseur(String fournisseur, int id) throws SQLException, ClassNotFoundException {
		// étape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");
		// étape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		// étape 2 - créer la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		// test connexion
		ConnexionJDBC.isConnect(connection);

		// étape 3 - créer un "statement" (outil pour faire des requêtes)
		Statement stm = connection.createStatement();
		int nbLignesImpactées = 0;
		// étape 4 - exécuter la requête
		try {
			nbLignesImpactées = stm
					.executeUpdate("insert into fournisseur(id, nom) values(" + id + ", '" + fournisseur + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stm.close();
		return nbLignesImpactées;
	}

	public static int updateFournisseur(int id, String modif) throws SQLException, ClassNotFoundException {
		int rslt = 0;
		// étape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");
		// étape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		// étape 2 - créer la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		// test connexion
		ConnexionJDBC.isConnect(connection);
		// étape 3 - créer un "statement" (outil pour faire des requêtes)
		Statement stm = connection.createStatement();
		// étape 4 - exécuter la requête
		rslt = stm.executeUpdate("update fournisseur set nom = '" + modif + "'where id=" + id);
		stm.close();
		return rslt;

	}

	public static int deleteFournisseur(int id) throws SQLException, ClassNotFoundException {
		int rslt = 0;
		// étape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");
		// étape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		// étape 2 - créer la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		// test connexion
		ConnexionJDBC.isConnect(connection);
		// étape 3 - créer un "statement" (outil pour faire des requêtes)
		Statement stm = connection.createStatement();
		// étape 4 - exécuter la requête
		rslt = stm.executeUpdate("delete from fournisseur where id=" + id);
		stm.close();
		return rslt;
	}

	public static List<Fournisseur> getAllListTable(String table) throws SQLException, ClassNotFoundException {
		int rslt = 0;
		// étape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");
		// étape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		// étape 2 - créer la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		// test connexion
		ConnexionJDBC.isConnect(connection);
		// étape 3 - créer un "statement" (outil pour faire des requêtes)
		Statement stm = connection.createStatement();
		// étape 4 - exécuter la requête
		ResultSet curseur = stm.executeQuery("select * from " + table);
		List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
		while (curseur.next()) {
			Integer id = curseur.getInt("id");
			String nom = curseur.getString("nom");
			Fournisseur fournisseur = new Fournisseur(nom, id);
			listFournisseurs.add(fournisseur);
		}
		curseur.close();
		stm.close();

		return listFournisseurs;

	}

}
