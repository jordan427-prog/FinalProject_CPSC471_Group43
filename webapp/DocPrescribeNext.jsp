<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prescription-Next Step</title>
<link rel="stylesheet" href = "HomeStyle.css">
</head>

<body>


<div class="header">
Prescribe Drug - Next Step

</div>
<br>
<br>
<b>Hello,  <%=request.getSession().getAttribute("FirstName") %>
 <%=request.getSession().getAttribute("LastName") %>
</b>
<br>
<br>
<i>Select the Drug to prescribe from available drugs in the system:</i>
<form method=get action=DocPrescribeFin>
<label>
Select Drug to Assign
</label>
<select name="Drug_name">

<%

ArrayList<String> drugs=(ArrayList<String>)request.getAttribute("Drugs");
		
		for(int i=0;i<drugs.size();i++){
			out.println("<option>"+drugs.get(i)+"</option>");
		}


%>
</select>
<label>
Select Patient to Prescribe to
</label>
<select name="Pat_Name">

<%

ArrayList<Integer> patz=(ArrayList<Integer>)request.getAttribute("PatIDs");
		
		for(int i=0;i<patz.size();i++){
			out.println("<option>"+patz.get(i)+"</option>");
		}


%>
</select>

<label>
Prescription Month
</label>
<select name="Month">

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
Prescription Day
</label>
<select name="Day">

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
Prescription Year
</label>
<select name="Year">

<%

//ArrayList<Integer> patz=(ArrayList<Integer>)request.getAttribute("PatIDs");
		
		for(int k=2000;k<2023;k++){
			String yr=Integer.toString(k);
				out.println("<option>"+yr+"</option>");
			
			//out.println("<option>"+patz.get(i)+"</option>");
		}


%>
</select>

<label>
Enter any Doctor Notes
</label>
<input type=text placeholder="Notes" name="DocNotes"required>

<label>
Enter Dosage
</label>
<input type=text placeholder="Dosage" name="Dosage"required>

<input type=submit value="Submit">
</form>

<center>
<b>Reminder: Use the 'request drugs' link on your homepage to request a drug not in the system!</b>
<br>
<i>Note: Patient ID is used for patient confidentiality purposes, rather than name</i><br>
<a href="DocHome.jsp">Home</a>
</center>

</body>
</html>