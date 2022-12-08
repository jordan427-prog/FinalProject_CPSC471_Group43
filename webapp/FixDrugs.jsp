<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Drugs to Modify</title>
<link rel="stylesheet" href = "HomeStyle.css">
</head>
<body>
<div class="header">
Modify & Manage Newly Requested Drugs
</div>


<form method=get action=PharmUpdateNulls>
<label>
Select Requested Drug Name
</label>
<select name="NullDrug">

<%

ArrayList<String> drugs=(ArrayList<String>)request.getAttribute("NullDrugs");
		
		for(int i=0;i<drugs.size();i++){
			out.println("<option>"+drugs.get(i)+"</option>");
		}


%>
</select>
<label>
Enter Known Company name for Drug:
</label>
<input type=text placeholder="Company" name=NullCompany required>
<label>
Enter Known Side Effect(s) for Drug
</label>
<input type=text placeholder="SideEffects" name=NullEffects required>


<input type=submit value="Submit">
</form>
<a href="PharmHome.jsp">Cancel</a>


</body>
</html>