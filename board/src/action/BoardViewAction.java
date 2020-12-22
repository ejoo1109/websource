package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardViewAction implements Action {
	private String path;
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//BoardHitUpdateAction 페이지에서 넘어오는 값 가져오기
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//서비스 요청 -> bno에 해당하는 정보 가져오기
		BoardService service = new BoardServiceImpl();
		BoardVO vo=service.getRow(bno);
		
		//결과에 따라 이동
		request.setAttribute("vo", vo); //select 시 request에 정보 담기
		return new ActionForward(path, false);
		//qna_board_view.jsp페이지 이동하여 EL로 데이터 조회하기 처리
	}

}
