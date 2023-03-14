package ezen.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
@WebServlet("/member")
public class HttpServletResponseEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("audio/mpeg");//mp3
//		String path = "";
//		PrintWriter out = response.getWriter();
		response.setContentType("application/pdf");//pdf
		String path = "";
		InputStream in = new FileInputStream(path);
		OutputStream out = response.getOutputStream();
		
//		out.println("나는 바보바보");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
