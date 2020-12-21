package domain;

//VO : Value Object 개별값을 객체로 만듬
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

public class BookVO {
	private int code;
	private String title;
	private String writer;
	private int price;
	
}
