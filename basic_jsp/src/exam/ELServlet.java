package exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.do")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//세션 방식
		HttpSession session = request.getSession();
		session.setAttribute("age", 25);
		
		//list 방식
		List<LoginDTO> list = new ArrayList<LoginDTO>();
		list.add(new LoginDTO("kang123","kang123@"));
		list.add(new LoginDTO("kang124","kang124@"));
		list.add(new LoginDTO("kang125","kang125@"));
		list.add(new LoginDTO("kang126","kang126@"));
		request.setAttribute("list", list);
		
		//객체생성 방식
		LoginDTO login = new LoginDTO("hong123","hong1234@");
		request.setAttribute("login", login);
		
		//포워드
		request.setAttribute("name", request.getParameter("name"));
		RequestDispatcher rd = request.getRequestDispatcher("el/test2.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
