package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ViewHotel extends HttpServlet {

	@SuppressWarnings("unchecked")
//	private Map<String,Hotel> db = (Map<String, Hotel>) getServletConfig().getServletContext().getAttribute("db");
	private Map<String, Hotel> db = (new HotelDB()).getDB();
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
		resp.getWriter().append("</br>");
		resp.getWriter().append("<h3>Deje su comentario aquí</h3>");
		resp.getWriter().append("<form role=\"form\" action=\"addComment\" method=\"post\"><div>");
		resp.getWriter().append("<input type=\"hidden\" name=\"code\" value=\"" + currentHotelCode + "\">");
		resp.getWriter().append("<div><label>Usuario </label><input type=\"text\" name=\"usuario\" placeholder=\"Usuario\"></div>");
		resp.getWriter().append("<div><label>EMail </label><input type=\"text\" name=\"email\" placeholder=\"EMail\"></div>");
		resp.getWriter().append("<div><label>Comentario </label><textarea name=\"comentario\" placeholder=\"Comentario\"></textarea></div>");
		resp.getWriter().append("<button type=\"submit\">Enviar</button>");
		resp.getWriter().append("<button type=\"reset\">Limpiar</button>");
		resp.getWriter().append("</div></form>");
		resp.getWriter().append("</body>");
		resp.getWriter().append("</html>");
	}

}
