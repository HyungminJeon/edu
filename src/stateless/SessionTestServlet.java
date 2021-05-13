package stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String param = req.getParameter("p"); // ?p=""
		String msg = null;
		HttpSession session = null;  
		//이전에 만든 세션이 있으면 그 세션값을 리턴해주고, 이전세션정보가 없으면 새로운 세션정보를 만들어서 리턴해줌 
		
		// getSession(true) = getSession();
		// getSession(false) //이전에 만든 세션이 있으면 그 세션값을 리턴해주고, 이전세션정보가 없으면 null 값을 리턴
		if(param.equals("create")) {  //?p=create
			session = req.getSession();   //get session으로 세션 정보를 읽어옴
			System.out.println(session.getId());
			if(session.isNew()) {
				msg = "새로운 세션 객체가 생성됨.";
			} else {
				msg = "기존의 세션 객체가 리턴됨.";
			}
		} else if (param.equals("delete")) {
			session = req.getSession(false);   //세션정보 있으면 세션값 없으면 null
			if(session != null) {
				session.invalidate();  //session 삭제
				msg = "세션 객체 삭제 작업 완료.";
			} else {
				msg = "삭제할 세션 존재하지 않음.";
			}
		}
		out.print("<h2>"+ msg + "</h2>");
		out.close();
	}

}
