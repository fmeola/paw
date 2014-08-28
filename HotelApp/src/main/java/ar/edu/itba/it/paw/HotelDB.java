package ar.edu.itba.it.paw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelDB {
	
	private Map<String,Hotel> db = new HashMap<String,Hotel>();
	
	public HotelDB() {
		initHotels();
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
	
	public Map<String,Hotel> getDB(){
		return db;
	}
	
}
