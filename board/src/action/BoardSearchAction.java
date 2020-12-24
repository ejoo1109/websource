//package action;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import domain.BoardVO;
//import domain.SearchVO;
//import lombok.AllArgsConstructor;
//import service.BoardService;
//import service.BoardServiceImpl;
//
//@AllArgsConstructor
//public class BoardSearchAction implements Action {
//	private String path;
//	
//	
//	@Override
//	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		//검색기능 추가
//		SearchVO searchVO = new SearchVO();
//		searchVO.setCriteria(request.getParameter("criteria"));
//		searchVO.setKeyword(request.getParameter("keyword"));
//		
//		//서비스 요청
//		BoardService service = new BoardServiceImpl();
//		List<BoardVO> search=service.getList(searchVO);
//		
//		//search-검색어,검색기준
//		request.setAttribute("search", searchVO);
//		//list-검색결과
//		request.setAttribute("list", search);
//		
//		return new ActionForward(path, false);
//	}
//
//}
