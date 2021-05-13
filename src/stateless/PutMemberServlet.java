package stateless;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberRegister")
public class PutMemberServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//db에서 리스트 ->memberList.jsp
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.getMemberList();
		
		RequestDispatcher rd = req.getRequestDispatcher("memberList.jsp");
		req.setAttribute("memberList", list);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//parameter를 읽어서 db insert, memberResult.jsp로 해당 정보들 재지정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		
		//System.out.println("db에 입력되었습니다.");
		Member member = new Member();
		member.setMemberId(Integer.parseInt(id));
		member.setMemberName(name);
		member.setMemberPwd(pwd);
		member.setMemberAge(Integer.parseInt(age));
		
		MemberDAO dao = new MemberDAO();
		dao.insertMember(member);
		
		// this.getServletContext(); //ServletContext의 requestdispatcher를 가져 오는 방법
		RequestDispatcher rd = req.getRequestDispatcher("memberResult.jsp"); //memberResult.jsp에 데이터를 전달하겟다.
		req.setAttribute("member", member);   //멤버 클래스 전체의 값을 요청함
		rd.forward(req, resp);
	}
}
