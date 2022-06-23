package kgitbank.boostcamp.jy.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookVO {
	private long id;
	private String img;
	private long isbn;
	private String title;
	private String author;
	private String publisher;
	private long price;
	private String content;
}
