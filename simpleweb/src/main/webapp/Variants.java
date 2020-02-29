package wm2.quiz;

public class Variants{

	private Integer qId;
	private Integer varId;
	private String varStat;

	public Integer getQid(){return qId;}
	public Integer getVarId(){return varId;}
	public String getVarStat(){return varStat;}

	public void setQid(Integer id){this.qId=id;}
	public void setVarId(Integer id){this.varId=id;}
	public void setVarStat(String stat){this.varStat=stat;}
}