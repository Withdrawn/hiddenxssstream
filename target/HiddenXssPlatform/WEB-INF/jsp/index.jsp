<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="springform"  %>
<%@ taglib prefix="c" uri="c"  %>
<%@ taglib prefix="fn" uri="fn"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href=" <%=basePath%>"> 
   <title>HiddenXssPlatform login|登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="xss,platform,跨站">
	<meta http-equiv="description" content="This is a xss platform for registed users">
	<script type="text/javascript" src="js/swfobject.js">
		if(window!=window.top){ //防钓鱼代码
		window.top.location.href=window.location.href;
		}
	
	</script>
	<link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  
  <body>

 <div id="xss">
	</div>
	<div id="login">
	${errormsg }
			<h1 id="logtitle"><b>Sign in to platform</b></h1>
			<form:form modelAttribute="user" action="user/login" id="xssLoginForm" method="post"> 
				<div class="inputline"><label for="uname">Username</label><form:input autocomplete="true" path="u_name" tabindex="1"  id="uname" alt="用户名"/></div>
				<div class="inputline"><label for="upass">Password</label><form:password autocomplete="true" path="u_pass" tabindex="2"  id="upass" alt="密码"/></div>
				<c:choose>
				<c:when test="${ errormsg=='验证码有误'}">
					<div class="loginline code">
					<label for="ucode">Code</label><form:input  path="u_code"  tabindex="3" id="ucode"/>
					<img src="../capthca" alt="check code" onclick="this.src=this.src.split('?')[0]+'?'+new Date().getTime()">
				</c:when>
				<c:otherwise>
					<div class="loginline code" style="background:none;">
				</c:otherwise>
				</c:choose>
					<input type="submit" value="Sign &nbsp;in" id="ulogin" name="ulogin"/>
				</div>
				<div class="logbottom">
					<img src="images/cha.jpg" alt="取消">
					<a href="javascript:void(0)">Remember &nbsp;me </a>
					<a href="javascript:void(0)" style="margin-left:50px;">Forgot your password ?</a>
				</div>
			</form:form>
	</div>
<div id="loginflash"></div>
  </body>
　　 <script type="text/javascript">
		function setCfromFlash(fcookie)
		{
			var exp = new Date();
			exp.setTime(exp.getTime() +7*24*60*60*1000);
			document.cookie =  "xss_uname="+escape(fcookie["fcookie"])+ ";expires=" + exp.toGMTString()+";path=/";
			document.cookie =  "xss_upass="+escape(fcookie["fcookie2"])+ ";expires=" + exp.toGMTString()+";path=/";
		//	location.href="../homepage";
		}
		 swfobject.embedSWF("images/platformcookie.swf", "loginflash", "0", "0", "9.0.0", "expressInstall.swf");
		</script>
		<c:choose>
			<c:when test="${errormsg=='fine' }">
			   登录成功${sessionScope.u_name}
			   <script>
			   		
			   </script>
			</c:when>
			<c:otherwise>
				<c:if test="${not empty errormsg}">
					<script>alert('${errormsg}'.length);</script>
				</c:if>
			</c:otherwise>
		</c:choose>

</html>
