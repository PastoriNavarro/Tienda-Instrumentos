<%@page import="com.pastori.instrumentos.beans.Cliente"%>
<%@page import="com.pastori.instrumentos.beans.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Men� de Cliente</title>
<%
Cliente usuario = (Cliente)session.getAttribute("cliente");
if(usuario == null){
String redirectURL = "index.jsp";
response.sendRedirect(redirectURL);
}

%>
</head>
<body>

<a href="./cliente/actualizaCliente.jsp">Datos Personales</a>
<a href="./cliente/catalogoInstrumentos.jsp">Cat�logo de Productos</a>


</body>
</html>