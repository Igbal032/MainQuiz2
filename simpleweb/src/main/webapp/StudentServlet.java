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

	try{
	    PrintWriter wrt = response.getWriter();
    	wrt.println("<html><head></head><body>");

    	if (userName.equals("")||password.equals("")) {
    
	   			 wrt.println("<h1>Please,fill all inputs</h1>");
		}
		else{
				Student newStudent = new Student();
				newStudent.setId(++ID);
	            newStudent.setUserName(userName);
	            newStudent.setPassword(password);
				newStudent.setCurrentQuestionId(1);
	            registeredStudent.add(newStudent);
				Iterator iterator = registeredStudent.iterator();
				while(iterator.hasNext()) {
				Student std = (Student)iterator.next();
    			if (std.getUserName().equals(userName)) {
    				request.getSession().setAttribute("newStudent",newStudent);
		            RequestDispatcher view = request.getRequestDispatcher("view.jsp");
		            view.forward(request,response);
    			}
				}	
				//not workink after last If candition
			}

		wrt.println("</body></html>");

       }	

    catch (Exception ex) {
	      	;
	}

}

}