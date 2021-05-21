<%@page import="stateless.MemberDAO"%>
<%@page import="stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href ="loginOut.jsp">로그인 페이지로.</a>
<%
//db조회 후 가져온 member 확인 후 이름, 나이를 출력
//없으면 "해당 사용자 없음"
	//string 객체 ==> equals
	if(request.getMethod().equals("POST")) {
		
		String mpwd = null;

		MemberDAO a = new MemberDAO();

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");


		Member member = a.checkInfo(id,pwd);

		mpwd = member.getMemberPwd();
		String mName = member.getMemberName();
		int mAge = member.getMemberAge();


		if(member == null || mpwd == null) {
			out.print("<h3>사용자 정보가 없습니다.</h3>");
		} else {
			session.setAttribute("info", member);
			out.print("이름: " + mName + "나이: " + mAge);
		}
		
	} else { //get : 로그아웃
		session.invalidate(); //세션 삭제
		out.print("로그아웃 됨");
	}

%>

</body>
</html>