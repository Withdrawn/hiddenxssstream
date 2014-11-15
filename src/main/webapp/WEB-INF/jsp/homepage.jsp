<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="springform"  %>
<%@ taglib prefix="c" uri="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href=" <%=basePath%>"> 
    <title>HiddenXssStream</title>
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
	
	<link rel="stylesheet" type="text/css" href="css/homepage.css">
	
	<script>
		 function iFrameHeight(ifm) {
        	var subWeb = document.frames ? document.frames["contentfrm"].document :ifm.contentDocument;
            if(ifm != null && subWeb != null) {
            	ifm.height = subWeb.body.scrollHeight+100;
            }
   		}  
	</script>
  </head>
  
  <body>

  <c:if test="${requestScope.msg!=null}">
  	<script>alert('${requestScope.msg}');</script>
  </c:if>
<jsp:include page="nav.jsp"></jsp:include>
<div id="header"></div>
	 <div id="bodylayout">
	 		<div id="bodyleft">
	 			<div id="userhead">
	 				<img src="images/100.png" alt="">
	 			</div>
	 			<div class="usernav">
	 				<ul>
		 				<li><a target="contentfrm" href="project">我的项目</a></li>
		 				<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
		 				<li ><a target="contentfrm" href="module">
		 					我的模块</a>
		 					<div class="h3_cat">
									<div class="shadow_border">
										<ul>
											<c:forEach var="module" items="${modules }">
												<li><a target="contentfrm"  href="module/${module.m_id }">${module.m_title }</a></li>
											</c:forEach>
										</ul>
									</div>
							</div>
		 				</li></div>
		 				<li><a target="contentfrm" href="pubmodule">我的模块--公共模块</a></li>
		 				<li><a target="contentfrm" href="message">我的消息</a></li>
		 				<li><a target="contentfrm" href="memory">我的回忆</a></li>
		 				<li><a target="contentfrm" href="arm">我的利器</a></li>
		 				<li><a target="contentfrm" href="info">个人信息</a></li>
	 				</ul>
	 			</div>

	 		</div>
	 		<div id="bodyright" >
	 			<iframe src="" onload="iFrameHeight(this)" frameborder="0" width="100%" height="100%" scrolling="no" name="contentfrm" id="contentfrm">
	 			</iframe>
	 		</div>
	 		<div style="clear:both;"></div>
	 </div>
	 <div id="bottomlay">
	 		<iframe src="bottom.html" width='100%' height='60px' scrolling='no' frameborder="0"></iframe>
	 </div>
  </body>
  <script type="text/javascript">
   	//	var params = {};   
   		// params.allowscriptaccess = "sameDomain";
		// swfobject.embedSWF("images/platformcookie.swf", "loginflash", "200", "120", "9.0.0", "expressInstall.swf",params);
		// var uname={};
		// uname.value=document.cookie.split(";")[2].split("=")[1];
		// var upass={};
		// upass.value=document.cookie.split(";")[3].split("=")[1];
		
		 //setTimeout(function(){window["loginflash"].saveCookies("xss_uname",uname);window["loginflash"].saveCookies("xss_upass",upass)},3000);

  </script>
</html>
