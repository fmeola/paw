package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ListHotels extends HttpServlet {

	private HotelDB hoteldb = new HotelDB();
	private Map<String,Hotel> db = hoteldb.getDB();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		getServletConfig().getServletContext().setAttribute("db",db);
		
		/**
		 * Mejor hacerlo con filtros
		 */
		HttpSession session = req.getSession();
		if(session.getAttribute("name") == null){
			resp.sendRedirect("/login");
			return ;
		}
		
		resp.getWriter().append("<html>");
		resp.getWriter().append("<head><title>Hoteles</title></head>");
		resp.getWriter().append("<body>");
		resp.getWriter().append("<h1>Hoteles</h1></br>");
		resp.getWriter()
				.append("<table><tr><td><b>Código</b></td><td><b>Nombre</b></td><td><b>Descripción</b></td>");
		for (Hotel h : db.values()) {
			resp.getWriter().append(h.toString());
		}
		resp.getWriter().append("</table>");
		resp.getWriter().append("<a href=\"logout\"> Cerrar Sesión </a>");
		resp.getWriter().append("</body>");
		resp.getWriter().append("</html>");
	}
	
	/**
	 * Para el login
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("usuario");
		String pass = req.getParameter("pass");
		if(!hoteldb.correctLogin(username,pass)){
			resp.sendRedirect("/login");
			return ;
		}
		doGet(req,resp);
		User currentUser = hoteldb.getUser(username);
		HttpSession session = req.getSession();
		session.setAttribute("name", currentUser.getName());
		session.setAttribute("email", currentUser.getEmail());
	}

}