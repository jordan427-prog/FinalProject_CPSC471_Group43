<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose Doctor From Clinic</title>
<link rel="stylesheet" href = "HomeStyle.css">
</head>
<body>
<div class="header">
Choose Doctor From <%= request.getAttribute("Clin_Name") %>
</div>

<form method=get action=FinalizeAppointment>
<label>
Select Doctor From <%= request.getAttribute("Clin_Name") %>
</label>
<select name="DoctorSelect">

<%

ArrayList<String> docz=(ArrayList<String>)request.getAttribute("DocsFromClin");
		
		for(int i=0;i<docz.size();i++){
			out.println("<option>"+docz.get(i)+"</option>");
		}


%>
</select>
<label>
Select Time
</label>
<select name="app_time">
<%


		
		for(int i=0;i<24;i++){
			for(int j=0; j<60;j+=15){
				
				String time=Integer.toString(i);
				time+=":";
				time+=Integer.toString(j);
				out.println("<option>"+time+"</option>");
			}
			
			
		
		}


%>
</select>

<label>
Select Month
</label>
<select name="app_month">

<%

//ArrayList<Integer> patz=(ArrayList<Integer>)request.getAttribute("PatIDs");
		
		for(int i=1;i<13;i++){
			String mon=Integer.toString(i);
				out.println("<option>"+mon+"</option>");
			
			//out.println("<option>"+patz.get(i)+"</option>");
		}


%>
</select>



<label>
Appointment Day
</label>
<select name="app_day">

<%

//ArrayList<Integer> patz=(ArrayList<Integer>)request.getAttribute("PatIDs");
		
		for(int j=1;j<32;j++){
			String day=Integer.toString(j);
				out.println("<option>"+day+"</option>");
			
			//out.println("<option>"+patz.get(i)+"</option>");
		}


%>
</select>


<label>
Appointment Year
</label>
<select name="app_year">

<%

//ArrayList<Integer> patz=(ArrayList<Integer>)request.getAttribute("PatIDs");
		
		for(int k=2022;k<=2023;k++){
			String yr=Integer.toString(k);
				out.println("<option>"+yr+"</option>");
			
			//out.println("<option>"+patz.get(i)+"</option>");
		}


%>
</select>

<br>
<b>
Pre-filled...DO NOT TOUCH
</b>
<input type=text name="pat_id_req" value=<%= request.getAttribute("PatIDreq") %>>
<input type=text name="appno_req" value=<%= request.getAttribute("App_numb") %>>
<input type=text name="clinic_requ" value=<%= request.getAttribute("Clin_Name") %>>




<input type=submit value="Submit">
</form>
<a href="PatHome.jsp">Go Back Home</a>
</body>
</html>