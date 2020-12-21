package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.DeleteAciton;
import action.InsertAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")//select.do, insert.do, modify.do~끝에가 .do로 끝나는 페이지
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:8080/pattern/update.do -> updateAcion에서 처리
		//http://localhost:8080/pattern/select.do->selectAcion에서 처리
		//http://localhost:8080/pattern/delete.do->deleteAcion에서 처리
		//http://localhost:8080/pattern/insert.do->insertAcion에서 처리
		//어떤.do가 왔는지 분석하는곳->분석해서 cmd 가지고 작업
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI(); // /pattern/update.do
		String contextPath = request.getContextPath(); // /pattern
		String cmd = requestURI.substring(contextPath.length());// /update.do
		
		ActionFactory factory = ActionFactory.getInstance(); //new actionfactory랑 같은 개념
		Action action = factory.action(cmd);
		//deleteaction과 insertaction의 부모가 action인터페이스므로 코드간소화
	
		
		ActionForward af=null;
		try {
			af=action.execute(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if (af.isRedirect()) { //true=> sendRedirect방식
			response.sendRedirect(af.getPath());
		}else {//false => forward방식
			//서블릿에서의 forward 방식
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
			
		}
	}
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("requestURI"+requestURI+"<br>");
//		out.print("contextPath"+contextPath+"<br>");
//		out.print("cmd"+cmd+"<br>");
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
