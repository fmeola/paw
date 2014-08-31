package ar.edu.itba.it.paw;

import java.io.IOException;

import hotelmanager.HotelManager;
import hotelmanager.HotelManagerJDBC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hotel;

@SuppressWarnings("serial")
public class AddHotel extends HttpServlet {

	private HotelManager hm = new HotelManagerJDBC();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/addHotel.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int codigo = Integer.valueOf(req.getParameter("codigo"));
		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("descripcion");
		hm.addHotel(new Hotel(codigo, nombre, descripcion, null));
		resp.sendRedirect("/listHotels");
	}
	
}
