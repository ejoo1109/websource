package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;
import util.FileUploadUtil;

public class BoardWriteAction implements Action {
	private String path;
	
	public BoardWriteAction(String path) {
		super();
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParameter()로 가져올수 없다. 업로드폼을 enctype을 multipart/form으로 정해놨기 때문
		//테이블 구조로 넘어와야해서 Map구조를 사용
		FileUploadUtil utils = new FileUploadUtil();
		Map<String, String> map = utils.uploadFile(request);
		
		//map에 들어있는 폼 요소들을 VO에 옮겨주기
		BoardVO board = new BoardVO();
		board.setName(map.get("name"));
		board.setTitle(map.get("title"));
		board.setContent(map.get("content"));
		board.setPassword(map.get("password"));
		//attach 값이 있다면 board에 세팅,첨부파일 attach가 없을 경우 null값이 넘어옴
		if(map.containsKey("attach")) 
			board.setAttach(map.get("attach"));
		
		//서비스 호출
		BoardService service = new BoardServiceImpl();
		boolean flag = service.insertArticle(board);
		
		if(!flag) {
			path = "view/qna_board_write.jsp";
		}else {
			path += "?page=1&criteria=&keyword=";
		}
		return new ActionForward(path,true);
	}

}
