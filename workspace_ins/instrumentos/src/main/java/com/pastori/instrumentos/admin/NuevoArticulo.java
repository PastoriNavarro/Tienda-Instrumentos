package com.pastori.instrumentos.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pastori.instrumentos.bbdd.GestorBBDD;

/**
 * Servlet implementation class NuevoArticulo
 */
@WebServlet("/NuevoArticulo")
public class NuevoArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		String nombreAlta = request.getParameter("nombre");
		int idTipo = Integer.parseInt(request.getParameter("id_tipo"));
		
		gestorBBDD.addInstrumento(nombreAlta, idTipo);
		
		response.sendRedirect("./admin/listadoInstrumentos.jsp");
	}

}
