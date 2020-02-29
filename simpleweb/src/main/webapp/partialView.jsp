<!-- <%@ page import = "java.util.*, wm2.quiz.Student,wm2.quiz.Question"%> 
<%
  ArrayList<Question> questionList = new ArrayList<Question>();

  
%> -->
<html>
<style type="text/css">
  #mainDiv p{
    padding: 10px;
  }
  .forButtons button{
    width: 100px;
    height: 30px;
  }
  .forFinishButton button{
    width: 100px;
    height: 30px;
  }
</style>
<head><title>Quiz Page</title></head>

<body>
 <!--  <h1 style="text-align: center;">Good Luck</h1>
  <table align="center" style="width:40%; text-align: center;">
  <tr>
    <th>ID</th>
    <th>User Name</th>
  </tr>

  <%
  String stData = (Student)session.getAttribute("newStudent");
  String getQuestionId = (String)session.getAttribute("quId");

  %>


  <tr>
    <td><%=getQuestionId%></td>
    <td><%=stData.getUserName()%></td> 
  </tr>

  </table>
  <div id="mainDiv" style="border: 5px solid green; height: 500px; width: 800px; margin: 0 auto;position: relative;">
  <div class="hoverDiv" style="position: absolute;width: 100%; height: 100%; background-color: green; opacity: 0.9; display: none;">
    <h1 style="text-align: center;margin-top:25%;">Finish</h1>
  </div>
  <form action="/Quiz/question-servlet" method="GET">
  <input type="hidden" name="hiddenUserId" value="<%=stData.getId()%>">
  <input type="hidden" name="hiddenUserName" value="<%=stData.getUserName()%>">
  <input type="hidden" name="getCurrentQuestionId" value="<%=stData.getCurrentQuestionId()%>">
  <h4><%=newQuestion.getId()+" "%>Sual.1</h4>
  
  <p><%=newQuestion.getQstatement()%></p>
  <p><input id="first" type="radio" name="variant" value="<%=newQuestion.getVarId1()%>"><label for="first">A) <%=newQuestion.getVarStat1()%> </label></input></p>
  <p><input id="second" type="radio" name="variant" value="<%=newQuestion.getVarId2()%>"><label for="second">B)  <%=newQuestion.getVarStat2()%></label></input></p>
  <p><input id="third" type="radio" name="variant" value="<%=newQuestion.getVarId3()%>"><label for="third">C) <%=newQuestion.getVarStat3()%></label></input></p>
  <div class="forButtons" style="display: flex;justify-content: space-around; padding: 50px"><button>Back</button> <button>Next</button></div>
  <div id="forFinishButton" style="display: flex;justify-content: center;"><button>Finish</button></div>
  <div class="content" style="display: flex;justify-content: space-between;">
  <p>Correct answers: 7</p>
  <p>Wrong answers: 3</p>
  </div>
  </form>
  </div>

   -->
   <h1>Salam</h1>>
</body>

</html>
