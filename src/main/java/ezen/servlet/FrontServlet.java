package ezen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 브라우저의 요청을 처리하는 프론트 컨트롤러 역할의 서블릿
 * @author 김민영
 * @Date   2023. 3. 3.
 */
@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command == null) {
			command = "default";
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = null;
		
		switch (command) {
		case "writer" :  
			dispatcher = context.getRequestDispatcher("board/writer.html");
			dispatcher.forward(request, response);
		break; // 게시판 글쓰기 요청  
		
		case "join" : 
		dispatcher = context.getRequestDispatcher("board/EventEx3.html");
		dispatcher.forward(request, response);
		break; // 회원가입 요청
		
		default:
			dispatcher = context.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
