<%@page import="beans.Client"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 Client client = (Client )request.getAttribute("client");
%>
<h1>votre paiment</h1>


<form method="post" action="AfficherListPaiment?id=<%=client.getId() %>">
   
	<label>tarifs</label>
	<input type="number" name="tarifs"><br>
	<label>montant payee</label>
	<input type="number" name="montantpayee"><br>
	<label>date de paiment:</label>
	<input type="text" name="date"><br>
	<input type="submit" value="ajouter">
	
	
</form>

</body>
</html>