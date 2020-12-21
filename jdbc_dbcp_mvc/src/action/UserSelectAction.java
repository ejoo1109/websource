package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserSelectAction implements Action {

	private String path;
	
	public UserSelectAction(String path) {
		super();
		this.path = path;
	}




	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		
		UserService service = new UserServiceImpl();
		UserVO user = service.getUser(no);
		
		request.setAttribute("vo",user);//select.jsp에서 보여줘야하니깐
		return new ActionForward(path, false);
	}

}
