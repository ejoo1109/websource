package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import service.BookService;
import service.BookServiceImple;

public class BookModifyAction implements Action {
	private String path;
	
	
	public BookModifyAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookVO vo = new BookVO();
		
		vo.setCode(Integer.parseInt(request.getParameter("code")));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
				
		BookService service = new BookServiceImple();
		boolean flag = service.updateBook(vo);
		
		if(!flag) {
			path="index";
		}
		return new ActionForward(path,true);
}
	}

