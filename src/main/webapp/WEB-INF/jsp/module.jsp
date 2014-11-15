<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="springform"  %>
<%@ taglib prefix="c" uri="c"  %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta charset='utf-8'>
	<base href=" <%=basePath%>"> 
	<link rel="stylesheet" type="text/css" href="css/module.css">
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/module.js"></script>
</head>
  
<body style="marign:0;">
	<div class="wrapper">
		<div id="moduleheader">
			<ul>
				<c:choose> 
					<c:when test="${requestScope.mode=='add'}">
						<li  style="width:100%; text-align:center;"><a onclick="changenav(this)"  href="#add">增加模块</a></li>
					</c:when>
					<c:otherwise>
						<li class="moduleselect"><a  onclick="changenav_info(this); return false" href="#now">当前模块</a></li>
						<li ><a onclick="changenav(this);  return false"  href="#update">修改模块</a></li>
						<li ><a onclick="changenav(this) ; return false"  href="module/${module.m_id}/delete" target="_top">删除模块</a></li>
						<li ><a onclick="changenav_info(this);  return false"  href="#info">模块信息</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div id="modulecontent" >
			<form:form modelAttribute="module" action="module/add" id="moduleform" method="post"> 
					<br/>
					<form:hidden path="m_id"/>
					<label for="m_title" class="modulefont">模块名称</label><br/><br/>
					<form:input  path="m_title" tabindex="1"  id="m_title" maxlength="16" cssClass="moduletext"/>
					<br/><br/>
					<label for="m_desc" class="modulefont">模块描述</label><br/><br/>
					<form:textarea path="m_desc" id="m_desc" cssClass="modulearea"/>
					<br/><br/>
					<span style="display:none" id="recjson">${module.m_reckeys}</span>
					<span style="display:none" id="setjson">${module.m_setkeys}</span>
					<label>参数</label> (需要服务器接收的参数名)<br/><br/>
					<ul id="recul">
						<li><a id="moduleadd" href="javascript:void(0)" onclick="AddKey(this)">添加</a></li>
					</ul>
					<br/>
					<label>配置参数</label> (使用此模块时需要配置的参数，如参数名为user，则代码引用：{set.user})<br/><br/>
					<ul id="setul">
						<li><a id="moduleadd" href="javascript:void(0)" onclick="AddKey(this,'setkeys')">添加</a></li>
					</ul><br/>
					代码 ({projectId}为项目id,{set.***}为***配置参数)<br/><br/>
					<form:textarea path="m_selfcode" id="m_selfcode" cssClass="modulecode"/>
					<br/><br/>
					是否公开
					<form:radiobutton path="m_isopen" value="0" checked="checked"/>私有
					<form:radiobutton path="m_isopen" value="1" />公开<br/>
					<c:if test="${requestScope.mode=='add'}">
						<input type="submit" name="m_submit" value="增加"/>
					</c:if>
			</form:form>
		</div>
		<div id="moduleinfo">
			<table >
					<tr><th>模块名:</th><td>${module.m_title}</td></tr>
					<tr><th>添加时间:</th><td>${module.m_addtime }</td></tr>
					<tr><th>状态:</th>
							<td>
								<c:choose>
									<c:when test="${module.m_isopen==0}">
											私有
									</c:when>
									<c:otherwise>
										公开 
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${module.m_isaudit==0}">
											未审核
									</c:when>
									<c:otherwise>
											审核通过
									</c:otherwise>
								</c:choose>
							</td>
							</tr>
					<tr><th>描述:</th><td>${module.m_desc}</td></tr>
					<tr><th>作者:</th><td>${sessionScope.uname}</td></tr>
					<tr><th>使用次数:</th><td>open in ver 1.1</td></tr>
					<tr><th>收藏次数:</th><td>open in ver 1.1</td></tr>
					<tr><th>接收参数:</th><td><br/><br/><br/><br/>${module.m_reckeys}</td></tr>
					<tr><th>配置参数:</th><td><br/><br/><br/><br/>${module.m_setkeys}</td></tr>
					<tr><th>模块代码:</th><td><br/><br/><br/><br/>${module.m_selfcode}</td></tr>
			</table>
			<br/><br/>
			<br/><br/>
		</div>
	</div>
</body>
</html>