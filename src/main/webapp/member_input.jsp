<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "/member" method = "post">
<table width=300 border=1>
<tr>
	<td>아이디 </td>
	<td><input type="text" name="mid" ><br></td>
</tr>
<tr>
	<td>비번 </td>
	<td><input type="password" name="mpw"><br></td>
</tr>
<tr>
	<td>이름 </td>
	<td><input type="text" name="mname" ><br></td>
</tr>
<tr>
	<td colspan=2 align=center><input type="submit" name="sbtn" value="가입하기">
	<input type="reset" name="rbtn" value="취소"><br></td>
</tr>
</table>
</form>
</body>
</html>