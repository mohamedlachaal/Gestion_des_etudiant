
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
	<form action="UpdateClient?id=<%=client.getId() %>" method="post" >

	
	
	
	 <div class="form-group">
      <label for="nom">nom:</label>
      <input type="text" class="form-control" id="nom" placeholder="Enter votre nom" value="<%=client.getNom() %>" name="nom">
    </div>
    <div class="form-group">
      <label for="prenom">prenom:</label>
      <input type="text" class="form-control" id="prenom" placeholder="Enter votre prenom" value="<%=client.getPrenom() %>" name="prenom">
    </div>
  
    <div class="form-group">
      	<label for="age">age:</label>
      	<input type="number" class="form-control" id="age" placeholder="Enter votre age" value="<%=client.getAge() %>" name="age">
    </div>
   
   <input type="submit" value="modifier"     class="btn btn-primary" > 
	
	</form>
</body>
</html>