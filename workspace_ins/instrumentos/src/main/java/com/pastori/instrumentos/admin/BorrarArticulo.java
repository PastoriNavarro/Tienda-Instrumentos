package com.pastori.instrumentos.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pastori.instrumentos.bbdd.GestorBBDD;
import com.pastori.instrumentos.beans.Admin;
import com.pastori.instrumentos.beans.Instrumento;

/**
 * Servlet implementation class BorrarArticulo
 */
@WebServlet("/BorrarArticulo")
public class BorrarArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		gestorBBDD.borrarInstrumento(id);
		
		response.sendRedirect("./admin/listadoInstrumentos.jsp");
		
		
		
		
	}

}
