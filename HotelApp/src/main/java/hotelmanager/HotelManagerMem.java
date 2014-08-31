package hotelmanager;

import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.Hotel;

public class HotelManagerMem implements HotelManager {
	
	public HotelManagerMem() {
		new HotelDB();
	}

	public void addComment(Hotel hotel, Comment comment) {
		List<Comment> comments = hotel.getComments();
		comments.add(comment);
		hotel.setComments(comments);
		HotelDB.getDB().put(String.valueOf(hotel.getCode()),hotel);
	}

	public List<Hotel> getHotels() {
		return new ArrayList<Hotel>(HotelDB.getDB().values());
	}

	public Hotel getHotel(String code) {
		for(Hotel h : getHotels()){
			if(String.valueOf(h.getCode()).equals(code)){
				return h;
			}
		}
		return null;
	}
	
}
