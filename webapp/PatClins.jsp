<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose Clinic for Doctors</title>
<link rel="stylesheet" href = "HomeStyle.css">
</head>
<body>

<div class="header">
DOCTOR FINDER - CLINIC SELECT

</div>
<br>
<br>
<b>Hello,  <%=request.getSession().getAttribute("FirstName") %>
 <%=request.getSession().getAttribute("LastName") %>
</b>
<br>
<br>
<i>Select the Clinic Below to Find Doctors</i>
<form method=get action=SearchDocByClinServ>
<label>
Select your clinic
</label>
<select name="ClinicName">

<%

ArrayList<String> clins=(ArrayList<String>)request.getAttribute("Clinics");
		
		for(int i=0;i<clins.size();i++){
			out.println("<option>"+clins.get(i)+"</option>");
		}


%>
</select>

<input type=submit value="Submit">
</form>
<a href="PatHome.jsp">Go Back Home</a>
</body>
</html>