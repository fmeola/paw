package usermanager;

import java.util.HashMap;
import java.util.Map;

import model.User;

public class UserManagerMem implements UserManager {

	private static Map<String,User> users = new HashMap<String,User>();
	
	public UserManagerMem() {
		if(!Singleton.created){
			initUsers();
			Singleton.created = true;
		}
	}
	
	public User getUser(String username) {
		if(users.containsKey(username)){
			return users.get(username);
		}
		return null;
	}
	
	public Boolean correctLogin(String username, String password) {
		if(users.containsKey(username)){
			if(users.get(username).getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	private void initUsers(){
		users.put("jpuente",new User("Julieta","1234","julieta@puente.com"));
		users.put("fmeola",new User("Franco","4454","franco@meola.com"));
		users.put("leti",new User("Leticia","gomez","leti@gomez.com"));
	}
	
	private static class Singleton{
		public static boolean created = false;
	}
	
}
