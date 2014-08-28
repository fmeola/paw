package ar.edu.itba.it.paw;

import java.util.List;

public class Hotel {

	private int code;
	private String name;
	private String description;
	private List<Comment> comments;

	public Hotel(int code, String name, String description, List<Comment> comments) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "<tr><td>" + code + "</td><td><a href=\"viewHotel?code=" + code + "\">" + name + "</a></td><td>"
				+ description + "</td></tr>";
	}
	
	public List<Comment> getComments(){
		return comments;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCode(){
		return code;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setComments(List<Comment> l){
		comments = l;
	}
}
