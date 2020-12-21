package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

/**
 * Servlet implementation class UserFrontController
 */
@WebServlet("*.do")
public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 처리
		request.setCharacterEncoding("utf-8");
		
		//요청 분류하기
		//http://localhost:8080/jdbc_dbcp_mvc/insert.do
		
		String requestURI = request.getRequestURI(); // /jdbc_dbcp_mvc/insert.do
		String contextPath = request.getContextPath(); // /jdbc_dbcp_mvc
		String cmd = requestURI.substring(contextPath.length());// /insert.do
		
		//요청에 맞는 Action 생성하기 => UserAction Factory
		UserActionFactory factory = UserActionFactory.getInstance(); //new actionfactory랑 같은 개념
		Action action = factory.action(cmd);
		
		//생성된 action 일 시키기
		ActionForward af= null;
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//이동 방식에 따라 페이지 이동하기
		if (af.isRedirect()) { //sendRedirect로 설정되었음 insert에서 리턴받아 list.do로 변경됨
			response.sendRedirect(af.getPath());
		}else { //forward
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
