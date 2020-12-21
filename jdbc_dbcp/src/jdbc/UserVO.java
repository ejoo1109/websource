package jdbc; //UserDAO에서 전체조회를 하고 반환하는 값이 여러개일때 클래스로 담아서 한꺼번에 보냄

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
public class UserVO {
	private int no;
	private String username;
	private int birthyear;
	private String addr;
	private String mobile;
	
	//생성자, getter, setter, toString 생성하기 -> 롬복 
	
}
