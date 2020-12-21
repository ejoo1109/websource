package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberJoinAction implements Action {
	private String path;
	
	
	public MemberJoinAction(String path) {
		super();
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		//개별 값들을 객체화 하기
		MemberVO member = new MemberVO();
		member.setUserid(userid);
		member.setPassword(password);
		member.setName(name);
		member.setGender(gender);
		member.setEmail(email);
		
		MemberService service = new MemberServiceImpl();
		boolean result = service.registerMember(member);
		
		if(!result) {
			path = "view/joinForm.jsp";
		}
		return new ActionForward(path, true);
	}

}
