<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Css/style.css" type="text/css"/>
   <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/common.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="top">
    <div style="float: left" ><img src="images/logo.png" height="40px" width="60px"></div>
    <div style="float: left">用户管理系统</div>
    <div style="margin-left: 83%;font-size: 17px"><a href="#">帮助</a> <a href="login.jsp">退出</a></div>
</div>
<div class="left"><br><a href="ly.jsp"> 用户查询</a><br><a href="addUser.jsp"> 用户新增</a></div>
<div class="right">
<h3 align="center">新增&编辑用户信息</h3>
    <form action="addUser_action" method="post">
    <p>用户名称：<input type="text" name="userName"   placeholder="请输入你的用户名!" style="width: 300px" id="name"></p>
    <p>电子邮箱：<input type="text" name="userEmail" placeholder="请输入你的邮箱！" style="width: 300px" id="email"></p>
    <p>创建时间：<input type="text" name="createDate" placeholder="请输入创建时间！" style="width: 300px" id="pass1"></p>
    <p>修改时间：<input type="text" name="updateDate" placeholder="请输入修改时间！" style="width: 300px" id="pass2"></p>
    <p>性别：<input type="radio" name="userSex" checked="checked" value="男">男<input type="radio" value="女" name="userSex" id="sex">女</p>
<hr>
    <button type="button" id="btn1">提交</button>
    <button type="reset">重置</button>
    <button type="submit">返回</button>
    </form>
</div>
</body>
</html>