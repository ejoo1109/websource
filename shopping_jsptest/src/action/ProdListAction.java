package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
import lombok.AllArgsConstructor;
import service.ProductService;
import service.ProductServiceImpl;


@AllArgsConstructor
public class ProdListAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.getProdList();
		
		request.setAttribute("list", list);
		return new ActionForward(path,false);
	}

}
