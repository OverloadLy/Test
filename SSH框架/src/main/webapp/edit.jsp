<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Css/style.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
<div class="top">
    <div style="float: left" ><img src="images/logo.png" height="40px" width="60px"></div>
    <div style="margin-left: 83%;font-size: 17px"><a href="#">帮助</a> <a href="login.jsp">退出</a></div>
</div>
<div class="left"><br><a href="index.jsp"> 用户查询</a><br><a href="addUser.jsp"> 用户新增</a></div>
<div class="right">
    <div class="top1">
    <form action="findOne_action" method="post">
                 用户名称：<input type="text" name="userName">&nbsp;
       <button type="submit">查询</button>&nbsp;
     </form>
    </div>
    <form action="updateOK_action">
    <table border="1" cellspacing="0" align="center" width="95%" id="tb">
        <tr>
            <td>编号</td>
            <td>用户名称</td>
            <td>邮箱</td>
            <td>性别</td>
            <td>创建时间</td>
            <td>修改时间</td>
            <td>操作</td>
        </tr>
    
	   <tr>
	   <td>${user.userId}</td>
	   <td><input type="text"  value="${user.userName}"  name="userName" style="width: 80px"></td>
	   <td><input type="email" value="${user.userEmail}" name="userEmail" style="width: 80px"></td>
	   <td><input type="radio" value="男" name="userSex" checked="checked">男
	       <input type="radio" value="女" name="userSex">女</td>
	   <td><input type="text" value="${user.createDate}" name="createDate" style="width: 80px"></td>
	   <td><input type="text" value="${user.updateDate}" name="updateDate" style="width: 80px"></td>
	   <td><button type="submit">确定</button>
	       <a href="delete_action?userId=${user.userId}">删除</a></td>
	   </tr>
	   <input type="hidden" name="userId" value="${user.userId}">	   
    </table>
    </form>
</div>
</body>
</html>