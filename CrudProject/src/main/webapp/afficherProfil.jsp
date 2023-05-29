<%@page import="beans.Paiment"%>
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
<h2>nom :</h2>
<h3><%=client.getNom() %></h3>
<h2>prenom :</h2>
<h3><%=client.getPrenom() %></h3>
<h2>age :</h2>
<h3><%=client.getAge() %></h3>
<h3><% if(client.getPaiment().getIdPaiment() != null)
{
	out.print(client.getPaiment().getIdPaiment());
	%>
<%}else
{
	out.print("--");
}
	%></h3>
<a href=AddPaiment1?id=<%= client.getId()%>>Ajouter Paiment</a>
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