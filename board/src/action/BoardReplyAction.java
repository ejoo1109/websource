package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardReplyAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// reply.jsp에서 넘긴 값 가져오기(name,title,content,password,hidden 값3개)
		BoardVO vo= new BoardVO();
		//댓글값들
		vo.setName(request.getParameter("name"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setPassword(request.getParameter("password"));
		//원본글 값들
		vo.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		vo.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		vo.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
		
		//서비스 요청
		BoardService service = new BoardServiceImpl();
		boolean result = service.insertReply(vo);
		//결과에 따라 이동
		if(!result) {//실패시 이동
			path = "qView.do?bno="+request.getParameter("bno");
		}
		return new ActionForward(path,true);
	}

}
