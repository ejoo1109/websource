package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberLoginAction implements Action {
	private String path;
	
	
	public MemberLoginAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("current_password");
		
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.login(userid, password);
		
		HttpSession session = request.getSession();
		session.setAttribute("login",member); //클래스에선 세션을 부를수 없기 때문에 따로 불러냄
	
		return new ActionForward(path, true); //세션은 redirect 로 보낸다.
	}

}
