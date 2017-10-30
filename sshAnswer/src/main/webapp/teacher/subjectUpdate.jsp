<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>试题更新页面</title>
	<link href="images/skin.css" rel="stylesheet" type="text/css">
  </head>
  
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">修改试题</div></td>
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
			<div id="updateSubjectForm" align="center"><!--更新试题表单-->
				<form action="update_paper" method="post">
				<table border="0" cellspacing="10" cellpadding="0">
					<tr>
						<td colspan="2"><s:actionmessage/></td>
					</tr>
				  <tr>
					<td>试题题目:</td>
					<td>
						<input name="id" type="hidden" value="${subject.id}">
						<input name="title" type="text" size="80"  value="${subject.title}">
					</td>
				  </tr>
				  <tr>
					<td>选项A:</td>
					<td><input type="text" name="optionA" size="20" value="${subject.optionA}"></td>
				  </tr>
				   <tr>
					<td>选项B:</td>
					<td><input type="text" name="optionB" size="20" value="${subject.optionB}"></td>
				  </tr>
				   <tr>
					<td>选项C:</td>
					<td><input type="text" name="optionC" size="20" value="${subject.optionC}"></td>
				  </tr>
				   <tr>
					<td>选项D:</td>
					<td><input type="text" name="optionD" size="20" value="${subject.optionD}"></td>
				  </tr>
				   <tr>
					<td>答案:</td>
					<td>
						<input name="answer" type="radio" value="A" checked="checked">A
						<input name="answer" type="radio" value="B">B
						<input name="answer" type="radio" value="C">C
						<input name="answer" type="radio" value="D">D
					</td>
				  </tr>
			
				  <tr>
				  	<td colspan="2"><div align="center">
				  	  <input type="submit" value="保存">				  	  
				  	  <input type="reset" value="重置">
			  	  </div>
				</td>
				  </tr>
			</table>
			</form>	
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
