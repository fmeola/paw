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

	public ListHotels() {
		initHotels();
	}

	/**
	 * Inicializa la lista con los datos.
	 */
	private void initHotels() {
		l.add(new Hotel(120, "NH Latino", "Un lugar como ninguno"));
		l.add(new Hotel(300, "Hilton", "Somos vos"));
		l.add(new Hotel(645, "Sheraton", "Serving People"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().append("<html>");
		resp.getWriter().append("<head><title>Hoteles</title></head>");
		resp.getWriter().append("<body>");
		resp.getWriter().append("<h1>Hoteles</h1></br>");
		resp.getWriter()
				.append("<table><tr><td><b>Código</b></td><td><b>Nombre</b></td><td><b>Descripción</b></td>");
		for (Hotel h : l) {
			resp.getWriter().append(h.toString());
		}
		resp.getWriter().append("</table>");
		resp.getWriter().append("</body>");
		resp.getWriter().append("</html>");
	}

}