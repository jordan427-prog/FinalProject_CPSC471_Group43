<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pharmacist - HomePage</title>
<link rel="stylesheet" href = "HomeStyle.css">

<style type=text/css>
ul{
	list-style-type: none;
	margin: 0;
	padding: 0;
	background-color: aqua;
	
}
li{
display:inline;
}
li a{
display: block;
color: black;
text-align:center;
}
li a:hover{
background-color: yellow;

}

</style>

</head>
<body>

<div class="header">
Welcome Pharmacist <%=request.getSession().getAttribute("FirstName") %>
, <%=request.getSession().getAttribute("LastName") %>
</div>


<ul>

<li><a href="HomePage.html">Log Out</a></li>
<br>
<li><a href="SearchDrug.html">Drug Search</a></li>
<br>
<li><a href="OrderDrug.html">Order a Drug</a></li>
<br>
<li><a href=PharmCheckInventory?param=<%= request.getSession().getAttribute("Username") %>>View Drug Inventory</a></li>
<br>
<li><a href=PharmManageNew?param=<%= request.getSession().getAttribute("user") %>>Manage Requested Drugs</a></li>

</ul>





</body>
</html>