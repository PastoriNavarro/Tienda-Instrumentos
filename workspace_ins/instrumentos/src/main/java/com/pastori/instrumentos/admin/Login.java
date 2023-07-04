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
import com.pastori.instrumentos.beans.Cliente;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreLogin = request.getParameter("nombre");
		String passLogin = request.getParameter("pass");
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		Admin usuarioLogado = gestorBBDD.loginAdmin(nombreLogin, passLogin);
		HttpSession sesion = request.getSession();
		if(usuarioLogado != null) {
			sesion.setAttribute("usuario", usuarioLogado);
			response.sendRedirect("menuAdmin.jsp");
		} else{
			Cliente clienteLogado = gestorBBDD.loginCliente(nombreLogin, passLogin);
			 if (clienteLogado != null || usuarioLogado == null) {
				 sesion.setAttribute("cliente", clienteLogado);
				response.sendRedirect("menuCliente.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}
		}
	}

}
