package member;

import lombok.Data;


@Data
//data : get/set, equals, default constructor, hashCode, toString
public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;

}
