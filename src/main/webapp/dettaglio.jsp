<%@page import="it.prova.gestionetv.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% Televisore result = (Televisore )request.getAttribute("televisoreDaInviareAPaginaDettaglio");  %>
	<p>marca: <%= result.getMarca() %></p>
	<p>modello: <%= result.getModello() %></p>
	<p>prezzo: <%= result.getPrezzo() %></p>
	<p>pollici: <%= result.getNumeroPollici() %></p>
	<p>codice: <%= result.getCodice() %></p>
	
	 <a href="http://localhost:8080/gestionetv/searchForm.jsp" target="_self" > Torna alla Ricerca </a>

</body>
</html>