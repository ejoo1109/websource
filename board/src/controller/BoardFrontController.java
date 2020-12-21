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


@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//요청에 대한 선별
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		//요청에 따라 Action 생성하기
		BoardActionFactory factory = BoardActionFactory.getInstance();
		Action action = factory.action(cmd);
		
		//생성된 Action에 일 시키기
		ActionForward af = null;
		
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//리턴받은 결과에 따라 지정된 방식으로 이동하기
		if(af.isRedirect()) {
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
