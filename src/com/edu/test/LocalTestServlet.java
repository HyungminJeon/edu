package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/local")
public class LocalTestServlet extends HttpServlet{

	// int number =0;  
	//클래스 서버가 살아있는 한 계속 메모리에 있음
	//garbage collector가 지우지 않는 한 계속 남아있음
	
	
	//변수 number가 doGet 메소드 안에 local변수로 정의 되어있기 때문에 브라우저를 여러개 열고 여러개의 client에서 각각 요청해도 서블릿이 독립적으로 각각의 thread안에서 처리됨.
	//int number가 전역변수로 선언되면 변수를 클라이언트끼리 공유하여 처리하기 때문에 서로의 결과값에 영향을 미친다.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int number =0;
		
		//doGet method에 local 변수를 선언해서 호출하는 경우
		String str = req.getParameter("msg");   
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Thread Test</title></head></html>");
		out.print("<body><h2>처리결과</h2>");
		
		while(number++ < 10) {
			out.print(str + " : " + number +"<br/>"); 
			out.flush();  //stream이 꽉차지 않아도 내보내겠다
			System.out.println(str + " : " + number);
			try {
				Thread.sleep(1000); //1초마다 잠재우겠다.
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			} 
		}
		out.print("<h2>Done: " + str + "</h2>");
		out.print("</body></html>");
		out.close();
	}
}
