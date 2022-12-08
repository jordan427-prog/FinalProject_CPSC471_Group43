<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose Clinic</title>
<link rel="stylesheet" href = "HomeStyle.css">
</head>
<body>



<div class="header">
NURSE ASSIGNMENT - CLINIC SELECT

</div>
<br>
<br>
<b>Hello,  <%=request.getSession().getAttribute("FirstName") %>
 <%=request.getSession().getAttribute("LastName") %>
</b>
<br>
<br>
<i>Select the Clinic Below to Assign to Clinic</i>
<form method=get action=DocGetNursesWithClinicServ>
<label>
Select Clinic to Assign Nurse
</label>
<select name="ClinicName">

<%

ArrayList<String> clins=(ArrayList<String>)request.getAttribute("Clinics");
		
		for(int i=0;i<clins.size();i++){
			out.println("<option>"+clins.get(i)+"</option>");
		}


%>
</select>
<label>
Select Nurse to Assign by id (to clinic selected above)
</label>
<select name="NurseName">

<%

ArrayList<Integer> nurses=(ArrayList<Integer>)request.getAttribute("Nurses");
		
		for(int i=0;i<nurses.size();i++){
			out.println("<option>"+nurses.get(i)+"</option>");
		}


%>
</select>

<input type=submit value="Submit">
</form>
<a href="DocHome.jsp">Go Back Home</a>

<br><br>
<b>IMPORTANT: USE THE NURSE ID FINDER ON THE HOMEPAGE TO MATCH ID WITH NURSE NAME (if unknown)</b>
<br>
<b>Find Nurse ID via Nurse ID Lookup here:</b>
<br>
<a href="NurseIDLookup.html">Nurse ID Finder</a>



</body>
</html>