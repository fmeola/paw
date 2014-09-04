package ar.edu.itba.it.paw;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Logout extends HttpServlet {

	// TODO ¿La conexión nunca se cierra?
	
	protected void doGet(javax.servlet.http.HttpServletRequest req,
			javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		HttpSession session = req.getSession();
		session.setAttribute("name", null);
		resp.sendRedirect(req.getContextPath() + "/login");
	};
}
