<%@page import="com.pastori.instrumentos.beans.Admin"%>
<%@page import="com.pastori.instrumentos.beans.Tipo"%>
<%@page import="com.pastori.instrumentos.beans.Instrumento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pastori.instrumentos.bbdd.GestorBBDD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado instrumentos</title>
<%
Admin usuario = (Admin) session.getAttribute("usuario");
if(usuario == null){
	String redirectURL = "../index.jsp";
	response.sendRedirect(redirectURL);
}
%>
</head>
<body>

	<h1>LISTADO ISTRUMENTOS</h1>

	<%GestorBBDD gestorBBDD = new GestorBBDD();
ArrayList<Instrumento> ins = gestorBBDD.getListadoInstrumentos();
%>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>NONBRE</th>
				<th>TIPO</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(int i = 0; i < ins.size(); i++){
			Instrumento instrumento = ins.get(i);
			int id_tipo = instrumento.getIdTipo();
			Tipo nombreTipo = gestorBBDD.getTipoById(id_tipo);
			%>
			<tr>
				<th><%=instrumento.getId()%></th>
				<td><%=instrumento.getNombre()%></td>
				<td><%=nombreTipo%></td>
				<td></td>
				<%} %>
			
		</tbody>
	</table>

</body>
</html>