package wm2.quiz;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.*;
public class StartAndEndDate{

	private static Date startDate;
	private static Date endDate;

	public Date getStartDate(){return startDate;}
	public Date getEndDate(){return endDate;}

	public void setStartDate(Date d){
		// Date date = d;  
		// DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");  
		// String strSdate = dateFormat.format(date);  
		this.startDate=d;
	}
	public void setEndDate(Date d){
		// Date date = d;  
		// DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");  
		// String strEdate = dateFormat.format(date);  
		this.endDate=d;
	}
}