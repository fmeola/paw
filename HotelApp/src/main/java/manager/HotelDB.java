package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Comment;
import model.Hotel;
import model.User;

public class HotelDB {
	
	private static Map<String,Hotel> db = new HashMap<String,Hotel>();
	private static Map<String,User> users = new HashMap<String,User>();
	private static boolean created = false;
	
	public HotelDB() {
		if(!created){
			initHotels();
			initUsers();
			created = true;
		}
	}
	
	/**
	 * Inicializa la lista con los datos.
	 */
	private void initHotels() {
		List<Comment> c1 = new ArrayList<Comment>();
		c1.add(new Comment("Juan","juan@pepe.com","Me encantó"));
		db.put("120",new Hotel(120, "NH Latino", "Un lugar como ninguno",c1));
		List<Comment> c2 = new ArrayList<Comment>();
		c2.add(new Comment("Pepe","pepe@pepe.com","Buenísimo"));
		c2.add(new Comment("Raúl","pepe@raul.com","Malísimo"));
		db.put("300",new Hotel(300, "Hilton", "Somos vos",c2));
		List<Comment> c3 = new ArrayList<Comment>();
		c3.add(new Comment("Leti","leti@itba.com","Letiiii"));
		db.put("645",new Hotel(645, "Sheraton", "Serving People",c3));
	}
	
	private void initUsers(){
		users.put("jpuente",new User("Julieta","1234","julieta@puente.com"));
		users.put("fmeola",new User("Franco","4454","franco@meola.com"));
		users.put("leti",new User("Leticia","gomez","leti@gomez.com"));
	}
	
	public static Map<String,Hotel> getDB(){
		return db;
	}
	
	public static Boolean correctLogin(String username, String password){
		if(users.containsKey(username)){
			if(users.get(username).getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	public static User getUser(String username){
		if(users.containsKey(username)){
			return users.get(username);
		}
		return null;
	}
	
}
