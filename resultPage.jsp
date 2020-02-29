<%@ page import = "java.util.*,java.text.DateFormat,java.text.SimpleDateFormat,wm2.quiz.Result"%> 
<%
Result result = (Result)session.getAttribute("Result");
Date date = Calendar.getInstance().getTime();  
DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");  
String strDate = dateFormat.format(result.getEndDate());  
%>

<!DOCTYPE html>
<html>
<head>
	<title>Result</title>
</head>
<body>
<div id="mainDiv" style="border:1px solid red; width: 500px; height: 300px">
	<h1>Name: <%=result.getUserName()%></h1>
	<h1>Correct Answer: <%=result.getTrue()%></h1>
	<h1>Wrong Answer: <%=result.getFalse()%></h1>
	<h1>Total Score: <%=result.getTotalScore()%></h1>
	<h1>End Date: <%=strDate%></h1>
<!-- 	<h1>Password: <%=result.getUserPassword()%></h1>
 --></div>
</body>
</html>