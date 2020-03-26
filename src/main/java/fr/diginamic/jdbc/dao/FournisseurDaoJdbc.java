package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.entities.Fournisseur;
import fr.diginamic.jdbc.ConnexionJDBC;

public class FournisseurDaoJdbc implements FournisseurDao {

	public Statement getStatement() throws SQLException, ClassNotFoundException {
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		Statement stm = connection.createStatement();
		return stm;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {

		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		return connection;

	}

	public List<Fournisseur> extraire(String table) throws SQLException, ClassNotFoundException {
		int rslt = 0;
		// CONNEXION BDD
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		Statement stm = connection.createStatement();
		// REQUETE
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

	public void insert(Fournisseur fournisseur) throws ClassNotFoundException, SQLException {
		// CONNEXION BDD
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		Statement stm = connection.createStatement();
		int nbLignesImpactées = 0;
		// REQUETE
		nbLignesImpactées = stm.executeUpdate(
				"insert into fournisseur(id, nom) values(" + fournisseur.getId() + ", '" + fournisseur.getNom() + "')");
		stm.close();
	}

	public int update(String ancienNom, String nouveauNom) throws ClassNotFoundException, SQLException {
		int rslt = 0;
		// CONNEXION
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		Statement stm = connection.createStatement();
		// REQUETE
		rslt = stm.executeUpdate("update fournisseur set nom = '" + nouveauNom + "'where nom='" + ancienNom + "'");
		stm.close();
		return rslt;
	}

	public boolean delete(Fournisseur fournisseur) throws ClassNotFoundException, SQLException {
		boolean rslt = false;
		int rep = 0;
		// CONNEXION
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		Statement stm = connection.createStatement();
		// REQUETE
		rep = stm.executeUpdate("delete from fournisseur where  nom= '" + fournisseur.getNom() + "'");
		stm.close();
		if (rep == 1) {
			rslt = true;
		}
		return rslt;
	}

	public List<Fournisseur> extraire() throws SQLException, ClassNotFoundException {
		int rslt = 0;
		// CONNEXION
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		Statement stm = connection.createStatement();
		// REQUETE
		ResultSet curseur = stm.executeQuery("select * from fournisseur");
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
