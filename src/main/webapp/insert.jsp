<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  }else{ %>
		Inserire dati da ricercare<br>
	<%}    %>

	<form action="ExecuteInsertTelevisoreServlet" method="post">
		<label for="marcaInput">MARCA:</label><br>
		<input type="text" name="marcaInput" id="marcaInputId">
		<br>
		<label for="modelloInputId">MODELLO:</label><br>
		<input type="text" name="modelloInput" id="modelloInputId">
		<br><br>
		<label for="prezzoInputId">PREZZO:</label><br>
		<input type="text" name="prezzoInput" id="prezzoInputId">
		<br><br>
		<label for="polliciInputId">POLLICI:</label><br>
		<input type="text" name="polliciInput" id="polliciInputId">
		<br><br>
		<label for="codiceInputId">CODICE:</label><br>
		<input type="text" name="codiceInput" id="codiceInputId">
		<br><br>
		
		<input type="submit" value="INSERT">
	
	</form>
	<hr> <br>

    <a href="http://localhost:8080/gestionetv/searchForm.jsp" target="_self" > Torna alla Ricerca </a>

</body>
</html>