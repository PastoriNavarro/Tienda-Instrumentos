package com.pastori.instrumentos.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pastori.instrumentos.bbdd.GestorBBDD;

/**
 * Servlet implementation class Actualizar
 */
@WebServlet("/Actualizar")
public class ActualizaInstrumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		int idCambio = Integer.parseInt(request.getParameter("id"));
		String nombreCambio = request.getParameter("nombre");
		int idTipoCambio = Integer.parseInt(request.getParameter("idtipo"));
		
		gestorBBDD.actualizarInstrumento(idCambio, nombreCambio, idTipoCambio);
		
		response.sendRedirect("./admin/listadoInstrumentos.jsp");
		
	}

}
