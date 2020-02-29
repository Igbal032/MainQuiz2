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

	try{
        wm2.quiz.findQuestion getQues = new findQuestion();
        PrintWriter wrt = response.getWriter();


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