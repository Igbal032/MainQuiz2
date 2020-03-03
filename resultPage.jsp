<%@ page import = "java.util.*,java.text.DateFormat,java.text.SimpleDateFormat,wm2.quiz.Result"%> 
<%
Result result = (Result)session.getAttribute("Result");
Date date = Calendar.getInstance().getTime();  
DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");  
// String strDate = dateFormat.format(result.getEndDate());  
%>

<!DOCTYPE html>
<html>
<head>
	<title>Result</title>
</head>
<body>
<div id="mainDiv" style="border:1px solid red; width: 800px; height: 300px">
	<h1>Name: <%=result.getUserName()%></h1>
	<h1>Correct Answer: <%=result.getTrue()%></h1>
	<h1>Wrong Answer: <%=result.getFalse()%></h1>
	<h1>Total Score: <%=result.getTotalScore()%></h1>
	<h1>End Date: <%=result.getEndDate()%></h1>
	<div class="buttonDiv" style="wid"100%><form method="GET" action="/Quiz/calculate-servlet"><button type="submit">Log Out</button></form></div>
 </div>
</body>
</html>