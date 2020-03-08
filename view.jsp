<%@ page import = "java.util.*, wm2.quiz.Student, wm2.quiz.Question, wm2.quiz.findQuestion, wm2.quiz.CheckedAnswerss,wm2.quiz.StartAndEndDate"%> 
<%
Student stData = (Student)session.getAttribute("newStudent");
Question currentQuestion =(Question)session.getAttribute("currentQuestion");
Question currentQ = new Question();
Integer currentVariantVal=0;
StartAndEndDate dates=new StartAndEndDate(); 
wm2.quiz.findQuestion getQues = new findQuestion();
 if(currentQuestion!=null){
   currentVariantVal = findQuestion.getSelectedId(stData.getUserName(),currentQuestion.getId());
   currentQ = currentQuestion;
  }
  else{
  currentVariantVal=0;
  currentQ = getQues.findQuestionWithId(1);
  currentQuestion = currentQ;
  }
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
    <th>User Name</th>
    <th>Start Date</th>
    <th>End Date</th>
  </tr>
  <tr>
    <td><%=stData.getUserName()%></td>     
    <td><%=dates.getStartDate()%></td>
    <td><%=dates.getEndDate()%></td> 
  </tr>

  </table>
<div id="mainDiv" style="border: 5px solid green; height: 500px; width: 800px; margin: 0 auto;position: relative;">
  <div class="hoverDiv" style="position: absolute;width: 100%; height: 100%; background-color: green; opacity: 0.9; display: none;">
    <h1 style="text-align: center;margin-top:25%;">Finish</h1>
  </div>
  <form method="POST" action="/Quiz/question-servlet">
  <input type="hidden" name="hiddenUserId" value="<%=stData.getId()%>">
  <input type="hidden" name="hiddenUserName" value="<%=stData.getUserName()%>">
  <input type="hidden" name="getCurrentQuestionId2" value="<%=currentQ.getId()%>">
  <input id="hiddenCheck" type="hidden" name="checkedOrNot" value="">
  
  <p><%=currentQ.getId()+". "%><%=currentQ.getQstatement()%></p>
  <p class="statements">
    <input id="first" class="variantClass"type="radio" name="variant"  value="<%=currentQ.getVarId1()%>"/>
    <label for="first">A) <%=currentQ.getVarStat1()%> </label></input></p>
  <p class="statements">
    <input id="second" class="variantClass" type="radio" name="variant"  value="<%=currentQ.getVarId2()%>"/>
    <label for="second">B)  <%=currentQ.getVarStat2()%></label></input></p>
  <p class="statements">
    <input id="third" class="variantClass" type="radio" name="variant"  value="<%=currentQ.getVarId3()%>"/>
    <label for="third">C) <%=currentQ.getVarStat3()%></label></input></p>
  <div class="forButtons" style="display: flex;justify-content: space-around; padding: 50px">
    <input type="submit" name="BackButton" id="backButtonId" class="forwardButtons" value="Back"/> 
    <input type="submit" name="NextButton" id="nextButtonId" class="forwardButtons" value="Next">
  </div>
  </form>
  <form method="POST" action="/Quiz/calculate-servlet">
      <div id="forFinishButton" style="display: flex;justify-content: center;">
        <input type="hidden" name="hiddenUserName2" value="<%=stData.getUserName()%>">
        <input type="hidden" name="hiddenUserPassword" value="<%=stData.getPassword()%>">
        <button type="submit">Finish</button>
      </div>
  </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
  document.addEventListener("DOMContentLoaded", function() {
  if($("#hiddenCheck").val()!="checked"){
    $(".forwardButtons").css("display","none")
  }
  else{
    $(".forwardButtons").css("display","block")
  }
  if ("<%=currentQ.getId()%>"<=1) {
    $("#backButtonId").css("display","none")
  }
  else if ("<%=currentQ.getId()%>">=10) {
    $("#nextButtonId").css("display","none")
  }
  if("<%=currentVariantVal%>"=="<%=currentQuestion.getVarId1()%>"){
      $(".forwardButtons").css("display","block")
      var first = document.getElementById("first");
      first.setAttribute("checked",true);
      var second = document.getElementById("second").removeAttribute(checked);
      var third = document.getElementById("third").removeAttribute(checked);
   }
   else if("<%=currentVariantVal%>"=="<%=currentQuestion.getVarId2()%>"){
      $(".forwardButtons").css("display","block")
      var second = document.getElementById("second");
      second.setAttribute("checked",true);
      var first = document.getElementById("first").removeAttribute(checked);
      var third = document.getElementById("third").removeAttribute(checked);
    }
   else if("<%=currentVariantVal%>"=="<%=currentQuestion.getVarId3()%>"){
      $(".forwardButtons").css("display","block")
      var third = document.getElementById("third");
      third.setAttribute("checked",true);
      var first = document.getElementById("first").removeAttribute(checked);
      var second = document.getElementById("second").removeAttribute(checked);
   }

  });

  $("p.statements input, p.statements label").click(function(event){
    $("#hiddenCheck").val("checked")
    $(".forwardButtons").css("display","block")
  if ("<%=currentQ.getId()%>"<=1) {
    $("#backButtonId").css("display","none")
  }
  else if ("<%=currentQ.getId()%>">=10) {
    $("#nextButtonId").css("display","none")
  }
  })

</script>
</body>

</html>
