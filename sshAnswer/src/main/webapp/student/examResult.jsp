<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>考试结果</title>

<body>
<table align="center" border="1" width=20% cellspacing="0">
<tr><td colspan="2" align="center">得分情况</td> </tr>
<tr><td align="center">考试姓名：</td><td align="center">${stuName.sname}</td></tr>
<tr><td align="center">考生得分：</td><td align="center">${point}分</td></tr>
<tr><td colspan="2" align="center"><input type="button" onclick="window.location.href='login.jsp'" value="退出考试"/></div></td></tr>

</table>
</body>
</html>
