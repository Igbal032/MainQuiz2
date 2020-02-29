package wm2.quiz;

public class CheckedAnswerss{

	private String userName;
	private Integer questionId;
	private Integer selectedAnswer;
	private Integer correctAnswer;
	private boolean tf;
	
	public String getUserName(){return userName;}
	public Integer getQuestionId(){return questionId;}
	public Integer getSelectedAnswer(){return selectedAnswer;}
	public Integer getCorrectAnswer(){return correctAnswer;}
	public boolean getTF(){return tf;}

	public void setUserName(String s){this.userName=s;}
	public void setQuestionId(Integer s){this.questionId=s;}
	public void setSelectedAnswer(Integer s){this.selectedAnswer=s;}
	public void setCorrectAnswer(Integer s){this.correctAnswer=s;}
	public void setTF(int s){
		if (s==1) {
			this.tf=true;
		}
		else{
			this.tf=false;
		}

	}
}