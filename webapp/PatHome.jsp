<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Home</title>
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
Welcome Patient <%=request.getSession().getAttribute("FirstName") %>
, <%=request.getSession().getAttribute("LastName") %>
</div>


<ul>

<li><a href="HomePage.html">Logout</a></li> <br>
<li><a href="SideEffectSearch.html">Side Effect Search</a></li> <br>
<li><a href="PatBook.html">Book Appointment</a>	
<br>
<li><a href=PatViewClinics?param=<%= request.getSession().getAttribute("Username") %>>View Clinics</a>
<br>
<li><a href=PatGetClinics?param=<%= request.getSession().getAttribute("user") %>>DOCTOR FINDER!</a></li>
<br>
<li><a href=PatViewPrescrips?param=<%= request.getSession().getAttribute("user") %>>View Your Active Prescriptions</a></li>
<br>
<li><a href=PatViewAppoint?param=<%= request.getSession().getAttribute("user") %>>View Your Appointments</a>


</ul>


</body>
</html>