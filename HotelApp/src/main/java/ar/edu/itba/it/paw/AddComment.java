package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddComment extends HttpServlet {

	Comment c;
//	private Map<String, Hotel> db = (Map<String, Hotel>) getServletConfig().getServletContext().getAttribute("db");
	private Map<String, Hotel> db = (new HotelDB()).getDB();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Hotel currentHotel = db.get(req.getParameter("code"));
		List<Comment> comments = currentHotel.getComments();
		Comment newComment = new Comment(req.getParameter("usuario"),req.getParameter("email"),req.getParameter("comentario"));
		comments.add(newComment);
		currentHotel.setComments(comments);
		db.put("300",currentHotel);
//		getServletConfig().getServletContext().setAttribute("db", db);
		resp.sendRedirect("/viewHotel?code=" + currentHotel.getCode());
	}
}
