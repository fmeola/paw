package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ListHotels extends HttpServlet {
	
	private List<Hotel> l = new ArrayList<Hotel>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		l.add(new Hotel(120, "NH Hotel", "Texto"));
		l.add(new Hotel(300, "Hilton", "Texto"));

		resp.getWriter().append("<html><body>ListHotels!");
		resp.getWriter().append(l.toString());
		resp.getWriter().append("</body></html>");
	}

}