package model;

public class Comment {

	private String username;
	private String mail;
	private String comment;

	public String getUsername() {
		return username;
	}

	public String toString(){
		return "<tr><td>" + username + "</td><td>" + mail + "</td><td>" + comment + "</td></tr>";
	}
	public String getMail() {
		return mail;
	}
	
	public String getComment() {
		return comment;
	}
	
	public Comment(String username, String mail, String comment) {
		this.username = username;
		this.mail = mail;
		this.comment = comment;
	}
	
}
