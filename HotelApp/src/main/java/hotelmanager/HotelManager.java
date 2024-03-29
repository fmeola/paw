package hotelmanager;

import java.util.List;

import model.Comment;
import model.Hotel;

public interface HotelManager {
	
	public List<Hotel> getHotels();
	
	public Hotel getHotel(String code);
	
	public void addComment(Hotel hotel, Comment comment);
	
	public void addHotel(Hotel hotel);

	public void modifyHotel(Hotel hotel);

}