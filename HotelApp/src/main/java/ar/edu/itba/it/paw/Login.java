package ar.edu.itba.it.paw;

import hotelmanager.HotelDB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usermanager.UserManager;
import usermanager.UserManagerJDBC;
//import manager.UserManagerMem;
import model.User;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	
	//TODO Hacer todas las paths de los redirects relativas porque en Tomcat no funcionan
	
//	private UserManager um = new UserManagerMem();
	private UserManager um = new UserManagerJDBC();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
//		resp.getWriter().append("<html>");
//		resp.getWriter().append("<head>");
//		resp.getWriter().append("<title>Login</title>");
//		resp.getWriter().append("<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
//		resp.getWriter().append("</head>");
//		resp.getWriter().append("<body><div class=\"container\">");
//		resp.getWriter().append("<h1>Login</h1></br>");
//		
//		resp.getWriter().append("<form role=\"form\" action=\"login" + "\" method=\"post\"><div>");
//		resp.getWriter().append("<div class=\"form-group\"><label>Usuario </label><input type=\"text\" class=\"form-control\" name=\"usuario\" placeholder=\"Usuario\"></div>");
//		resp.getWriter().append("<div class=\"form-group\"><label>Contraseña </label><input type=\"password\" class=\"form-control\" name=\"pass\" placeholder=\"Contraseña\"></div>");
//		resp.getWriter().append("<button type=\"submit\" class=\"btn btn-primary\">Iniciar Sesión</button>");
//		resp.getWriter().append("<button type=\"reset\" class=\"btn btn-default\">Limpiar</button>");
//		resp.getWriter().append("</div></form>");
//		
//		resp.getWriter().append("</div></body>");
//		resp.getWriter().append("</html>");
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		new HotelDB();
		String username = req.getParameter("usuario");
		String pass = req.getParameter("pass");
		if(!um.correctLogin(username,pass)){
			resp.sendRedirect("/login");
			return ;
		}
		User currentUser = um.getUser(username);
		HttpSession session = req.getSession();
		session.setAttribute("name", currentUser.getName());
		session.setAttribute("email", currentUser.getEmail());
		session.setAttribute("username", username);
		resp.sendRedirect("/listHotels");
	}
	
}
