package kr.jy.jyweb.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor 
@SequenceGenerator(
		name = "TESTMEMBER_SEQ_GENERATOR",
		sequenceName = "TESTMEMBER_SEQ",
		initialValue = 1,
		allocationSize = 1
)
public class TestMember {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TESTMEMBER_SEQ_GENERATOR")
	private Long id;
	private String name;
}
