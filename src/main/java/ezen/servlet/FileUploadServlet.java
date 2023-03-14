package ezen.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 파일 업로드
 */
@WebServlet("/upload")
//@MultipartConfig(
//	fileSizeThreshold = 1024 * 1024 * 10, 
//	maxFileSize = 1024 * 1024 * 30, 
//	maxRequestSize = 1024 * 1024 * 50)
@MultipartConfig

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 업로드한 파일이 저장될 패스 설정
	private String uploadPath = "C:/Users/ule19/OneDrive/Main/coding/fileStorage";

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		request.setCharacterEncoding("utf-8");
		
		// 일반 파라메터 데이터 
		String writer = request.getParameter("writer");
		System.out.println("작성자 : " + writer);
		
		// 단일 파일 업로드
		// Part part = request.getPart("upload-file");
		
		// 다중 파일 업로드
		for (Part part : request.getParts()) {
			System.out.println("---------- 업로드 파일 정보 ----------");
			System.out.println("ContentType : " + part.getContentType());
			System.out.println("File Size : " + part.getSize());
			
			// 업로드 파일명 추출
		    String fileName = extractFileName(part);
		    System.out.println("업로드 파일명: " + fileName);
		    if(fileName != null) {
		    	try {
		    		part.write(uploadPath + File.separator + fileName);
		    	}catch (IOException e) {
		    		response.setContentType("text/html; charset=utf-8");
		    		PrintWriter out = response.getWriter();
		    		out.println("<h2>업로드 파일은 30mb를 초과할 수 없습니다.</h2>");
					e.printStackTrace();
				}
		    }
		}
		
		System.out.println("===== 파일 업로드 처리 완료 =====");
		
	}
	
	// 요청메시지 헤더에서 업로드 파일명 추출
	private String extractFileName(Part part) {
		String fileName = null;
		String contentDisposition = part.getHeader("content-disposition");
		System.out.println(contentDisposition);
		// form-data; name="writer" 	파일이 아닌 경우
		// form-data; name="upload-file"; filename="some.zip";	 파일인 경우
		String[] tokens = contentDisposition.split(";");
		for(String token : tokens) {
			if(token.trim().startsWith("filename")) {
				// filename="some.zip"
				fileName = token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return fileName;
	}
	

}
