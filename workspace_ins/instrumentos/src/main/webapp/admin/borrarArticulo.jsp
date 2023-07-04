<%@page import="com.pastori.instrumentos.beans.Admin"%>
<%@page import="com.pastori.instrumentos.beans.Instrumento"%>
<%@page import="com.pastori.instrumentos.bbdd.GestorBBDD"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar articulo</title>
<%
Admin admin = (Admin) session.getAttribute("ususario");
if (admin == null) {
	String redirectURL = "../index.jsp";
	response.sendRedirect(redirectURL);
}
%>
</head>
<body>

	<%
	GestorBBDD gestorBBDD = new GestorBBDD();
	ArrayList<Instrumento> instrumento = gestorBBDD.getListadoInstrumentos(); 
	%>

	<form action="../BorrarArticulo" method="get">

		<select name="id">

	<%
    for(int i = 0; i < instrumento.size(); i++){
    Instrumento ins = instrumento.get(i);
    %>

	<option value="<%=ins.getId() %>"><%=ins.getNombre()%></option>
	<%}%>
	</select>
	

	<button type="submit">Borrar</button>
	</form>

</body>
</html>