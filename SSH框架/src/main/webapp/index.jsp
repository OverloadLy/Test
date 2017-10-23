<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Css/style.css" type="text/css"/>
 <style type="text/css">
 td{background:#e5f1f4;}</style>
<title>Insert title here</title>
</head>
<body onload="goPage(1,6)">
<div class="top" >
    <div style="float: left" ><img src="images/logo.png" height="40px" width="60px"></div>
    <div style="float: left">用户管理系统</div>
    <div style="margin-left: 83%;font-size: 17px"><a href="#">帮助</a> <a href="login.jsp">退出</a></div>
</div>
<div class="left"><br><a href="findAll_action">用户查询</a><br><a href="addUser.jsp"> 用户新增</a></div>
<div class="right">
    <div class="top1">
       <form action="findOne_action" method="post">
                           用户名称：<input type="text" name="userName">&nbsp;
          <button type="submit">查询</button>&nbsp;
       </form>
   
    </div>
    
    <table  border="1" cellspacing="0" align="center" width="95%" id="t">
        <tr bgcolor="gainsboro">
            <td>编号</td>
            <td>用户名称</td>
            <td>邮箱</td>
            <td>性别</td>
            <td>创建时间</td>
            <td>修改时间</td>
            <td>操作</td>
        </tr>
       <c:forEach items="${users}" var="user">
	   <tr>
	   <td>${user.userId}</td>
	   <td>${user.userName}</td>
	   <td>${user.userEmail}</td>
	   <td>${user.userSex}</td>
	   <td>${user.createDate}</td>
	   <td>${user.updateDate}</td>
	   <td><a href="update_action?userId=${user.userId}">修改</a> 
	       <a href="delete_action?userId=${user.userId}">删除</a></td>
	   </tr>
       </c:forEach>
       <tr>
	<td colspan="9">
	共${count }条记录&nbsp;&nbsp;共${totalpage }页/当前${pageno }页&nbsp;&nbsp;
	<a href="findAll_action?Page.pageNo=1">首页</a>&nbsp;&nbsp;
	<c:if test="${pageno>1 }">
	<a href="findAll_action?Page.pageNo=${pageno-1 }">上一页</a>
	</c:if>
	<c:if test="${pageno<=1 }">
	<a href="#">上一页</a>
	</c:if>
	&nbsp;&nbsp;
	<c:if test="${pageno<totalpage }">
	<a href="findAll_action?Page.pageNo=${pageno+1 }">下一页</a>
	</c:if>
	<c:if test="${pageno>=totalpage }">
	<a href="#">下一页</a>
	</c:if>
	&nbsp;&nbsp;
	<a href="findAll_action?Page.pageNo=${totalpage }">尾页</a> 
	</td>
 </tr>
       
</table><br>
        <!-- <div id="changePages"></div> -->
</div>
</body>
</html>