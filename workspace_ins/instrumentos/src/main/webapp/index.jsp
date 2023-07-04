<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<form action="LoginAdmin" method="get">

<input type= "text" placeholder="Nombre de Usuario" name = "nombre" />
<label>Usuario</label>

<input type= "password" placeholder="Password" name = "pass" />
<label>Password</label>

<button type="submit">Login</button>

<a href="./cliente/nuevoCliente.jsp">No estoy registrado</a>


</form>

</body>
</html>