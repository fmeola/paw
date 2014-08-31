package manager;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDB{
	
	private static Connection connection = null;

	public static void connectDB() {
		if(connection == null){
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your PostgreSQL JDBC Driver? "
						+ "Include in your library path!");
				e.printStackTrace();
				return;
			}
			System.out.println("PostgreSQL JDBC Driver Registered!");
			try {
				connection = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/hotelapp", "paw",
						"paw");
			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
			}
		}
		if(connection == null){
			System.out.println("Failed to make connection!");
		}
	}
	
	public static ResultSet execQuery(String query){
		ResultSet myCursor = null;
		try {
			Statement stmt = connection.createStatement();
			System.out.println(query);
			if (stmt.execute(query)) {
				myCursor = stmt.getResultSet();
			}
//			stmt.close();
		} catch (Exception e) {
			System.out.println("ERR: " + e.getMessage());
			e.printStackTrace();
		}
		return myCursor;
	}

}