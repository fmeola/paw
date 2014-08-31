package ar.edu.itba.it.paw;

import hotelmanager.HotelManager;
import hotelmanager.HotelManagerJDBC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import manager.HotelManagerMem;
import model.Comment;
import model.Hotel;

@SuppressWarnings("serial")
public class ViewHotel extends HttpServlet {

//	private HotelManager hm = new HotelManagerMem();
	private HotelManager hm = new HotelManagerJDBC();
	private Hotel currentHotel;
	private String currentHotelCode;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		currentHotelCode = req.getParameter("code");
		currentHotel = hm.getHotel(currentHotelCode);
		HttpSession session = req.getSession();
		req.setAttribute("hotel", currentHotel);
		req.setAttribute("sesión", session);
		req.getRequestDispatcher("/WEB-INF/jsp/viewHotel.jsp").forward(req, resp);
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		currentHotelCode = req.getParameter("code");
//		
//		currentHotel = hm.getHotel(currentHotelCode);
//		HttpSession session = req.getSession();
//		
//		resp.getWriter().append("<html>");
//		resp.getWriter().append("<head>");
//		resp.getWriter().append("<title>Hotel " + currentHotel.getName() + "</title>");
//		resp.getWriter().append("<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
//		resp.getWriter().append("</head>");
//		resp.getWriter().append("<body><div class=\"container\">");
//		resp.getWriter().append("<h1>Hotel " + currentHotel.getName() + "</h1></br>");
//		resp.getWriter().append("<h2>" + currentHotel.getDescription() + "</h2>");
//		resp.getWriter().append("<h3>Código: " + currentHotel.getCode() + "</h3>");
//		resp.getWriter()
//				.append("<table class=\"table table-striped\"><tr><td><b>Usuario</b></td><td><b>EMail</b></td><td><b>Comentario</b></td>");
//		for(Comment c : currentHotel.getComments()) {
//			resp.getWriter().append(c.toString());
//		}
//		resp.getWriter().append("</table>");
//		resp.getWriter().append("</br>");
//		resp.getWriter().append("<h3>Deje su comentario aquí</h3>");
//		
//		resp.getWriter().append("<form role=\"form\" action=\"viewHotel\" method=\"post\"><div>");
//		resp.getWriter().append("<input type=\"hidden\" name=\"code\" value=\"" + currentHotelCode + "\">");
//		
//		if(session.getAttribute("name") != null){
//			resp.getWriter().append("<div class=\"form-group\"><label>" + session.getAttribute("name") + "</label></div>");
//			resp.getWriter().append("<div class=\"form-group\"><label>" + session.getAttribute("email") + "</label></div>");
//		} else {
//		resp.getWriter().append("<div><label>Usuario </label><input type=\"text\" name=\"usuario\" placeholder=\"Usuario\"></div>");
//		resp.getWriter().append("<div><label>EMail </label><input type=\"text\" name=\"email\" placeholder=\"EMail\"></div>");
//		}
//		
//		resp.getWriter().append("<div class=\"form-group\"><label>Comentario </label><textarea name=\"comentario\" class=\"form-control\" placeholder=\"Comentario\"></textarea></div>");
//		resp.getWriter().append("<button type=\"submit\" class=\"btn btn-primary\">Enviar</button>");
//		resp.getWriter().append("<button type=\"reset\" class=\"btn btn-default\">Limpiar</button>");
//		resp.getWriter().append("</div></form>");
//		resp.getWriter().append("</div></body>");
//		resp.getWriter().append("</html>");
//	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Hotel currentHotel = hm.getHotel(req.getParameter("code"));
		Comment newComment = new Comment(session.getAttribute("username").toString(),session.getAttribute("email").toString(),req.getParameter("comentario"));
		hm.addComment(currentHotel, newComment);
		resp.sendRedirect("/viewHotel?code=" + currentHotel.getCode());
	}
}
