<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor - HomePage</title>
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
Welcome Dr. <%=request.getSession().getAttribute("FirstName") %>
, <%=request.getSession().getAttribute("LastName") %>
</div>


<ul>

<li><a href="HomePage.html">Logout</a><li>

<br>
<li><a href=DocGetSchedule?param=<%= request.getSession().getAttribute("user") %>>Get Schedule</a>
<br>
<li><a href="DocUpdateSchedule.jsp">Update Schedule</a></li>

<br>
<li><a href=DocViewDrugsServ?param=<%= request.getSession().getAttribute("user") %>>View Available Drugs</a></li>	
<br>
<li><a href="DocGetDrugInfo.html">Get Drug Info/Drug Search</a></li>
<br>	
<li><a href="AssignNurses.html">Assign Nurses</a></li>
<br>
<li><a href="NurseIDLookup.html">Nurse ID Lookup</a></li>
<br>
<li><a href="DocViewPrescribe.html">View Prescriptions</a>
<br>
<li><a href=DocPrescribeInit?param=<%= request.getSession().getAttribute("user") %>>Prescribe Drug</a>
<br>
<li><a href="DocRequestDrug.html">Request New Drug</a></li>
<br>
<li><a href="DocInsertHistory.html">Insert Patient History</a></li>
<br>
<li><a href="DocInsertConds.html">Insert Patient Conditions</a></li>
<br>
<li><a href="DocViewHC.html">View Patient History or Conditions</a></li>
<br>
<li><a href=DocViewApp?identity=<%= request.getSession().getAttribute("user") %>>View Your Appointments</a></li>
<br>
<li><a href="PatientIDLookup.html">Patient ID Lookup</a></li>





</ul>




<!-- Remember to add logout and close session at bottom -->
</body>
</html>