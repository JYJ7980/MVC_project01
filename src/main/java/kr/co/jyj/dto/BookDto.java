package kr.co.jyj.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BookDto {
	private String b_name;
	private String b_author;
	private String b_publisher;
	private int b_isbn;

}
