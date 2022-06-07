package kgboostcamp_05_03_vo_dto_dao;

import java.util.Objects;

public class SubjectVO {
	private long subCode;
	private String subName;
	
	public SubjectVO(String subName) {
		this.subCode = -1;
		this.subName = subName;
	}
	
	public SubjectVO(long subCode, String subName) {
		this.subCode = subCode;
		this.subName = subName;
	}
	
	public long getSubCode() {return this.subCode;}
	public String getSubName() {return this.subName;}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectVO subVO = (SubjectVO) o;
        return Objects.equals(subCode, subVO.subCode) && 
        		Objects.equals(subName, subVO.subName);
    }
	@Override
	public int hashCode() {
		return Objects.hash(subCode, subName);
	}
	@Override
	public String toString() {
		return String.format("%2d %s", getSubCode(), getSubName());
	}
}
