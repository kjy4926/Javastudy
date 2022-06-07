package kgboostcamp_05_03_vo_dto_dao;

import java.time.LocalDate;
import java.util.Objects;

public class InfoVO {
	private long number;
	private String name;
	private LocalDate birth;
	private String bloodType;
	
	public InfoVO(String name, LocalDate birth, String bloodType) {
		this.number = -1;
		this.name = name;
		this.birth = birth;
		this.bloodType = bloodType;
	}
	public InfoVO(long number, String name, LocalDate birth, String bloodType) {
		this.number = number;
		this.name = name;
		this.birth = birth;
		this.bloodType = bloodType;
	}
	
	public long getNumber() {return this.number;}
	public String getName() {return this.name;}
	public LocalDate getBirth() {return this.birth;}
	public String getBloodType() {return this.bloodType;}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoVO infoVO = (InfoVO) o;
        return Objects.equals(number, infoVO.number) && 
        		Objects.equals(name, infoVO.name) && 
        		Objects.equals(birth, infoVO.birth) && 
        		Objects.equals(bloodType, infoVO.bloodType);
    }
	@Override
	public int hashCode() {
		return Objects.hash(number, name, birth, bloodType);
	}
	@Override
	public String toString() {
		return String.format("%2d %s %s %s", 
				getNumber(), getName(), getBirth(), getBloodType());
	}
}