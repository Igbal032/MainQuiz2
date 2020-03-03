package wm2.quiz;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;

public class StudentServlet extends HttpServlet{
	public  void init(){

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
	Integer ID=0;
	String userName = (String)request.getParameter("userName");
	String password = (String)request.getParameter("password");
	boolean checkStudent=false;
	// ArrayList<Student> registeredStudent = new ArrayList<Student>();
	boolean exist=false;
	
	try{
	    PrintWriter wrt = response.getWriter();
    	wrt.println("<html><head></head><body>");

    	if (userName.equals("")||password.equals("")) {
    			// System.out.println(studentHashMap.get(userName).getPassword()+"  sads");
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
    				System.out.println("HashMapm condition");
    				//Add static hashMap
    				if (rst.getUserPassword().equals(password)){
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
	        		// registeredStudent.add(newStudent);
	        		// studentHashMap.put(userName,newStudent);
				    StartAndEndDate date = new StartAndEndDate();
   					Calendar calendar = Calendar.getInstance();
				    date.setStartDate(calendar.getTime());
				    calendar.add(Calendar.MINUTE, 5);
				    date.setEndDate(calendar.getTime());
    				HttpSession session=request.getSession();
    				request.getSession().setAttribute("newStudent",newStudent);
		    		RequestDispatcher view = request.getRequestDispatcher("view.jsp");
		    		view.forward(request,response);

    		}
			}
			else{
				System.out.println("Result doesnt exist");
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
	        	// registeredStudent.add(newStudent);
        		// studentHashMap.put(userName,newStudent);
    			HttpSession session=request.getSession();
    			request.getSession().setAttribute("newStudent",newStudent);
		    	RequestDispatcher view = request.getRequestDispatcher("view.jsp");
		    	view.forward(request,response);

			}
		}
		wrt.println("</body></html>");

       }	

    catch (Exception ex) {
	      	;
	}

}

}