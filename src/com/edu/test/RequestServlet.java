package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RequestServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String met = request.getMethod();
		System.out.println(met);
		
		
		String name = request.getParameter("name");
		String user_id = request.getParameter("user_id");
		String user_age = request.getParameter("user_age");
		
		System.out.println(name + user_id + user_age);
		
		
		PrintWriter out = response.getWriter();
		
		if(met.equals("GET")) {
			
			out.print("<table border ='1'");
			out.print("<tr><td>이름</td><td>");
			out.print(name + "</td></tr><tr><td>나이</td><td>");
			out.print(user_age + "</td></tr><tr><td>아이디</td><td>");
			out.print(user_id + "</td></tr>");
			
			
		} else {
			
			out.print("<OL>");
			out.print("<LI>이름: " + name + "</LI>");
			out.print("<LI>나이: " + user_age + "</LI>");
			out.print("<LI>아이디: " + user_id + "</LI>");
		}
		
		
//		ArrayList s = new ArrayList();
//		s.add(name);
//		s.add(user_id);
//		s.add(user_age);
//		
//		ArrayList title = new ArrayList();
//		title.add("이름");
//		title.add("아이디");
//		title.add("나이");
//		
//			
//
//			out.print("<table border=\"1\">");
//
//
//
//	//반복문을 돌려서 input 값만큼 table 행과 열을 생성한다.
//
//			for(int r=0; r < 3; r++) {
//
//				out.print("<tr>");
//
//					
//					out.print("<td>");
//
//					out.print(title.get(r));
//
//					out.print("</td>");
//
//					out.print("<td>");
//
//					out.print(s.get(r));
//
//					out.print("</td>");
//
//				out.print("</tr>");
//
//			}//row
//
//
//			out.print("</table>");
//		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
