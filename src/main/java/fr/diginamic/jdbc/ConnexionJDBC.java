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
			System.out.println(reachable + "probl�me de connexion a la base de donnee");
		} else {
			System.out.println(connection + ": connexion a la base reussi ! ");
		}
	}

	public static int ajouterFournisseur(String fournisseur, int id) throws SQLException, ClassNotFoundException {
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");
		// �tape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		// test connexion
		ConnexionJDBC.isConnect(connection);

		// �tape 3 - cr�er un "statement" (outil pour faire des requ�tes)
		Statement stm = connection.createStatement();
		int nbLignesImpact�es = 0;
		// �tape 4 - ex�cuter la requ�te
		try {
			nbLignesImpact�es = stm
					.executeUpdate("insert into fournisseur(id, nom) values(" + id + ", '" + fournisseur + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stm.close();
		return nbLignesImpact�es;
	}

	public static int updateFournisseur(int id, String modif) throws SQLException, ClassNotFoundException {
		int rslt = 0;
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");
		// �tape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		// test connexion
		ConnexionJDBC.isConnect(connection);
		// �tape 3 - cr�er un "statement" (outil pour faire des requ�tes)
		Statement stm = connection.createStatement();
		// �tape 4 - ex�cuter la requ�te
		rslt = stm.executeUpdate("update fournisseur set nom = '" + modif + "'where id=" + id);
		stm.close();
		return rslt;

	}

	public static int deleteFournisseur(int id) throws SQLException, ClassNotFoundException {
		int rslt = 0;
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");
		// �tape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		// test connexion
		ConnexionJDBC.isConnect(connection);
		// �tape 3 - cr�er un "statement" (outil pour faire des requ�tes)
		Statement stm = connection.createStatement();
		// �tape 4 - ex�cuter la requ�te
		rslt = stm.executeUpdate("delete from fournisseur where id=" + id);
		stm.close();
		return rslt;
	}

	public static List<Fournisseur> getAllListTable(String table) throws SQLException, ClassNotFoundException {
		int rslt = 0;
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");
		// �tape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		// test connexion
		ConnexionJDBC.isConnect(connection);
		// �tape 3 - cr�er un "statement" (outil pour faire des requ�tes)
		Statement stm = connection.createStatement();
		// �tape 4 - ex�cuter la requ�te
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
