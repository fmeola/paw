package manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.Hotel;

public class HotelManagerJDBC implements HotelManager {

	public List<Hotel> getHotels() {
		JDBCDB.connectDB();
		ResultSet res = JDBCDB.execQuery("SELECT * FROM HOTEL");
		List<Hotel> hotels = new ArrayList<Hotel>();
		if(res != null){
			try {
				while (res.next()){
					hotels.add(new Hotel(res.getInt("codigo"),res.getString("nombre"),res.getString("descripcion"),null));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hotels; 
	}

	public Hotel getHotel(String code) {
		JDBCDB.connectDB();
		ResultSet res = JDBCDB.execQuery("SELECT * FROM HOTEL WHERE CODIGO = " + code);
		List<Comment> comments = getComment(Integer.valueOf(code));
		Hotel hotel = null;
		if(res != null){
			try {
				while (res.next()){
					hotel = new Hotel(res.getInt("codigo"),res.getString("nombre"),res.getString("descripcion"),comments);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hotel; 
	}

	public List<Comment> getComment(int code){
		JDBCDB.connectDB();
		ResultSet res = JDBCDB.execQuery("SELECT * FROM COMENTARIO,USUARIO WHERE HOTEL = " + code + " AND COMENTARIO.USERNAME= USUARIO.USERNAME");
		List<Comment> comments = new ArrayList<Comment>();
		if(res != null){
			try {
				while (res.next()){
					comments.add(new Comment(res.getString("username"),res.getString("email"),res.getString("comment")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comments; 
	}
	
	public void addComment(Hotel hotel, Comment comment) {
		JDBCDB.connectDB();
		JDBCDB.execQuery("INSERT INTO COMENTARIO VALUES ( '" +comment.getUsername() + "'," + hotel.getCode() + ",'"+ comment.getComment() + "')");
	}
	
}
