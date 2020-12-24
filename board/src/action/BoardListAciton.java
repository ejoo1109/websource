package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import domain.SearchVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;


@AllArgsConstructor
public class BoardListAciton implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//페이지 나누기 추가
		int page = 1; //페이지단위
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		int amount = 10; //한 페이지당 보여주 게시물 개수
		
		//검색기능 추가 + 페이지 나누기 값
		SearchVO searchVO = new SearchVO();
		searchVO.setCriteria(request.getParameter("criteria"));
		searchVO.setKeyword(request.getParameter("keyword"));
		searchVO.setPage(page);
		searchVO.setAmount(amount);
		
		
		//서비스 요청
		BoardService service = new BoardServiceImpl();
		List<BoardVO> list = service.getList(searchVO);
		
		//요청 후 받은 결과 담기
		request.setAttribute("list", list); //list가져온거 담기
		//search-검색어,검색기준
		request.setAttribute("search", searchVO);
		
		//이동방식 결정
		return new ActionForward(path,false);//forward(false)
	}

}
