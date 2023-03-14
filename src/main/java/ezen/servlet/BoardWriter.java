package ezen.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/writer")
public class BoardWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		System.out.println(writer);
		System.out.println(title);
		//db 테이블 인서트 가정
		
		System.out.println("게시판 글쓰기 서블릿 요청");
		
		// 게시판 목록을 보여주는 서블릿으로 자동 요청처리 (디스패치)
//		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);//302
//		response.setHeader("Location", "/board/list");
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
