<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jsp/example10.jsp</title>
</head>
<body>
<%
String rId= null;
String name= null;
int age= 0;
String alarm= null;

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

if(id == null) {
	id = (String) session.getAttribute("id");
}
		
if(pwd == null) {
	pwd = (String) session.getAttribute("pwd");
}
if(id.isEmpty() || pwd.isEmpty()) {
	request.setAttribute("err", "ID, 비밀번호 입력하세요.");
	RequestDispatcher rd =  request.getRequestDispatcher("loginOut.jsp");
	rd.forward(request,response);
	return;
}
//로그인 처리
if(session.isNew() || session.getAttribute("id") ==null) {
	session.setAttribute("id",id);
	session.setAttribute("pwd",pwd);
	session.setAttribute("name","홍길동");
	session.setAttribute("age",14);
	session.setAttribute("alarm","세션 종료시 접속이 종료됩니다.");
	
	out.print("로그인 작업이 완료.");
} else {
	out.print("이미 로그인 작업이 완료되어 있습니다.");
	rId = (String) session.getAttribute("id");
	name = (String) session.getAttribute("name");
	age = (int) session.getAttribute("age");
	alarm = (String) session.getAttribute("alarm");
	
	out.print("<br><H3> 이름:" + name + "</H3>");
	out.print("<br><H3> 나이:" + age + "</H3>");
	out.print("<br><H5>" + alarm + "</H5>");
	
}
%>
<h3>아이디: <%=id%></h3>
<h3>비밀번호: <%=pwd%></h3>
</body>
</html>