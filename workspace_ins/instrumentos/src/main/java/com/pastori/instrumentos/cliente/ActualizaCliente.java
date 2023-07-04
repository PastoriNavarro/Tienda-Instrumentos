package com.pastori.instrumentos.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pastori.instrumentos.bbdd.GestorBBDD;

/**
 * Servlet implementation class actualizaCliente
 */
@WebServlet("/actualizaCliente")
public class ActualizaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		int idCambio = Integer.parseInt(request.getParameter("id"));
		String nombreCambio = request.getParameter("nombre");
		String apellidoCambio = request.getParameter("apellido");
		String direccionCambio = request.getParameter("direccion");
		String mailCambio = request.getParameter("mail");
		String passCambio = request.getParameter("pass");
		
		gestorBBDD.actualizaCliente(idCambio, nombreCambio, apellidoCambio, direccionCambio, mailCambio, passCambio);
		
		
		
	}

}
