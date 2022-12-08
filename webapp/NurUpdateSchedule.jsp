<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Schedule - Nurse</title>
<link rel="stylesheet" href = "HomeStyle.css">
</head>
<body>
Welcome Nurse <%=request.getSession().getAttribute("FirstName") %>
, <%=request.getSession().getAttribute("LastName") %> to the Update Schedule page!
<br>
<i>Please fill in the form below to update parameters of your unique schedule</i>
<br><br>

<form method=get action=NurUpdateSchedServ>
<label>
Select your Hours:
</label>
<select name="NurHours">
<% 
for(int i=0; i<=24; i++) {
out.println("<option>" + i +"</option>");
}
%>

</select>
<label>
Select your days:
</label>
<select name="NurDays">
<%
String[] weekdays={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
int i=0,j=0;
out.println("<option>Everyday</option>");
for(i=0;i<weekdays.length; i++){
	out.println("<option>"+weekdays[i]+"</option>");
	for(j=(i+1);j<weekdays.length;j++){
		String d=weekdays[i];
		d+="-";
		d+=weekdays[j];
		out.println("<option>"+d+"</option>");
	}
}
%>
</select>
<label>Enter Any Vacation Days: <i>(Enter none if N/A)</i> </label>
<input type=text placeholder="VacationDays" name=NurVac required>
<br>
<input type=submit value="Submit">
</form>


<a href="NurHome.jsp">Back to your Homepage</a>
<a href=NurGetSchedServ?param=<%= request.getSession().getAttribute("user") %>>Get My Schedule Instead</a>
</body>
</html>