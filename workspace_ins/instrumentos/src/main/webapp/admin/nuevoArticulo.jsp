<%@page import="com.pastori.instrumentos.bbdd.GestorBBDD"%>
<%@page import="com.pastori.instrumentos.beans.Tipo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pastori.instrumentos.beans.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta</title>
<%
Admin usuario = (Admin)session.getAttribute("usuario");
if(usuario == null){
String redirectURL = "index.jsp";
response.sendRedirect(redirectURL);
}
%>
</head>
<body>


</body>
<%
GestorBBDD gestorBBDD = new GestorBBDD();
ArrayList<Tipo> tipos = gestorBBDD.getListadoTipos();
%>

<form action="../NuevoArticulo" method="get">

<label>Nombre</label>
<input type="text" placeholder="Nombre" name="nombre"/>

<label>Tipo</label>
<select name="id">
<%
for(int i = 0; i < tipos.size(); i++){
	Tipo tipo = tipos.get(i);
%>

<option value="<%=tipo.getId()%>"><%=tipo.getNombre()%></option>
<%}%>
</select>

<button type="submit">Alta</button>


 
</form>
</html>