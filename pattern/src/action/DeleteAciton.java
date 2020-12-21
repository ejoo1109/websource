package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

public class DeleteAciton implements Action{
	
	private String path;
	
	public DeleteAciton(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParameter()
		String name = request.getParameter("name");
		System.out.println("delete action :"+name);
		
		//db작업을 위해 서비스로 넘김
		MemberService service = new MemberServiceImpl();
		service.deleteMember(name); //true or false로 돌아온다.
		
//어디로 갈것인지?(~~.jsp or ~~.do) / 어떤 방식으로 갈것인지 (forward or sendRedirect) 리턴방법정한다.
//자바는 리턴이 2개가 될수 없기 때문에 클래스로 따로 만들어서 사용
//ActionForward
//ActionForwad af = new ActionForward();
//return af
		
		return new ActionForward(path,true);
	}
}
