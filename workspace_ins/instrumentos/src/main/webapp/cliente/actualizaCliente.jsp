<%@page import="com.pastori.instrumentos.beans.Cliente"%>
<%@page import="com.pastori.instrumentos.beans.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualiza Cliente</title>
<%
Admin usuario = (Admin) session.getAttribute("usuario");

if(usuario == null){
	String redirectURL = "../index.jsp";
	response.sendRedirect(redirectURL);
}
%>

</head>
<body>
<% 
Cliente cliente = new Cliente();
%>

<form action="../ActualizaCliente" method="get">

<label>Nombre</label>
<input type="text" name="nombre" value=<%=cliente.getNombre()%>/>

<label>Apellido</label>
<input type="text" name="apellido" value=<%=cliente.getApellido()%>/>

<label>Dirección</label>
<input type="text" name="direccion" value=<%=cliente.getDireccion()%>/>

<label>Mail</label>
<input type="email" name="mail" value=<%=cliente.getMail()%>/>

<label>Contraseña</label>
<input type="password" name="pass" value=<%=cliente.getPass()%>/>


<button type="submit">Alta</button>


 
</form>

</body>
</html>