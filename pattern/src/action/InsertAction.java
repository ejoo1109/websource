package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

public class InsertAction implements Action{
	//생성자의 목적 : 객체생성시 필요->new할때 무조건 호출됨 
	//클래스 이름과 동일해야하며 public InsertAction(){} 리턴타입은 없고, 앞에 접근제한자만 온다.
	//생성자는 매개변수가 다르면 한개 이상 생성될수 있다.(오버로딩)
	//public InsertAction(){} -default 생성자
	//public InsertAction(String name){} 
	//public InsertAction(Stirng name,int bno){}
	//클래스안에 생성자가 하나도 없다면 컴파일러가 자동으로 default 생성해줌
	
	private String path;
	//FrontController에서 생성자가 없기때문에 필드와 생성자 만듬
	public InsertAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//~Pro.jsp에서 했던 작업
		//request.getParameter() 작업을 하려고 컨드롤러로 리퀘스트랑, 리스폰스 받아옴
		String name=request.getParameter("name");
		System.out.println("insert_action name :"+name);
		
		//db작업 -> service 한테 넘김
		MemberService service = new MemberServiceImpl();
		//멤버서비스는 인터페이스로 만들었기 때문에 객체생성할수 없다.
		//객체생성할수 있는 인터페이스를 상속받은 멤버서비스 임플로 작업한다
		service.insertMember(name);
		
		//session에 담을거면 sendredirect, request로 가지고 온거는-forward 
		//ture면 sendredirect, false면 forward
		return new ActionForward(path,true);
	}
	
}
