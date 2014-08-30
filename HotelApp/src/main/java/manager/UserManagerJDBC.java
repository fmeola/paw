package manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserManagerJDBC implements UserManager {
	
	public User getUser(String username) {
		JDBCDB.connectDB();
		ResultSet res = JDBCDB.execQuery("SELECT * FROM USUARIO WHERE USERNAME = '" + username + "'");
		User user = null;
		if(res != null){
			try {
				while (res.next()){
					user = new User(res.getString("nombre"),res.getString("password"),res.getString("email"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user; 
	}

	public Boolean correctLogin(String username, String password) {
		JDBCDB.connectDB();
		Boolean b = false;
		ResultSet res = JDBCDB.execQuery("SELECT password FROM USUARIO WHERE USERNAME = '" + username + "'");
		if(res != null){
			try {
				while (res.next()){
					b = res.getString("password").equals(password);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b; 
	}

}
