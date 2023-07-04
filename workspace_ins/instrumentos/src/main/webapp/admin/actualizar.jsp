<%@page import="com.pastori.instrumentos.beans.Tipo"%>
<%@page import="com.pastori.instrumentos.beans.Instrumento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pastori.instrumentos.bbdd.GestorBBDD"%>
<%@page import="com.pastori.instrumentos.beans.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar instrumento</title>
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
GestorBBDD gestorBBDD = new GestorBBDD();
ArrayList<Tipo> tipo = gestorBBDD.getListadoTipos();
Instrumento instrumento = new Instrumento();
%>

<form action="../Actualizar" method="get">

<input type="text" name="nombreCambio" value="<%=instrumento.getNombre()%>"/>
</form>
</body>
</html>