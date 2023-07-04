<%@page import="com.pastori.instrumentos.beans.Admin"%>
<%@page import="com.pastori.instrumentos.bbdd.GestorBBDD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Cliente</title>
<%
Admin usuario = (Admin)session.getAttribute("usuario");
if(usuario == null){
String redirectURL = "index.jsp";
response.sendRedirect(redirectURL);
}
%>
</head>
<body>

<form action="../NuevoCliente" method="get">

<label>Nombre</label>
<input type="text" placeholder="Nombre" name="nombre"/>

<label>Apellido</label>
<input type="text" placeholder="Apellido" name="apellido"/>

<label>Dirección</label>
<input type="text" placeholder="Direccion" name="direccion"/>

<label>Mail</label>
<input type="email" placeholder="Mail" name="mail"/>

<label>Contraseña</label>
<input type="password" placeholder="Pass" name="pass"/>


<button type="submit">Alta</button>


 
</form>

</body>
</html>