package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Database 게시판 테이블로부터 게시판 목록 조회해서 브라우저에 전송 서블릿
 */
@WebServlet(name = "/board/list", urlPatterns = { "//board/list" })
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답메시지에 setContentType 헤더에 전송하고자 하는 컨텐츠 종류 설정
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//DB에서 조회된 데이터라 가정
		List<String> boardList = new ArrayList<>();
		boardList.add("오늘 회식");
		boardList.add("서블릿 어려워요");
		boardList.add("다음엔 JSP");
		
		//out을 통해 브라우저에 출력
		
		out.println("<html>");

		out.println("<head>");
		out.println("<title>게시판 리스트</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>게시판 목록</h1>");
		
		out.println("<table border='1' style='color:blue'>");
		out.println("<tr>");
		out.println("<th>번호</th>");
		out.println("<th>게시판 제목</th>");
		out.println("</tr>");
		
		int number = 0;
		for (String title : boardList) {
			number++;
			out.println("<tr>");
			out.println("<td>"+number+"</td>");
			out.println("<td>"+title+"</td>");
			out.println("</tr>");
		}
		
		
		out.println("</tr>");
		
		out.println("</table>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
