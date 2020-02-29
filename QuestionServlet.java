package wm2.quiz;


import javax.servlet.http.*;
import javax.servlet.*;
import java.io.PrintWriter;
import java.util.*;

public class QuestionServlet extends HttpServlet{
	public  void init(){

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) {

	      ArrayList<CheckedAnswerss> checkedAnswerList = new ArrayList<CheckedAnswerss>();
        String userId = (String)request.getParameter("hiddenUserId");
        String userName = (String)request.getParameter("hiddenUserName");
        String currentQuestionId = (String)request.getParameter("getCurrentQuestionId2");
        String backButton  = (String)request.getParameter("BackButton");
        String nextButton  = (String)request.getParameter("NextButton");
        String variant = (String)request.getParameter("variant");
        int cQ = Integer.parseInt(currentQuestionId);
        boolean timeOverOrNot=true;

	try{
        wm2.quiz.findQuestion getQues = new findQuestion();
        PrintWriter wrt = response.getWriter();
        wm2.quiz.StartAndEndDate findDate = new wm2.quiz.StartAndEndDate();
        // timeOverOrNot = getQues.checkTime(findDate.getEndDate());
        // if (timeOverOrNot){
        //   System.out.println("Time is over");
      //     public static ArrayList<Result> UserResult = new ArrayList<Result>();
      //   int FalseAnswer = 0;
      //   int TrueAnswer = 0;
      //   int totalScore = 0;
      //   String userName = (String)request.getParameter("hiddenUserName2");
      //   String userPassword = (String)request.getParameter("hiddenUserPassword");
      //   PrintWriter wrt = response.getWriter();
      //   System.out.println(userName +" Welcome");
      //   wm2.quiz.findQuestion newFinQues = new wm2.quiz.findQuestion();
      //   // wrt.println();
      //   ArrayList<CheckedAnswerss> checkAnswersList = newFinQues.checkedAnswerList;
      //   Iterator iterator = checkAnswersList.iterator();
      //   while(iterator.hasNext()) {
      //     CheckedAnswerss stdQ = (CheckedAnswerss)iterator.next();
      //     if (stdQ.getTF()==true&&stdQ.getUserName().equals(userName)) {
      //       TrueAnswer++;
      //       totalScore=TrueAnswer*10;
      //     }
      //     else if(stdQ.getTF()==false&&stdQ.getUserName().equals(userName)){
      //       FalseAnswer++;
      //     }
      //   }  

      // Result newResult = new Result();
      // newResult.setUserName(userName);
      // newResult.setTrue(TrueAnswer);
      // newResult.setFalse(FalseAnswer);
      // newResult.setUserPassword(userPassword);
      // newResult.setTotalScore(totalScore);
      // UserResult.add(newResult);

      // wrt.println("<html><head></head><body>");
      //  request.getSession().setAttribute("Result",UserResult);
      //  RequestDispatcher view2 = request.getRequestDispatcher("resultPage.jsp");
      //  view2.forward(request,response);
        // }
        // else{
        //   System.out.println("False");
        // }

        if (variant.equals("1")||variant.equals("2")||variant.equals("3")){

           CheckedAnswerss newChecAns = getQues.checkQuestion(cQ, userName, variant);
           checkedAnswerList.add(newChecAns);
           if (backButton==null){
           cQ++;
               if (cQ>10) {
                   cQ--;
               }
           }
           else if(nextButton==null){
           cQ--;
               if (cQ==0) {
                   cQ++;
               }
           }     
        }
    	Question findQuestion = getQues.findQuestionWithId(cQ);
    	wrt.println("<html><head></head><body>");
      request.getSession().setAttribute("currentQuestion",findQuestion);
      RequestDispatcher view2 = request.getRequestDispatcher("view.jsp");
		  view2.forward(request,response);

		wrt.println("</body></html>");

      
        }

    catch (Exception ex) {
	      	System.out.println(ex);
	}

}

}