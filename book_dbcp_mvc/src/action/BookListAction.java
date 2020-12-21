package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import service.BookService;
import service.BookServiceImple;

public class BookListAction implements Action {
	private String path;
	
	
	public BookListAction(String path) {
		super(); //http request, http response
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//서비스한테 일 시킴
		BookService service = new BookServiceImple();
		List<BookVO> list = service.getList();
		
		request.setAttribute("list", list);
		
		return new ActionForward(path,false);//forward(false)
}
	}

