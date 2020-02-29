<%@ page import = "java.util.*, wm2.quiz.Student, wm2.quiz.Question, wm2.quiz.findQuestion, wm2.quiz.CheckedAnswerss"%> 
<%
Student stData = (Student)session.getAttribute("newStudent");
Question currentQuestion =(Question)session.getAttribute("currentQuestion");
Question currentQ = new Question();
Integer currentVariantVal=0;
wm2.quiz.findQuestion getQues = new findQuestion();
 if(currentQuestion!=null){
   currentVariantVal = findQuestion.getSelectedId(currentQuestion.getId());
   currentQ = currentQuestion;
  }
  else{
  currentVariantVal=0;
  currentQ = getQues.findQuestionWithId(1);
  currentQuestion = currentQ;
  }
%>
<html>
<script type="text/javascript">
  document.addEventListener("DOMContentLoaded", function() {

  if("<%=currentVariantVal%>"=="<%=currentQuestion.getVarId1()%>"){
      var first = document.getElementById("first");
      first.setAttribute("checked",true);
      var second = document.getElementById("second").removeAttribute(checked);
      var third = document.getElementById("third").removeAttribute(checked);
      // var hiddenRadio = document.getElementById("hiddenRadio").removeAttribute(checked);   
   }
   else if("<%=currentVariantVal%>"=="<%=currentQuestion.getVarId2()%>"){
      var second = document.getElementById("second");
      second.setAttribute("checked",true);
      var first = document.getElementById("first").removeAttribute(checked);
      var third = document.getElementById("third").removeAttribute(checked);
      // var hiddenRadio = document.getElementById("hiddenRadio").removeAttribute(checked);   
    }
   else if("<%=currentVariantVal%>"=="<%=currentQuestion.getVarId3()%>"){
      var third = document.getElementById("third");
      third.setAttribute("checked",true);
      var first = document.getElementById("first").removeAttribute(checked);
      var second = document.getElementById("second").removeAttribute(checked);
      // var hiddenRadio = document.getElementById("hiddenRadio").removeAttribute(checked);   
   }
  

  });
  
</script>
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
  <input type="hidden" name="getCurrentQuestionId2" value="<%=currentQ.getId()%>">
  <!-- <input id="hiddenRadio" type="hidden"  name="variant"  value="4"/> -->

  
  <p><%=currentQ.getId()+". "%><%=currentQ.getQstatement()%></p>
  <p>
    <input id="first" type="radio"  name="variant"  value="<%=currentQ.getVarId1()%>"/>
    <label for="first">A) <%=currentQ.getVarStat1()%> </label></input></p>
  <p>
    <input id="second" type="radio" name="variant"  value="<%=currentQ.getVarId2()%>"/>
    <label for="second">B)  <%=currentQ.getVarStat2()%></label></input></p>
  <p>
    <input id="third" type="radio" name="variant"  value="<%=currentQ.getVarId3()%>"/>
    <label for="third">C) <%=currentQ.getVarStat3()%></label></input></p>
  <div class="forButtons" style="display: flex;justify-content: space-around; padding: 50px"><input type="submit" name="BackButton" value="Back"/> <input type="submit" name="NextButton" value="Next"></div>
  <div id="forFinishButton" style="display: flex;justify-content: center;"><button>Finish</button></div>
  <div class="content" style="display: flex;justify-content: space-between;">
  <p>Correct answers: 7</p>
  <p>Wrong answers: 3</p>
  </div>
  </form>
</div>

  

</body>

</html>
