<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.biz.user.MemberVO"%>

<%
String gubun = (String)session.getAttribute("SS_GUBUN");
if(!gubun.equals("a")){
	response.sendRedirect("/member_login/jsp");
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
어드민페이지<br>

<form action="/slogout" method = "post">
<input type = "submit" value="로그아웃">
</form>
<table border=1 width=300>
<% 
ArrayList list = (ArrayList)request.getAttribute("LVL");
out.println(list.size()+"명 회원");
MemberVO vo = new MemberVO();
for(int i = 0 ; i < list.size() ; i++){
	vo = (MemberVO)list.get(i);
%>
<tr>
	<td><%=vo.getSeq() %></td>
	<td><%=vo.getMid() %></td>
	<td><%=vo.getMpw() %></td>
	<td><%=vo.getMname() %></td>
</tr>
<%
}
%>
</table>
</body>
</html>