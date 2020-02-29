package wm2.quiz;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.PrintWriter;
import java.util.*;

public class StudentServlet extends HttpServlet{
	public  void init(){

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
	Integer ID=0;
	String userName = (String)request.getParameter("userName");
	String password = (String)request.getParameter("password");
	boolean checkStudent=false;
	ArrayList<Student> registeredStudent = new ArrayList<Student>();
	int size = registeredStudent.size();
	boolean exist=false;

	try{
	    PrintWriter wrt = response.getWriter();
    	wrt.println("<html><head></head><body>");

    	if (userName.equals("")||password.equals("")) {
    
	   			 wrt.println("<h1>Please,fill all inputs</h1>");
		}
		else{
			ArrayList<Result> resultList = wm2.quiz.CalculateServlet.UserResult;
			if (!resultList.isEmpty()){
			Iterator iterator = wm2.quiz.CalculateServlet.UserResult.iterator();
			while(iterator.hasNext()) {
				Result rst = (Result)iterator.next();
    			if (rst.getUserName().equals(userName)){
    				exist=true;
    				if (rst.getUserPassword().equals(password)){
					  System.out.println("Redirect to Result Page");
     				  request.getSession().setAttribute("Result",rst);
     				  RequestDispatcher view2 = request.getRequestDispatcher("resultPage.jsp");
					  view2.forward(request,response);
					  return;
    				}
    				else{
    					wrt.println("<h1 style='color:red'>Exist User Name or Wrong Answer");
    					return;
    				}
    			}

			}

    		if(!exist){
					Student newStudent = new Student();
					newStudent.setId(++ID);
	        		newStudent.setUserName(userName);
	        		newStudent.setPassword(password);
					newStudent.setCurrentQuestionId(1);
	        		registeredStudent.add(newStudent);
				    StartAndEndDate date = new StartAndEndDate();
   					Calendar calendar = Calendar.getInstance();
				    date.setStartDate(calendar.getTime());
					System.out.println(date.getStartDate()+" currentTime");
				    calendar.add(Calendar.MINUTE, 5);
				    date.setEndDate(calendar.getTime());
					System.out.println(date.getEndDate()+" add 5 minutes");
					Iterator iterator2 = registeredStudent.iterator();
					while(iterator2.hasNext()) {
					Student std = (Student)iterator2.next();
    				if (std.getUserName().equals(userName)) {

    					request.getSession().setAttribute("newStudent",newStudent);
		    		    RequestDispatcher view = request.getRequestDispatcher("view.jsp");
		    		    view.forward(request,response);
		    		    return;
    				}
					}	
    		}
			}
			else{
				StartAndEndDate date = new StartAndEndDate();
   				Calendar calendar = Calendar.getInstance();
				date.setStartDate(calendar.getTime());
				System.out.println(date.getStartDate()+" currentTime");
				calendar.add(Calendar.MINUTE, 5);
				date.setEndDate(calendar.getTime());
				System.out.println(date.getEndDate()+" add 5 minutes");
				Student newStudent = new Student();
				newStudent.setId(++ID);
	        	newStudent.setUserName(userName);
	        	newStudent.setPassword(password);
				newStudent.setCurrentQuestionId(1);
	        	registeredStudent.add(newStudent);
				Iterator iterator2 = registeredStudent.iterator();
				while(iterator2.hasNext()) {
				Student std = (Student)iterator2.next();
    			if (std.getUserName().equals(userName)) {
    				request.getSession().setAttribute("newStudent",newStudent);
		    	    RequestDispatcher view = request.getRequestDispatcher("view.jsp");
		    	    view.forward(request,response);
    			}
				}
			}
		}
		wrt.println("</body></html>");

       }	

    catch (Exception ex) {
	      	;
	}

}

}