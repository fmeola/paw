package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ViewHotel extends HttpServlet {

	private Map<String,Hotel> db = (new HotelDB()).getDB();
	private Hotel currentHotel;
	private String currentHotelCode;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		currentHotelCode = req.getParameter("code");
		currentHotel = db.get(currentHotelCode);
		resp.getWriter().append("<html>");
		resp.getWriter().append("<head><title>Hotel" + currentHotel.getName() +"</title></head>");
		resp.getWriter().append("<body>");
		resp.getWriter().append("<h1>Hotel " + currentHotel.getName() + "</h1></br>");
		resp.getWriter().append("<h2>" + currentHotel.getDescription() + "</h2>");
		resp.getWriter().append("<h3>Código: " + currentHotel.getCode() + "</h3>");
		resp.getWriter()
				.append("<table><tr><td><b>Usuario</b></td><td><b>EMail</b></td><td><b>Comentario</b></td>");
		for(Comment c : currentHotel.getComments()) {
			resp.getWriter().append(c.toString());
		}
		resp.getWriter().append("</table>");
		resp.getWriter().append("</body>");
		resp.getWriter().append("</html>");
	}

}
