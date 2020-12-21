package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserModifyAciton implements Action {

	private String path;
	
	
	public UserModifyAciton(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");

		UserService service = new UserServiceImpl();
		boolean flag = service.updateUser(no, addr, mobile);
		//사용자에게 select(조회)한 페이지를 보여줄 경우 경우 setAttribute로 사용
		
		if(!flag) { //수정페이지
			path = "update.do"; //forward된 jsp 페이지는 바로 갈수가 없다. update.jsp는 처음에 정보를 가져오는것부터 되기때문에 nullpoint로 오류남
		}
		return new ActionForward(path,true);
	}

}
