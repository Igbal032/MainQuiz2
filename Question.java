package wm2.quiz;
import java.util.*;
public class Question{


	private Integer qId;
	private String qStatement;
	private Integer variantId1;
	private String variantStat1;
	private Integer variantId2;
	private String variantStat2;
	private Integer variantId3;
	private String variantStat3;
	private Integer answerId;

	public Integer getId(){return qId;}
	public String getQstatement(){return qStatement;}
	public Integer getAnswerId(){return answerId;}
	public Integer getVarId1(){return variantId1;}
	public String getVarStat1(){return variantStat1;}
	public Integer getVarId2(){return variantId2;}
	public String getVarStat2(){return variantStat2;}
	public Integer getVarId3(){return variantId3;}
	public String getVarStat3(){return variantStat3;}

	public void SetId(int Id){
		this.qId=Id;
	}
	public void setQstatement(String sQues){
		this.qStatement=sQues;
	}

	public void setAnswerId(int ansId){
		this.answerId=ansId;
	}

	public void setVarId1(Integer id){
		this.variantId1=id;
	}

	public void setVarStat1(String varStat){
		this.variantStat1=varStat;
	}

	public void setVarId2(Integer id){
		this.variantId2=id;
	}

	public void setVarStat2(String varStat){
		this.variantStat2=varStat;
	}

	public void setVarId3(Integer id){
		this.variantId3=id;
	}

	public void setVarStat3(String varStat){
		this.variantStat3=varStat;
	}

}