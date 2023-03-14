package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//패스형식
@WebServlet("/gugudan")
//확장자 형식
//@WebServlet("/gugudan.do")
public class gugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestMethod = request.getMethod();
		String requestUri = request.getRequestURI();
		String protocol = request.getProtocol();
		System.out.println("브라우저 요청방식 : " + requestMethod);
		System.out.println("브라우저 요청URI : " + requestUri);
		System.out.println("브라우저 요청프로토콜 : " + protocol);
		
		
		// JDBC 이용해 데이터 베이스 연결 및 수신 (나중에)
		String title = "구구구구";
		
		// TODO Auto-generated method stub
//		브라우저에게 서비스 하고자 하는 데이터 출력
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 동적 컨텐츠 출력
		out.println("<html>");

		out.println("<head>");
		out.println("<title>서블릿 프로그래밍</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("게시판 타이틀 : " + title);
		
		out.println("<table border='1' style='color:blue'>");
		
		for (int i = 2; i < 9; i++) {
			out.println("<tr>");
			for (int j = 1; j < 9; j++) {				
				out.println("<td> "+i+" * "+j+" = "+ (i*j) + "</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
