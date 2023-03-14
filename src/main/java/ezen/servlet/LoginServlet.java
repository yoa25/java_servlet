package ezen.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String loginId = request.getParameter("id");
//		String loginPw = request.getParameter("password");
//
//		// 사용자 테이블을 조회하여 사용자 인증 처리
//		boolean isMember = true; // 지금은 무조건 회원이라 가정
//		
//		if(isMember) {
//			// 사용자 로그인 아이디를 브라우저 세션에 저장
//			//서버쪽의 사용자 정보를 저장하기 위한 장부
//			HttpSession session =  request.getSession();
//			
//			session.setAttribute("loginId", loginId); //속성 저장
//			response.sendRedirect("main");
//		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("id");
		String loginPw = request.getParameter("password");

		// 사용자 테이블을 조회하여 사용자 인증 처리
		boolean isMember = true; // 지금은 무조건 회원이라 가정
		
		if(isMember) {
			// 사용자 로그인 아이디를 브라우저 세션에 저장
			//서버쪽의 사용자 정보를 저장하기 위한 장부
			
			// 쿠키를 이용해 사용자 로그인 아이디 저장
			Cookie loginIdCookie = new Cookie("loginId", loginId);
			loginIdCookie.setPath("/");
			response.addCookie(loginIdCookie);
			
			String itemValue = "코코팜";
//			URLEncoder.encode(loginPw)
			
			response.sendRedirect("main");
			
		}
	}

}
