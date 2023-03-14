package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterServlet
 */
@WebServlet("/member/register")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Post 방식으로 전달된 데이터 수신
		// 폼데이터로 전송되는 데이터중에 한글이 포함된 경우
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		// 동일한 이름의 파라메터에 여러개가 전달되는 경우
		String[] hobbyValues = request.getParameterValues("hobby");
		if (hobbyValues!=null) {
			for (String hobby : hobbyValues) {
				System.out.println(hobby);
			}
		}else {
			System.out.println("선택한 취미가 없습니다.");
		}
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
//		System.out.println(hobby);
		
		// 폼 태그의 이름을 알 수 없는 경우
		// DOM이 동적 생성 된 경우
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String parameterName = e.nextElement();
			if(parameterName.equalsIgnoreCase("hobby")) {
				String[] hs = request.getParameterValues(parameterName);
				if(hs != null) {
					for (String h : hs) {
						System.out.println(h);
					}
				}
			}else {
				String parameterValue = request.getParameter(parameterName);
				System.out.println(parameterName + " : " +parameterValue);
				
			}
		}
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
