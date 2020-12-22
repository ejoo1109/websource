package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;


@AllArgsConstructor
public class BoardListAciton implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = new BoardServiceImpl();
		List<BoardVO> list = service.getList();
		
		request.setAttribute("list", list); //list가져온거 담기
		
		return new ActionForward(path,false);//forward(false)
	}

}
