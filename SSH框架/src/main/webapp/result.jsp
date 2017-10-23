<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Css/style.css" type="text/css"/>
   <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<body onload="goPage(1, 5)">
<form action="findOne_action" method="post">
<div class="top">
    <div style="float: left" ><img src="images/logo.png" height="40px" width="60px"></div>
    <div style="margin-left: 83%;font-size: 17px"><a href="#">帮助</a> <a href="login.jsp">退出</a></div>
</div>
<div class="left"><br><a href="findAll_action"> 用户查询</a><br><a href="addUser.jsp"> 用户新增</a></div>
<div class="right">
    <div class="top1">用户名称：<input type="text" name="userName">&nbsp;
       <button type="submit">查询</button>&nbsp;
    </div>
    <table border="1" cellspacing="0" align="center" width="95%" id="t">
        <tr>
            <td>编号</td>
            <td>用户名称</td>
            <td>邮箱</td>
            <td>性别</td>
            <td>创建时间</td>
            <td>修改时间</td>
            <td>操作</td>
        </tr>
       <c:forEach items="${users}" var="list">
	   <tr>
	   <td>${list.userId}</td>
	   <td>${list.userName}</td>
	   <td>${list.userEmail}</td>
	   <td>${list.userSex}</td>
	   <td>${list.createDate}</td>
	   <td>${list.updateDate}</td>
	   <td><a href="update_action?userId=${list.userId}">修改</a> 
	       <a href="delete_action?userId=${list.userId}">删除</a></td>
	   </tr>
    </c:forEach> 
        <tr>
	<td colspan="9">
	共${count }条记录&nbsp;&nbsp;共${totalpage }页/当前${pageno }页&nbsp;&nbsp;
	<a href="findOne_action?Page.pageNo=1">首页</a>&nbsp;&nbsp;
	<c:if test="${pageno>1 }">
	<a href="findOne_action?Page.pageNo=${pageno-1 }">上一页</a>
	</c:if>
	<c:if test="${pageno<=1 }">
	<a href="#">上一页</a>
	</c:if>
	&nbsp;&nbsp;
	<c:if test="${pageno<totalpage }">
	<a href="findOne_action?Page.pageNo=${pageno+1 }">下一页</a>
	</c:if>
	<c:if test="${pageno>=totalpage }">
	<a href="#">下一页</a>
	</c:if>
	&nbsp;&nbsp;
	<a href="findOne_action?Page.pageNo=${totalpage }">尾页</a> 
	</td>
 </tr>
    </table><br>
</div>
</form>
</body>
</html>