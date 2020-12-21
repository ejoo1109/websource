package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import service.BookService;
import service.BookServiceImple;

public class BookSearchAction implements Action {
	private String path;
	
	
	public BookSearchAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		
		BookService service = new BookServiceImple();
		List<BookVO> list = service.getRows(criteria, keyword);
		
		request.setAttribute("list", list);
		
		return new ActionForward(path,false);
}
	}

