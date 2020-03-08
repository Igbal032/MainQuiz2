package wm2.quiz;


import javax.servlet.http.*;
import javax.servlet.*;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.*;

public class QuestionServlet extends HttpServlet
{

    public void init()
{

}

public void doPost(HttpServletRequest request, HttpServletResponse response)
{


    ArrayList<CheckedAnswerss> checkedAnswerList = new ArrayList<CheckedAnswerss>();
    String userName = (String)request.getParameter("hiddenUserName");
    String currentQuestionId = (String)request.getParameter("getCurrentQuestionId2");
    String backButton = (String)request.getParameter("BackButton");
    String nextButton = (String)request.getParameter("NextButton");
    String variant = (String)request.getParameter("variant");
    String userPassword = (String)request.getParameter("hiddenUserPassword");
    int cQ = Integer.parseInt(currentQuestionId);
    boolean timeOverOrNot = true;
    try
    {
        HttpSession session = request.getSession(false);
        if (session != null)
        {
            System.out.println("In session and time " + session.getLastAccessedTime());
        }
        else
        {
            RequestDispatcher loginPage = request.getRequestDispatcher("index.html");
            loginPage.forward(request, response);
        }
        wm2.quiz.findQuestion getQues = new findQuestion();
        PrintWriter wrt = response.getWriter();
        wm2.quiz.StartAndEndDate findDate = new wm2.quiz.StartAndEndDate();
        timeOverOrNot = getQues.checkTime(findDate.getEndDate());
        if (timeOverOrNot)
        {
            int FalseAnswer = 0;
            int TrueAnswer = 0;
            int totalScore = 0;
            wm2.quiz.findQuestion newFinQues = new wm2.quiz.findQuestion();
            ArrayList<CheckedAnswerss> checkAnswersList = newFinQues.checkedAnswerList;
            Iterator iterator = checkAnswersList.iterator();
            while (iterator.hasNext())
            {
                CheckedAnswerss stdQ = (CheckedAnswerss)iterator.next();
                if (stdQ.getTF() == true && stdQ.getUserName().equals(userName))
                {
                    TrueAnswer++;
                    totalScore = TrueAnswer * 10;
                }
                else if (stdQ.getTF() == false && stdQ.getUserName().equals(userName))
                {
                    FalseAnswer++;
                }
            }
            Result newResult = new Result();
            newResult.setUserName(userName);
            newResult.setTrue(TrueAnswer);
            newResult.setFalse(FalseAnswer);
            newResult.setUserPassword(userPassword);
            newResult.setTotalScore(totalScore);
            newResult.setEndDate(new StartAndEndDate().getEndDate());
            CalculateServlet.UserResult.add(newResult);
            wrt.println("<html><head></head><body>");
            HttpSession ses = request.getSession();
            ses.invalidate();
            request.getSession().setAttribute("Result", newResult);
            RequestDispatcher view2 = request.getRequestDispatcher("resultPage.jsp");
            view2.forward(request, response);
            return;
        }

        if (variant.equals("1") || variant.equals("2") || variant.equals("3"))
        {

            CheckedAnswerss newChecAns = getQues.checkQuestion(cQ, userName, variant);
            checkedAnswerList.add(newChecAns);
            if (backButton == null)
            {
                cQ++;
                if (cQ > 10)
                {
                    cQ = 10;
                }
            }
            else if (nextButton == null)
            {
                cQ--;
                if (cQ <= 0)
                {
                    cQ = 1;
                }
            }
        }
        Question findQuestion = getQues.findQuestionWithId(cQ);
        wrt.println("<html><head></head><body>");
        request.getSession().setAttribute("currentQuestion", findQuestion);
        RequestDispatcher view2 = request.getRequestDispatcher("view.jsp");
        view2.forward(request, response);

        wrt.println("</body></html>");
    }

    catch (Exception ex)
    {
        System.out.println(ex);
    }

}

}