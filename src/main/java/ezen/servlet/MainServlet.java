package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 홈페이지 서블릿
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		//사용자 로그인 정보가 저장되어 있는 HttpSession 접근
//		HttpSession session = request.getSession();
//		String loginId = (String)session.getAttribute("loginId");
		
		String loginId = null;
		
		// 쿠키 정보 읽기
		Cookie[] cookies = request.getCookies();
		// 쿠키 존재 시
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if(cookieName.equalsIgnoreCase("loginId")) {
					loginId = cookie.getValue();
				}
			}
		}
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\" />");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		out.println("<title>float를 이용한 홈페이지 레이아웃</title>");
		out.println("<link rel=\"stylesheet\" href=\"./css/main.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id=\"container\">");
		out.println("<header>");
		out.println("<h2>머리글부분</h2>");
		
		//로그인 하지 않은 경우
		if(loginId==null) {			
			out.println("<form action=\"login\" style=\"text-align: right;\" method=\"post\">");
			out.println("<label>아이디 : <input type=\"text\" name=\"id\"></label> <label>비밀번호</label>");
			out.println(": <input type=\"password\" name=\"password\">");
			out.println("<label>아이디 저장 : <input type=\"checkbox\" name=\"saveid\" value=\"save\"></label>");
			out.println("<input type=\"submit\" value=\"로그인\">");
			out.println("</form>");
		}else {
			out.println("<p style=\"text-align: right;\">"+loginId+"님 로그인중. .</p>");
			out.println("<button style='display:inline' onclick='location.href=\"logout\"'>로그아웃</button>");
		}
		
		out.println("</header>");
		out.println("<nav>");
		out.println("<ul>");
		out.println("<li>메뉴1</li>");
		out.println("<li>메뉴2</li>");
		out.println("<li>메뉴3</li>");
		out.println("</ul>");
		out.println("</nav>");
		out.println("<section>");
		out.println("<article>내용</article>");
		out.println("</section>");
		out.println("<aside>좌우메누</aside>");
		out.println("<footer>바닥글</footer>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

}
