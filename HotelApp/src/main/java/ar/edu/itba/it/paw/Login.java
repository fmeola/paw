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
		resp.getWriter().append("<head>");
		resp.getWriter().append("<title>Login</title>");
		resp.getWriter().append("<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
		resp.getWriter().append("</head>");
		resp.getWriter().append("<body><div class=\"container\">");
		resp.getWriter().append("<h1>Login</h1></br>");
		
		resp.getWriter().append("<form role=\"form\" action=\"listHotels" + "\" method=\"post\"><div>");
		resp.getWriter().append("<div class=\"form-group\"><label>Usuario </label><input type=\"text\" class=\"form-control\" name=\"usuario\" placeholder=\"Usuario\"></div>");
		resp.getWriter().append("<div class=\"form-group\"><label>Contraseña </label><input type=\"text\" class=\"form-control\" name=\"pass\" placeholder=\"Contraseña\"></div>");
		resp.getWriter().append("<button type=\"submit\" class=\"btn btn-primary\">Inciar Sesión</button>");
		resp.getWriter().append("<button type=\"reset\" class=\"btn btn-default\">Limpiar</button>");
		resp.getWriter().append("</div></form>");
		
		resp.getWriter().append("</div></body>");
		resp.getWriter().append("</html>");
	}
	
}
