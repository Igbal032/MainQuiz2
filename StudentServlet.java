package wm2.quiz;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;

public class StudentServlet extends HttpServlet
{

    public void init()
{

}
public static ArrayList<Student> registeredStudent = new ArrayList<Student>();

public void doPost(HttpServletRequest request, HttpServletResponse response)
{
    Integer ID = 0;
    String userName = (String)request.getParameter("userName");
    String password = (String)request.getParameter("password");
    boolean checkStudent = false;
    boolean exist = false;
    try
    {
        PrintWriter wrt = response.getWriter();
        wrt.println("<html><head></head><body>");

        if (userName.equals("") || password.equals(""))
        {
            wrt.println("<h1>Please,fill all inputs</h1>");
        }
        else
        {
            ArrayList<Result> resultList = wm2.quiz.CalculateServlet.UserResult;
            if (!resultList.isEmpty())
            {
                Iterator iteratorResult = wm2.quiz.CalculateServlet.UserResult.iterator();
                Iterator iteratorUsers = registeredStudent.iterator();
                while (iteratorResult.hasNext())
                {
                    Result rst = (Result)iteratorResult.next();
                    if (rst.getUserName().equals(userName))
                    {
                        exist = true;
                        Student findS;
                        while(iteratorUsers.hasNext()){
                            findS = (Student)iteratorUsers.next();
                            if (findS.getUserName().equals(rst.getUserName())) {
                               if (rst.getUserPassword().equals(findS.getPassword()))
                                {
                                    request.getSession().setAttribute("Result", rst);
                                    RequestDispatcher view2 = request.getRequestDispatcher("resultPage.jsp");
                                    view2.forward(request, response);
                                    return;
                                }
                                else
                                {
                                    wrt.println("<h1 style='color:red'>Exist User Name or Wrong Answer");
                                    return;
                                } 
                            }
                        }
                        
                    }

                }

                if (!exist)
                {
                    Student newStudent = new Student();
                    newStudent.setId(++ID);
                    newStudent.setUserName(userName);
                    newStudent.setPassword(password);
                    newStudent.setCurrentQuestionId(1);
                    registeredStudent.add(newStudent);
                    StartAndEndDate date = new StartAndEndDate();
                    Calendar calendar = Calendar.getInstance();
                    date.setStartDate(calendar.getTime());
                    calendar.add(Calendar.MINUTE, 5);
                    date.setEndDate(calendar.getTime());
                    HttpSession session = request.getSession();
                    request.getSession().setAttribute("newStudent", newStudent);
                    RequestDispatcher view = request.getRequestDispatcher("view.jsp");
                    view.forward(request, response);

                }
            }
            else
            {
                System.out.println("Result doesnt exist");
                StartAndEndDate date = new StartAndEndDate();
                Calendar calendar = Calendar.getInstance();
                date.setStartDate(calendar.getTime());
                System.out.println(date.getStartDate() + " currentTime");
                calendar.add(Calendar.MINUTE, 5);
                date.setEndDate(calendar.getTime());
                System.out.println(date.getEndDate() + " add 5 minutes");
                Student newStudent = new Student();
                newStudent.setId(++ID);
                newStudent.setUserName(userName);
                newStudent.setPassword(password);
                newStudent.setCurrentQuestionId(1);
                registeredStudent.add(newStudent);
                HttpSession session = request.getSession();
                request.getSession().setAttribute("newStudent", newStudent);
                RequestDispatcher view = request.getRequestDispatcher("view.jsp");
                view.forward(request, response);

            }
        }
        wrt.println("</body></html>");

    }

    catch (Exception ex)
    {
        ;
    }

}

}