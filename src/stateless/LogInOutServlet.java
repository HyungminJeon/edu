package stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet {
     
	//로그인 처리
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	PrintWriter out = resp.getWriter();
	String id = req.getParameter("id");
	String pwd = req.getParameter("pwd");
	
	if(id.isEmpty() || pwd.isEmpty()) {
		out.print("ID 또는 비번을 입력하세요.");
		return;  //if 구문안에 return을 넣으면 그 이후로 더 작업하지 않고 if문 끝낸다
	}
	HttpSession session = req.getSession();   //form으로 서버에 정보요청 했기 때문에 session 발생
	if(session.isNew() || session.getAttribute("id") == null) {   //가져온 세션값이 새로운 세션이나 가져온 id가 null 이 아닐때
		session.setAttribute("id", id);  //사용자가 입력한 아이디를 입력
		session.setAttribute("data1", "100");  
		out.print("로그인 완료");	
	} else {
		out.print("이미 로그인 상태입니다.");
	}
	}

	
	//로그아웃 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("id") != null) {
			session.invalidate();
			out.print("로그아웃 완료");
		} else {
			out.print("로그인 상태가 아니니다.");
		}
		out.close();
	}
}
