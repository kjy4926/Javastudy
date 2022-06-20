package kr.jy.jyweb.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Member {
	@Id
	private String id;
	private String pwd;
	private String email;
	private Timestamp signupDate;
}
