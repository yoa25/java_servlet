package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		out.println("<h1>점심시간입니다</h1>");
		Calendar today = Calendar.getInstance();
		String ymd = String.format("%1$tF %1$tT", today);
		
		out.println("<p>현재시간 : " + ymd + "</p>");
		
		//구구단 출력
		ServletContext servletContainer = getServletContext();
		RequestDispatcher dispatcher = servletContainer.getRequestDispatcher("/gugudan");
		dispatcher.include(request, response);
		
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
