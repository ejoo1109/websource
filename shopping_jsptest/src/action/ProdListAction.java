package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import domain.ProductVO;
import lombok.AllArgsConstructor;
import service.ProductService;
import service.ProductServiceImpl;


public class ProdListAction implements Action {
	private String path;
	
	public ProdListAction(String path) {
		super();
		this.path = path;//list.jsp
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.getProdList();
		
		request.setAttribute("list", list);
		
		return new ActionForward(path,false);
	}

}
