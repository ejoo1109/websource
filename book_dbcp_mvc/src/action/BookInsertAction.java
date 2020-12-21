package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import service.BookService;
import service.BookServiceImple;

public class BookInsertAction implements Action {
	private String path;
	
	
	public BookInsertAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BookVO vo = new BookVO(); //서비스에서 일시킬 타입이 vo이기 때문에 객체생성후 셋팅
		vo.setCode(Integer.parseInt(request.getParameter("code")));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		
		BookService service = new BookServiceImple();
		boolean result = service.insertBook(vo);
		
		if(!result) {
			path = "index.jsp";
		}
		return new ActionForward(path,true);
	}
}
