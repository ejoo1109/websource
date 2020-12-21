package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberModifyAction implements Action {
	private String path;
	
	
	public MemberModifyAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");
		
		MemberService service = new MemberServiceImpl();
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("login");
		
		//현재 비밀번호가 일치확인하는지 확인->islogin(userid,password)
		MemberVO info = service.login(vo.getUserid(), current_password);
		
		//일치한다면 변경/세션해제
		if(info!=null) {
		MemberService service1 = new MemberServiceImpl();
		boolean result = service1.updateMember(vo.getUserid(), new_password);
		if(result) {
			session.invalidate();
		}
		}else {
			path="view/modifyForm.jsp";
		}
		return new ActionForward(path, true);
	}

}
