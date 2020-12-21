package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserInsertAction implements Action {
	private String path;
	
	public UserInsertAction(String path) {
		this.path=path; //insert가 성공하면 list.jsp로 가야하는데 
		//list.jsp는 list.do가 포워드한 페이지이기 때문에 list.do로 경로를 잡아준다
	}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParamester()
		//add.jsp에서 사용자 입력값 가져오는 개념과 같다.
		String username = request.getParameter("username");
		String birthyear = request.getParameter("birthyear");
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		//service에게 일 시키기
		UserService service = new UserServiceImpl();
		boolean insertFlag = service.insertUser(username, birthyear, addr, mobile);	
		
		if(!insertFlag) { //작업 실패시
			path = "add.jsp";
		}
		//작업 결과에 따라 페이지 이동 방식 결정-sendRedirect(true)
		return new ActionForward(path, true); //작업 성공시 list.do페이지가 보여야함
	}

}
