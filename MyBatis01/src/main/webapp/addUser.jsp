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
</style>
<body>
<center>用户注册</center>
<form action="addUser">
<table border="1" cellspacing="0">
<tr><td>账号</td><td><input type="text" name="name"></td></tr>
<tr><td>密码</td><td><input type="password" name="pass"></td>
<tr><td colspan="2"><button type="submit">提交</button> </td></tr>
</table>
</form>
</body>
</html>