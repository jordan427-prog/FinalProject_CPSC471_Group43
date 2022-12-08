<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nurse Home</title>
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
Welcome Nurse <%=request.getSession().getAttribute("FirstName") %>
, <%=request.getSession().getAttribute("LastName") %>
</div>

<b><center>NURSE OPTIONS</center></b>
<br>
<ul>

<li><a href="HomePage.html">Logout</a></li>
<br>
<li><a href="NurUpdateSchedule.jsp">Update Schedule</a></li>
<br>
<li><a href=NurViewClinics?param=<%= request.getSession().getAttribute("Username") %>>View Clinics</a>
<br>
<li><a href="AssignClinic.html">Assign Clinic</a></li>
<br>
<li><a href="SearchDocs.html">Search Doctors</a></li>
<br>
<li><a href=NurGetSchedServ?param=<%= request.getSession().getAttribute("user") %>>Get Schedule</a>
<br>
<li><a href=NurGetClinicServ?param=<%= request.getSession().getAttribute("user") %>>Get My Clinic!</a>
<br>
<li><a href=NurViewAppoints?param=<%= request.getSession().getAttribute("user") %>>View My Appointments</a>

</ul>


</body>



</html>