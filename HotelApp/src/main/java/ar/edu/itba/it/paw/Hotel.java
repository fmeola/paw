package ar.edu.itba.it.paw;

public class Hotel {

	private int code;
	private String name;
	private String description;

	public Hotel(int code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "<tr><td>" + code + "</td><td>" + name + "</td><td>"
				+ description + "</td>";
	}
}
