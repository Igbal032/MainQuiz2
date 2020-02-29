package wm2.quiz;


import javax.servlet.http.*;
import javax.servlet.*;
import java.io.PrintWriter;
import java.util.*;

public class CalculateServlet extends HttpServlet{
	public  void init(){

	}
  public static ArrayList<Result> UserResult = new ArrayList<Result>();
	public void doPost(HttpServletRequest request,HttpServletResponse response) {

	try{
        int FalseAnswer = 0;
        int TrueAnswer = 0;
        int totalScore = 0;
        String userName = (String)request.getParameter("hiddenUserName2");
        String userPassword = (String)request.getParameter("hiddenUserPassword");
        PrintWriter wrt = response.getWriter();
        wm2.quiz.findQuestion newFinQues = new wm2.quiz.findQuestion();
        // wrt.println();
        ArrayList<CheckedAnswerss> checkAnswersList = newFinQues.checkedAnswerList;
        Iterator iterator = checkAnswersList.iterator();
        while(iterator.hasNext()) {
          CheckedAnswerss stdQ = (CheckedAnswerss)iterator.next();
          if (stdQ.getTF()==true&&stdQ.getUserName().equals(userName)) {
            TrueAnswer++;
            totalScore=TrueAnswer*10;
          }
          else if(stdQ.getTF()==false&&stdQ.getUserName().equals(userName)){
            FalseAnswer++;
          }
        }  

      Result newResult = new Result();
      newResult.setUserName(userName);
      newResult.setTrue(TrueAnswer);
      newResult.setFalse(FalseAnswer);
      newResult.setUserPassword(userPassword);
      newResult.setTotalScore(totalScore);
      newResult.setEndDate(new Date());
      UserResult.add(newResult);

    	wrt.println("<html><head></head><body>");
       request.getSession().setAttribute("Result",newResult);
       RequestDispatcher view2 = request.getRequestDispatcher("resultPage.jsp");
		   view2.forward(request,response);

		wrt.println("</body></html>");

      
        }

    catch (Exception ex) {
	      	System.out.println(ex);
	}

}

}