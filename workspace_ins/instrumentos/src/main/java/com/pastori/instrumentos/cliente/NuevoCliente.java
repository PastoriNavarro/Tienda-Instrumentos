package com.pastori.instrumentos.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pastori.instrumentos.bbdd.GestorBBDD;

/**
 * Servlet implementation class NuevoCliente
 */
@WebServlet("/NuevoCliente")
public class NuevoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GestorBBDD gestorBBDD = new GestorBBDD();

		String nombreAlta = request.getParameter("nombre");
		String apellidoAlta = request.getParameter("apellido");
		String direccionAlta = request.getParameter("direccion");
		String mailAlta = request.getParameter("mail");
		String passAlta = request.getParameter("pass");
		
		gestorBBDD.addCliente(nombreAlta, apellidoAlta, direccionAlta, mailAlta, passAlta);
		
		response.sendRedirect("./menuCliente.jsp");

	}

}