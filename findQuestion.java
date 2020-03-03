package wm2.quiz;

import java.util.*;
import wm2.quiz.Question;
import wm2.quiz.CheckedAnswerss;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
public class findQuestion{

	ArrayList<Question> questionList;
	public static ArrayList<CheckedAnswerss> checkedAnswerList = new ArrayList<CheckedAnswerss>();
    boolean have=true;
	public findQuestion(){
	questionList = new ArrayList<Question>();

	Question newQuestion1 = new Question();
    newQuestion1.SetId(1);
    newQuestion1.setQstatement("20 % of 2 is equal to");
    newQuestion1.setVarId1(1);
    newQuestion1.setVarStat1("20");
    newQuestion1.setVarId2(2);
    newQuestion1.setVarStat2("4");
    newQuestion1.setVarId3(3);
    newQuestion1.setVarStat3("0.4");
    newQuestion1.setAnswerId(3);
    questionList.add(newQuestion1);
  
    Question newQuestion2 = new Question();
    newQuestion2.SetId(2);
    newQuestion2.setQstatement("The population of a country increased by an average of 2% per year from 2000 to 2003. If the population of this country was 2 000 000 on December 31, 2003, then the population of this country on January 1, 2000, to the nearest thousand would have been");
    newQuestion2.setVarId1(1);
    newQuestion2.setVarStat1("1 846 000");
    newQuestion2.setVarId2(2);
    newQuestion2.setVarStat2("1 852 000");
    newQuestion2.setVarId3(3);
    newQuestion2.setVarStat3("1 000 000");
    newQuestion2.setAnswerId(1);
    questionList.add(newQuestion2);
  
    Question newQuestion3 = new Question();
    newQuestion3.SetId(3);
    newQuestion3.setQstatement("If the graph of y = f(x) is transformed into the graph of 2y - 6 = - 4 f(x - 3), point (a , b) on the graph of y = f(x) becomes point (A , B) on the graph of 2y - 6 = - 4 f(x - 3) where A and B are given by");
    newQuestion3.setVarId1(1);
    newQuestion3.setVarStat1(" A = a - 3, B = b");
    newQuestion3.setVarId2(2);
    newQuestion3.setVarStat2("A = a + 3, B = -2b +3");
    newQuestion3.setVarId3(3);
    newQuestion3.setVarStat3(" A = a + 3, B = -2b");
    newQuestion3.setAnswerId(2);
    questionList.add(newQuestion3);   
     
  
    Question newQuestion4 = new Question();
    newQuestion4.SetId(4);
    newQuestion4.setQstatement("The graphs of the two linear equations a x + b y = c and b x - a y = c, where a, b and c are all not equal to zero,");
    newQuestion4.setVarId1(1);
    newQuestion4.setVarStat1("are parallel");
    newQuestion4.setVarId2(2);
    newQuestion4.setVarStat2("intersect at one point");
    newQuestion4.setVarId3(3);
    newQuestion4.setVarStat3("perpendicular");
    newQuestion4.setAnswerId(3);
    questionList.add(newQuestion4);   
  
    Question newQuestion5 = new Question();
    newQuestion5.SetId(5);
    newQuestion5.setQstatement("For x greater than or equal to zero and less than or equal to 2 pi, sin x and cos x are both decreasing on the intervals");
    newQuestion5.setVarId1(1);
    newQuestion5.setVarStat1("(0 , pi/2)");
    newQuestion5.setVarId2(2);
    newQuestion5.setVarStat2("(pi/2 , pi)");
    newQuestion5.setVarId3(3);
    newQuestion5.setVarStat3("(pi , 3 pi / 2)");
    newQuestion5.setAnswerId(2);
    questionList.add(newQuestion5);   
  
    Question newQuestion6 = new Question();
    newQuestion6.SetId(6);
    newQuestion6.setQstatement("A school committee consists of 2 teachers and 4 students. The number of different committees that can be formed from 5 teachers and 10 students is");
    newQuestion6.setVarId1(1);
    newQuestion6.setVarStat1("10");
    newQuestion6.setVarId2(2);
    newQuestion6.setVarStat2("15");
    newQuestion6.setVarId3(3);
    newQuestion6.setVarStat3("2100");
    newQuestion6.setAnswerId(3);
    questionList.add(newQuestion6);   
  
    Question newQuestion7 = new Question();
    newQuestion7.SetId(7);
    newQuestion7.setQstatement("Five different books (A, B, C, D and E) are to be arranged on a shelf. Books C and D are to be arranged first and second starting from the right of the shelf. The number of different orders in which books A, B and E may be arranged is");
    newQuestion7.setVarId1(1);
    newQuestion7.setVarStat1("5!");
    newQuestion7.setVarId2(2);
    newQuestion7.setVarStat2("3!");
    newQuestion7.setVarId3(3);
    newQuestion7.setVarStat3("2!");
    newQuestion7.setAnswerId(2);
    questionList.add(newQuestion7);   
  
    Question newQuestion8 = new Question();
    newQuestion8.SetId(8);
    newQuestion8.setQstatement("The mean of a data set is equal to 10 and its standard deviation is equal to 1. If we add 5 to each data value, then the mean and standard deviation become");
    newQuestion8.setVarId1(1);
    newQuestion8.setVarStat1("mean = 15 , standard deviation = 1");
    newQuestion8.setVarId2(2);
    newQuestion8.setVarStat2("mean = 15 , standard deviation = 6");
    newQuestion8.setVarId3(3);
    newQuestion8.setVarStat3("mean = 10 , standard deviation = 6");
    newQuestion8.setAnswerId(1);
    questionList.add(newQuestion8);   
  
    Question newQuestion9 = new Question();
    newQuestion9.SetId(9);
    newQuestion9.setQstatement("If f(x) is an odd function, then | f(x) | is");
    newQuestion9.setVarId1(1);
    newQuestion9.setVarStat1("an odd function");
    newQuestion9.setVarId2(2);
    newQuestion9.setVarStat2("an even function");
    newQuestion9.setVarId3(3);
    newQuestion9.setVarStat3("neither odd nor even");
    newQuestion9.setAnswerId(2);
    questionList.add(newQuestion9);    
  
    Question newQuestion10 = new Question();
    newQuestion10.SetId(10);
    newQuestion10.setQstatement("The period of | sin (3x) | is");
    newQuestion10.setVarId1(1);
    newQuestion10.setVarStat1("pi/3");
    newQuestion10.setVarId2(2);
    newQuestion10.setVarStat2("2 pi");
    newQuestion10.setVarId3(3);
    newQuestion10.setVarStat3("2 pi / 3");
    newQuestion10.setAnswerId(1);
    questionList.add(newQuestion10); 
	}
  
	  
	public Question findQuestionWithId(Integer qId){

		// int qID = Integer.parseInt(qId);
		Question returnedQuestion = new Question();
		Iterator iterator = questionList.iterator();
		while(iterator.hasNext()) {
			Question std = (Question)iterator.next();
    		if (std.getId().equals(qId)) {

    			returnedQuestion = std;
    		}

		}
		return returnedQuestion;
	}

    public CheckedAnswerss checkQuestion(Integer questionId, String userName, String answerId){
        Iterator iterator = questionList.iterator();
        Question keepQuestion = new  Question();   
        Iterator iteratorCheckQuestionList = checkedAnswerList.iterator();

        CheckedAnswerss newAnswer = new CheckedAnswerss();
        while(iteratorCheckQuestionList.hasNext()) {
            CheckedAnswerss std = (CheckedAnswerss)iteratorCheckQuestionList.next();
            if (std.getUserName().equals(userName)&&std.getQuestionId().equals(questionId)){
                Integer changeInt = Integer.parseInt(answerId);
                std.setSelectedAnswer(changeInt);
            while(iterator.hasNext()) {
               Question stdQ = (Question)iterator.next();
               if (stdQ.getId().equals(questionId)) {
 
                      keepQuestion = stdQ;
                }
            }  

               if (keepQuestion.getAnswerId()==Integer.parseInt(answerId)) {
                   std.setTF(1);
               }
               else{
                   std.setTF(0);
               }  
                return std;
            }
            
        }

        while(iterator.hasNext()) {
               Question std = (Question)iterator.next();
               if (std.getId().equals(questionId)) {
 
                      keepQuestion = std;
                  }
              }      
        newAnswer.setUserName(userName);
        newAnswer.setQuestionId(questionId);
        newAnswer.setSelectedAnswer(Integer.parseInt(answerId));
        newAnswer.setCorrectAnswer(keepQuestion.getAnswerId());
        if (keepQuestion.getAnswerId()==Integer.parseInt(answerId)) {
            newAnswer.setTF(1);
        }
        else{
            newAnswer.setTF(0);
        }
             checkedAnswerList.add(newAnswer);
        
 
        return newAnswer;
    }

    public static Integer getSelectedId(String userName,Integer questionId){
        Iterator iterator = checkedAnswerList.iterator();
        CheckedAnswerss  keepAnswer = new CheckedAnswerss();
        while(iterator.hasNext()) {
            CheckedAnswerss std = (CheckedAnswerss)iterator.next();
            if (std.getQuestionId().equals(questionId)&&std.getUserName().equals(userName)) {
                keepAnswer = std;
            }
        }
        return keepAnswer.getSelectedAnswer();

    }

     public static boolean checkTime(Date endDate){
          boolean checkTime=true;
          Date currentDate = Calendar.getInstance().getTime();
          if (currentDate.compareTo(endDate)>0){
              checkTime=true;
          }
          else{
              checkTime=false;
          }
          return checkTime;
     }


}
    
