<%@page import="beans.Client"%>
<%@page import="java.util.List"%>

<%@page import="beans.Paiment"%>
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
 Client client = (Client) request.getAttribute("listpayee");
%>
<table class="table">
<tr>
	<th> id </th>
	<th> tarif </th>
	<th> montant payee </th>
	<th> age </th>
	<th> actions </th>
</tr>
<%
for(Paiment paiment: client.getPaiments()){
%>



	<tr>
<td><a href="ShowProfil"><%=paiment.getIdPaiment() %>	</a></td>
<td><%=paiment.getTarifs() %></td>
<td><%=paiment.getMontantPayee() %></td>
<td><%=paiment.getDatePaiment() %></td>

<td><a href="DeleteClient?id=<%=paiment.getIdPaiment()%>" >delete</a> <a href="RecupeClient?id=<%=paiment.getIdPaiment()%>">update</a></td>
</tr>


<%} %>




</table>
</body>
</html>