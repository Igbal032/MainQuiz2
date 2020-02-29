package wm2.quiz;

public class  Student{


	private Integer Id;
	private String UserName;
	private String Password;
	private Integer currentQuestionId;

	public Integer getId(){return Id;}
	public String getUserName(){return UserName;}
	public String getPassword(){return Password;}
	public Integer getCurrentQuestionId(){return currentQuestionId;}

	public void setId(Integer id){this.Id=id;}
	public void setUserName(String Name){this.UserName=Name;}
	public void setPassword(String psw){this.Password=psw;}
	public void setCurrentQuestionId(int crtQuId){this.currentQuestionId=crtQuId;}

}