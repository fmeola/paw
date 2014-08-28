package ar.edu.itba.it.paw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().append("<html>");
		resp.getWriter().append("<head><title>Login</title></head>");
		resp.getWriter().append("<body>");
		resp.getWriter().append("<h1>Login</h1></br>");
		
		resp.getWriter().append("<form role=\"form\" action=\"listHotels" + "\" method=\"post\"><div>");
		resp.getWriter().append("<div><label>Usuario </label><input type=\"text\" name=\"usuario\" placeholder=\"Usuario\"></div>");
		resp.getWriter().append("<div><label>Contraseña </label><input type=\"text\" name=\"pass\" placeholder=\"Contraseña\"></div>");
		resp.getWriter().append("<button type=\"submit\">Inciar Sesión</button>");
		resp.getWriter().append("<button type=\"reset\">Limpiar</button>");
		resp.getWriter().append("</div></form>");
		
		resp.getWriter().append("</body>");
		resp.getWriter().append("</html>");
	}
	
}
