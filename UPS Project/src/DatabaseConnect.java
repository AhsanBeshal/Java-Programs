
/**
 * This class will connect to the database.
 * 
 * @author (Ahsan Beshal) 
 * Date: 06/27/2017
 * 
 */

import java.sql.*;

public class DatabaseConnect {

	/**
	 * This method will connect to the database.
	 * 
	 * @throws SQLException
	 */
	public static Connection postgresqlConnection() throws SQLException {

		Connection connect = null;

		try {
			// 1. Get a connection to database
			// database name, username, password
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5433/UPS", "postgres", "werock123");
			return connect;
		} catch (Exception exc) {
			exc.printStackTrace();
			return null;
		}

	}
}
