package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.HotelManager;
import manager.HotelManagerMem;
import model.Hotel;

@SuppressWarnings("serial")
public class ListHotels extends HttpServlet {

	private HotelManager hm = new HotelManagerMem();
	private List<Hotel> hotels = hm.getHotels();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.getWriter().append("<html>");
		resp.getWriter().append("<head>");
		resp.getWriter().append("<title>Hoteles</title>");
		resp.getWriter().append("<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
		resp.getWriter().append("</head>");
		resp.getWriter().append("<body><div class=\"container\">");
		resp.getWriter().append("<h1>Hoteles</h1></br>");
		resp.getWriter()
				.append("<table class=\"table table-striped\"><tr><td><b>Código</b></td><td><b>Nombre</b></td><td><b>Descripción</b></td>");
		for (Hotel h : hotels) {
			resp.getWriter().append(h.toString());
		}
		resp.getWriter().append("</table>");
		resp.getWriter().append("<a href=\"logout\" class=\"btn btn-default\"> Cerrar Sesión </a>");
		resp.getWriter().append("</div></body>");
		resp.getWriter().append("</html>");
	}

}