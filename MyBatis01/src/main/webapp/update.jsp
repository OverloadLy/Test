<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	table {text-align: center;margin: auto;}
	td{width: 100px;height: 20px}
	input{text-align: center;}
</style>
<body>
<form action="updateUser">
<table border="1" cellspacing="0">
	<tr><td>编号</td><td>${user.id}</td></tr>
	<tr><td>账号</td><td><input type="text" name="name" value="${user.name}"></td></tr>
	<tr><td>原密码</td><td>${user.pass}</td></tr>
	<tr><td>新密码</td><td><input type="text" name="pass"></td></tr>
    <tr><td colspan="2"><button type="submit">保存</button></td></tr>
</table>
<input type="hidden" name="id" value="${user.id}">
</form>
</body>
</html>