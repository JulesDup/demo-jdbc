package fr.diginamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// �tape 1 - enregistrer le pilote
		// option 1
		// DriverManager.registerDriver(new Driver());
		// option 2
		Class.forName(db.getString("db.driver"));

		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
		// test connexion
		boolean reachable = connection.isValid(500);
		if (!reachable) {
			System.out.println(reachable + "probl�me de connexion a la base de donnee");
		} else {
			System.out.println(connection + ": connexion a la base reussi ! ");
		}
		connection.close();

	}
}
