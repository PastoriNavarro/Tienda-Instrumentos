<%@page import="com.pastori.instrumentos.beans.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MenúAdmin</title>
<%
Admin usuario = (Admin)session.getAttribute("usuario");
if(usuario == null){
String redirectURL = "index.jsp";
response.sendRedirect(redirectURL);
}
%>
</head>
<body>

<a href="./admin/nuevoArticulo.jsp">Nuevo instrumento</a>
<a href="./admin/listadoInstrumentos.jsp">Gestión de instrumentos</a>
<a href="./admin/borrarArticulo.jsp">Borrar artículo</a>

</body>
</html>