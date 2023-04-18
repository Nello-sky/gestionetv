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

  
<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  }else{ %>
		Aggiorna, ma non lasciare campi vuoti<br>
	<%}    %>

<% Televisore result = (Televisore)request.getAttribute("TelevisoreToUpdate");  %>

<form action="ExecuteEditTelevisoreService" method="post">

		
		<label for="marcaInput">MARCA:</label><br>
		<input type="text" name="marcaInput" id="marcaInputId" value="<%= result.getMarca()%>"  > 
		<br>
		<label for="modelloInputId">MODELLO:</label><br>
		<input type="text" name="modelloInput" id="modelloInputId" value="<%=result.getModello() %>" >
		<br><br>
		<label for="prezzoInputId">PREZZO:</label><br>
		<input type="text" name="prezzoInput" id="prezzoInputId" value="<%=result.getPrezzo()%>" >
		<br><br>
		<label for="polliciInputId">POLLICI:</label><br>
		<input type="text" name="polliciInput" id="polliciInputId" value="<%=result.getNumeroPollici() %>" >
		<br><br>
		<label for="codiceInputId">CODICE:</label><br>
		<input type="text" name="codiceInput" id="codiceInputId" value="<%=result.getCodice() %>" >
		<br><br>
		
		<input type="hidden" name="idUpdate" value="<%=result.getIdTelevisore() %>">
		<input type="submit" value="AGGIORNA">
	
	</form>

</body>
</html>