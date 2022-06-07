package kgboostcamp_05_03_vo_dto_dao;

public class SubjectDTO {
	private long subCode;
	private String subName;
	
	SubjectDTO(SubjectVO svo){
		this.subCode = svo.getSubCode();
		this.subName = svo.getSubName();
	}
	
	public long getSubCode() {return this.subCode;}
	public String getSubName() {return this.subName;}
	
	public void setSubCode(long subCode) {this.subCode = subCode;}
	public void setSubName(String subName) {this.subName = subName;}
}
