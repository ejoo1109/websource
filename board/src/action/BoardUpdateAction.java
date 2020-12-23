package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
import util.FileUploadUtil;

@AllArgsConstructor
public class BoardUpdateAction implements Action {
	private String path; //qView.do
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParameter()로 가져올수 없다. 업로드폼을 enctype을 multipart/form으로 정해놨기 때문
		//테이블 구조로 넘어와야해서 Map구조를 사용
		//bno,password가 일치하는경우 데이터를 수정(title, content) or (title,content,attach)
				FileUploadUtil util = new FileUploadUtil();
				Map<String, String> map = util.uploadFile(request);
		
				//map에 들어있는 폼 요소들을 VO에 옮겨주기
				BoardVO vo = new BoardVO();
				vo.setBno(Integer.parseInt(map.get("bno")));
				vo.setTitle(map.get("title"));
				vo.setContent(map.get("content"));
				vo.setPassword(map.get("password"));
				//attach 값이 있다면 board에 세팅,첨부파일 attach가 없을 경우 null값이 넘어옴
				if(map.containsKey("attach")) {
					vo.setAttach(map.get("attach"));
				}
				//서비스 호출
				BoardService service = new BoardServiceImpl();
				boolean flag = service.updateArticle(vo);
				
				//수정 성공시 수정된 내용 보여주기(qView.do)
				if(!flag) {//수정실패 qModify.do도 bno가 필요하기 때문에 bno를 보내줘야한다.
					path = "qModify.do?bno="+map.get("bno");
				}else {//수정성공시 qView.do로 이동할거라서 bno를 보내줘야한다.
					path += "?bno="+map.get("bno");
				}
				return new ActionForward(path,true);
	}

}
