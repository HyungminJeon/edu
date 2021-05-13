package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {
	String id, password;

	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");   //web.xml의 파라미터 값을 가져오겠다 / init 객체의 매개값으로 들어온 파라미터의 벨류값을 가져온다
		password = config.getInitParameter("password");
	}
	
	//자바소스에서 컴파일시 파일을 tomcat에 업로드하는 과정이 필요하다.
	//환경파일에서 설정시 컴파일하는 과정이 필요없어지므로, 서버만 restart하면 init parameter가 실행되므로 
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out  = resp.getWriter();
		out.print("<h3>" +id + "</h3>");
		out.print("<h3>" +password + "</h3>");
		
	}

}
