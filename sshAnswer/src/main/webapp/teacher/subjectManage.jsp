<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>试题管理页面</title>
	<style type="text/css">
input {
	background-color:#cccccc ;
}
	</style>
	<link href="images/skin.css" rel="stylesheet" type="text/css">
  </head>
  
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">管理试题</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="53%" valign="top">&nbsp;</td>
        </tr>
      <tr>
        <td valign="middle"><span class="left_txt">
			<div id="manageSubject" align="center">
			<table width="95%" cellspacing="10">
				  <tr align="center">
					<td>试题编号</td>
					<td>试题标题</td>
					<td>正确答案</td>		
					<td>修改试题</td>
					<td>删除试题</td>
				  </tr>
				  <c:forEach items="${papers}" var="paper">
				  	 <tr align="center">
							<td>${paper.id}</td>
							<td>${paper.title}</td>
							<td>${paper.answer}</td>
							<td><a href="findOne_paper?id=${paper.id}">修改</a></td>												
							<td><input type="button" value="删除" onclick="if(window.confirm('确定要删除吗？')) document.location='delete_paper?id=${paper.id}'"/><td>
					
					 </tr>
				 </c:forEach>
				 <tr>
	<td colspan="5">
	共${count }条记录&nbsp;&nbsp;共${totalpage }页/当前${pageno }页&nbsp;&nbsp;
	<a href="findAll_paper?Page.pageNo=1">首页</a>&nbsp;&nbsp;
	<c:if test="${pageno>1 }">
	<a href="findAll_paper?Page.pageNo=${pageno-1 }">上一页</a>
	</c:if>
	<c:if test="${pageno<=1 }">
	<a href="#">上一页</a>
	</c:if>
	&nbsp;&nbsp;
	<c:if test="${pageno<totalpage }">
	<a href="findAll_paper?Page.pageNo=${pageno+1 }">下一页</a>
	</c:if>
	<c:if test="${pageno>=totalpage }">
	<a href="#">下一页</a>
	</c:if>
	&nbsp;&nbsp;
	<a href="findAll_paper?Page.pageNo=${totalpage }">尾页</a> 
	</td>
 </tr>  
			</table>	
			</div>
		</td>
        </tr>
      
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
</html>
