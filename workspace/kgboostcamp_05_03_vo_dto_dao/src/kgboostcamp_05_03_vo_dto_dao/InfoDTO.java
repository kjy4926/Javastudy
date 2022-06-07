package kgboostcamp_05_03_vo_dto_dao;

import java.time.LocalDate;

public class InfoDTO {
	private long number;
	private String name;
	private LocalDate birth;
	private String bloodType;
	
	public InfoDTO(InfoVO ivo) {
		this.number = ivo.getNumber();
		this.name = ivo.getName();
		this.birth = ivo.getBirth();
		this.bloodType = ivo.getBloodType();
	}
	
	public long getNumber() {return this.number;}
	public String getName() {return this.name;}
	public LocalDate getBirth() {return this.birth;}
	public String getBloodType() {return this.bloodType;}
	
	public void setNumber(long number) {this.number = number;} 
	public void setName(String name) {this.name = name;} 
	public void setBirth(LocalDate birth) {this.birth = birth;} 
	public void setBloodType(String bloodType) {this.bloodType = bloodType;} 
}