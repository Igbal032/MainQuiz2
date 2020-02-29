package wm2.quiz;
import java.util.*;
public class Result{


	private String  UserName;
	private String  password;
	private Integer True;
	private Integer False;
	private Integer TotalScore;
	private Date endDate;

	public String  getUserName(){return UserName;}
	public String  getUserPassword(){return password;}
	public Integer getTrue(){return True;}
	public Integer getFalse(){return False;}
	public Integer getTotalScore(){return TotalScore;}
	public Date getEndDate(){return endDate;}

	public void setUserName(String s){this.UserName=s;}
	public void setUserPassword(String s){this.password=s;}
	public void setTrue(Integer s){this.True=s;}
	public void setFalse(Integer s){this.False=s;}
	public void setTotalScore(Integer s){this.TotalScore=s;}
	public void setEndDate(Date s){this.endDate=s;}
}