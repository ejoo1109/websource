package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserListAction implements Action {

	private String path; 

	public UserListAction(String path) {
		super();
		this.path = path;//list.jsp
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParamexter->x
		//서비스한테 일 시키기
		UserService service = new UserServiceImpl();
		List<UserVO> list = service.getUserList();

		//이동방식 결정한 후 ActionForward 객체 생성-sendRedirect(true), forward(false)
		request.setAttribute("list",list);
		return new ActionForward(path, false);
	}

}
