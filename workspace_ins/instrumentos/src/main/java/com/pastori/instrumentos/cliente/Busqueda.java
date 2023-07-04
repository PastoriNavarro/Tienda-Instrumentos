package com.pastori.instrumentos.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pastori.instrumentos.bbdd.GestorBBDD;

/**
 * Servlet implementation class busqueda
 */
@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		int idInstrumento = Integer.parseInt(request.getParameter("id"));
		String nombreBusqueda = request.getParameter("nombre");
		int idTipo = Integer.parseInt(request.getParameter("id_tipo"));
		
		
		gestorBBDD.buscar(nombreBusqueda);
		System.out.println(nombreBusqueda);
		
		response.sendRedirect("./menuCliente.jsp");
		
		
	}

}
