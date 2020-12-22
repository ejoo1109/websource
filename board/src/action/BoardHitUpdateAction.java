package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
//조회수 업데이트 -새로고침 할경우 조회수 값이 누적되지 않도록 분리
@AllArgsConstructor
public class BoardHitUpdateAction implements Action {
	private String path; //qView.do
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		//서비스 요청 -> 조회수 올리기
		BoardService service = new BoardServiceImpl();
		service.hitUpdate(bno);
		
		path +="?bno="+bno; //path설정 한번 더하기 qView.do?bno와 같다.
		
		return new ActionForward(path,true);
	}

}
