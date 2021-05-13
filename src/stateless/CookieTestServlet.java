package stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	PrintWriter out = resp.getWriter();
	Cookie c1 = new Cookie("id","guest");
	c1.setPath("/");  //서버의 특정위치 ( ex. /login 로그인이라는 폴더밑의 주소에만 쿠키를 활용하겠다)  이때는 전체 위치에서 쿠키를 활용하겠다라는 뜻
	resp.addCookie(c1);  // 클라이언트쪽으로 방금 만든 c1이라는 쿠키를 전송하겠다.
	//maxage 지정안하면 해당 웹브라우저 닫으면 쿠키 사라짐
	
	Cookie c2 = new Cookie("code","0001");
	c2.setMaxAge(2 * 60);  //해당되는 시간만큼만 쿠키가 유효함 (초단위로 계산)  이 경우 3시간동안 쿠키를 사용하겠다
	c2.setPath("/");
	resp.addCookie(c2);
	
	Cookie c3 = new Cookie("subject","java");
	c3.setMaxAge(10 *24 * 60* 60);  //10일동안 쿠키를 저장하겠다
	c3.setPath("/");
	resp.addCookie(c3);
	
	out.print("쿠키 전송 완료");
	out.close();
	}
}
