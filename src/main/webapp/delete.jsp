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



	<p> Vuoi eliminare? </p>
	<% Televisore result = (Televisore)request.getAttribute("TelevisoreToDelete");  %>
	<p>marca: <%= result.getMarca() %></p>
	<p>modello: <%= result.getModello() %></p>
	<p>prezzo: <%= result.getPrezzo() %></p>
	<p>pollici: <%= result.getNumeroPollici() %></p>
	<p>codice: <%= result.getCodice() %></p>

    <form action="ExecuteDeleteTelevisoreServlet" method="post">
		<input type="hidden" name="idDelete" value="<%=result.getIdTelevisore() %>">
		<input type="submit" value="ok">
	
	</form>

    <!-- aggiungere ulteriore controller-->
	<a href="http://localhost:8080/gestionetv/searchForm.jsp" target="_self"> Torna a risultati </a>
	
	
</body>
</html>