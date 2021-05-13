package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/netInfo")  //서블릿 매핑
public class NetInfoServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter(); // out 객체가 NetInfoServlet 응답객체의 웹브라우저가 가지고있는 출력 스트림을 가져온다.
		out.print("<html>"); 
		out.print("<head><title>Request정보 출력</title></head>");
		out.print("<body>");
		out.print("<h3>네트워크 관련요청</h3>");
		out.print("Request Scheme: " +req.getScheme()+ "<br/>");
		out.print("Server Name: " + req.getServerName() + "<br/>");
		out.print("Server Address: " + req.getLocalAddr() + "<br/>");
		out.print("Server Port: " + req.getServerPort() + "<br/>");
		out.print("Client Address: " +req.getRemoteAddr() + "<br/>");
		out.print("Client Host: " + req.getRemoteHost() + "<br/>");
		out.print("Client Port: " + req.getRemotePort() + "<br/>");
		
		out.print("<h3>URL 정보</H3>");
		out.print("Request URL: " + req.getRequestURL()+ "<br/>");
		out.print("Request URI: " + req.getRequestURI()+ "<br/>");
		out.print("Context Path: " + req.getContextPath() + "<br/>");
		out.print("Request Protocol: " + req.getProtocol() + "<br/>");
		out.print("Server Path: " + req.getServletPath() + "<br/>");
		
		
		out.print("</body></html>");
		out.close();
		
		
	}
}
