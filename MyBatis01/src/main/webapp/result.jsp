<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {text-align: center;margin: auto;}
	td{width: 100px;height: 20px}
	a{text-decoration: none;}
	button {border:0px solid;}
	button{cursor: pointer }
}
</style>
</head>
<body>
<center><h3><a href="addUser.jsp">添加用户</a></h3></center>
<table border="1" cellspacing="0">
	<tr><td>编号</td><td>账号</td><td>密码</td><td colspan="2">操作</td></tr>
	<c:forEach items="${users}" var="user">
	<tr><td>${user.id}</td><td>${user.name}</td><td>${user.pass}</td>
	<td colspan="2"><a href="findById?id=${user.id}">修改</a> 
	<button onclick="if(window.confirm('确定要删除吗？')) document.location='deleteUser?id=${user.id}'">删除</button>
	</td></tr>
	</c:forEach>
	
<!-- 分页功能 start -->  
    <tr><td colspan="6">
        <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第  
            ${page.pageNow} 页</font> <a href="findByPage?pageNow=1">首页</a>  
        <c:choose>  
            <c:when test="${page.pageNow - 1 > 0}">  
                <a href="findByPage?pageNow=${page.pageNow - 1}">上一页</a>  
            </c:when>  
            <c:when test="${page.pageNow - 1 <= 0}">  
                <a href="findByPage?pageNow=1">上一页</a>  
            </c:when>  
        </c:choose>  
        <c:choose>  
            <c:when test="${page.totalPageCount==0}">  
                <a href="findByPage?pageNow=${page.pageNow}">下一页</a>  
            </c:when>  
            <c:when test="${page.pageNow + 1 < page.totalPageCount}">  
                <a href="findByPage?pageNow=${page.pageNow + 1}">下一页</a>  
            </c:when>  
            <c:when test="${page.pageNow + 1 >= page.totalPageCount}">  
                <a href="findByPage?pageNow=${page.totalPageCount}">下一页</a>  
            </c:when>  
        </c:choose>  
        <c:choose>  
            <c:when test="${page.totalPageCount==0}">  
                <a href="findByPage?pageNow=${page.pageNow}">尾页</a>  
            </c:when>  
            <c:otherwise>  
                <a href="findByPage?pageNow=${page.totalPageCount}">尾页</a>  
            </c:otherwise>  
        </c:choose>  
   </td>
   </tr>
   </table>
    <!-- 分页功能 End -->  
</body>
</html>