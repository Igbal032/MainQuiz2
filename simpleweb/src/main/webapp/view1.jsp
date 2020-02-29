<%@ page import = "java.util.*, wm2.quiz.Student, wm2.quiz.Question, wm2.quiz.findQuestion"%> 
<%
// Student stData = (Student)session.getAttribute("newStudent");

// String qId =(String)session.getAttribute("quId");
// System.out.println(qId+" Success-1");
// Question currentQ = new Question();
// wm2.quiz.findQuestion getQues = new findQuestion();
// if (!stData.equals(null)){
//     qId="1";
//     System.out.println(qId+"Success-2");
//     currentQ = getQues.findQuestionWithId(qId);
// }
// else{
//   currentQ = getQues.findQuestionWithId(qId);
//  }
// out.println(qId);
%>
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
  <h1 style="text-align: center;">Good Luck</h1>
  <table align="center" style="width:40%; text-align: center;">
  <tr>
    <th>ID</th>
    <th>User Name</th>
  </tr>
  <tr>
    <td><%=stData.getId()%></td>
    <td><%=stData.getUserName()%></td> 
  </tr>

  </table>
<div id="mainDiv" style="border: 5px solid green; height: 500px; width: 800px; margin: 0 auto;position: relative;">
  <div class="hoverDiv" style="position: absolute;width: 100%; height: 100%; background-color: green; opacity: 0.9; display: none;">
    <h1 style="text-align: center;margin-top:25%;">Finish</h1>
  </div>
  <form method="POST" action="/Quiz/question-servlet">
  <input type="hidden" name="hiddenUserId" value="<%=stData.getId()%>">
  <input type="hidden" name="hiddenUserName" value="<%=stData.getUserName()%>">
  <input type="hidden" name="getCurrentQuestionId" value="<%=stData.getCurrentQuestionId()%>">
  <input type="hidden" name="getCurrentQuestionId2" value="<%=qId%>">
  <h4><%=currentQ.getId()+" "%>Sual.1</h4>
  
  <p><%=currentQ.getQstatement()%></p>
  <p><input id="first" type="radio" name="variant" value="<%=currentQ.getVarId1()%>"><label for="first">A) <%=currentQ.getVarStat1()%> </label></input></p>
  <p><input id="second" type="radio" name="variant" value="<%=currentQ.getVarId2()%>"><label for="second">B)  <%=currentQ.getVarStat2()%></label></input></p>
  <p><input id="third" type="radio" name="variant" value="<%=currentQ.getVarId3()%>"><label for="third">C) <%=currentQ.getVarStat3()%></label></input></p>
  <div class="forButtons" style="display: flex;justify-content: space-around; padding: 50px"><button>Back</button> <button>Next</button></div>
  <div id="forFinishButton" style="display: flex;justify-content: center;"><button>Finish</button></div>
  <div class="content" style="display: flex;justify-content: space-between;">
  <p>Correct answers: 7</p>
  <p>Wrong answers: 3</p>
  </div>
  </form>
</div>

  

</body>

</html>
