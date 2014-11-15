<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="springform"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>HiddenXssStream</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="xss,platform,跨站">
	<meta http-equiv="description" content="This is a xss platform for registed users">
	<script type="text/javascript">
		if(window!=window.top){ //防钓鱼代码
		window.top.location.href=window.location.href;
		}
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h1><b></b></h1>
  <form action="updateUserData" id="xssUserForm" method="post" enctype="multipart/form-data"> 
  		<input type="file" name="photo"/>
  		<input type="submit" value="xss"/>
  </form>
    
    ${fileUrl}
  </body>
</html>
