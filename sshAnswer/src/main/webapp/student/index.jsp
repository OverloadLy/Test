<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>开始考试</title>
<link href="student/images/css2.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
 var ksTime; //定义考试时间以分钟计算
 ksTime = 120;//设置时间 这里设置为0.1代表是6秒,测试用
 if(readCookie("ss")==""){
  setCookie("ss",new Date(),ksTime/60);
 }
 function sT(){
  var tti = new Date();
  var lt  = parseInt((tti-new Date(readCookie("ss")))/1000)
  if((ksTime*60-lt)<0){
   setCookie("ss",new Date(),0);
   alert("考试时间到!\n即将提交试卷!");
   document.forms[0].submit();
  }else{
  	lm = Math.floor(lt / 60);
	ls = lt % 60;
	allY = ksTime*60-lt;
	ym = Math.floor(allY / 60);
	ys = allY % 60;
   document.getElementById("tTime").innerHTML = "考试已经开始了" + lm + "分" + ls + "秒" + ",剩余"  + ym + "分" + ys + "秒";
   var ttt = setTimeout("sT()",1000);
  }
 }
 function readCookie(name) { 
  var cookieValue = ""; 
  var search = name + "="; 
  if(document.cookie.length > 0) { 
   offset = document.cookie.indexOf(search); 
   if (offset != -1) { 
    offset += search.length; 
    end = document.cookie.indexOf(";", offset); 
    if (end == -1) 
     end = document.cookie.length; 
    cookieValue = document.cookie.substring(offset, end) 
   } 
  } 
  return cookieValue; 
 }  
 function setCookie(name, value, hours) { 
  var expire = ""; 
  if(hours != null) { 
   expire = new Date((new Date()).getTime() + hours * 3600000); 
   expire = "; expires=" + expire.toGMTString(); 
  } 
  document.cookie = name + "=" + value + expire; 
 }
 </script>
</head>

<body onload="sT()">
<table width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="149" height="485">&nbsp;</td>
    <td width="741" valign="top" class="rightbian">
	 <form action="saveAnswer_action" method="post">
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="10">
      <tr>
        <td><div align="center" class="STYLE3">考试时间：120 分钟</div></td>
        <td><div align="center" class="STYLE3">考生：${stuName.sname}</div></td>
        <td><div align="center" class="STYLE3">总分 ：100 分</div></td>
        <input type="hidden" name="id" value="${stuName.id}"/>	
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><div id="tTime"></div></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3" bgcolor="#999999" class="STYLE4">选择题</td>
      </tr>
	  <!--题目开始-->
	 
	  <c:forEach items="${papers}" var="paper" varStatus="sta">
				<tr>
					<td><strong>第<span class="STYLE5">${sta.index + 1}</span>题&nbsp;：${paper.title}</strong></td>
				</tr>				
				<tr>
					<td height="32" colspan="3" bgcolor="#CCCCCC">
					    <input type="radio" name="subjectAnswer${sta.index}" value="A" />A.${paper.optionA}&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="subjectAnswer${sta.index}" value="B" />B.${paper.optionB}&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="subjectAnswer${sta.index}" value="C" />C.${paper.optionC}&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="subjectAnswer${sta.index}" value="D" />D.${paper.optionD}</td>				
				</tr>
			<input type="hidden" name="answer" value="${paper.answer}">	
			</c:forEach>
	   <!--题目结束-->
      <tr>
        <td colspan="3"><div align="center">
          <input type="submit" value=" 提交答卷 " name="Submit" />
        </div></td>
      </tr>
    </table>
     </form>
    </td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
</body>
</html>
