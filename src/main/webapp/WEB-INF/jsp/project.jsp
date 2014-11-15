<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="c"%>
<%@ taglib prefix="fn" uri="fn"%>
<%@ taglib prefix="fmt" uri="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta charset='utf-8'>
	<base href=" <%=basePath%>"> 
	<link rel="stylesheet" type="text/css" href="css/project.css">
</head>
<body>
	<div class="wrapper">
		<div id="proheader">
			<h5>我的项目</h5><a href="project/add">创建项目</a>
		</div>
		<div id="procontent">
			<table >
				<thead>
				<tr>
					<th width="200">项目名称</th>
					<th width="300">项目描述</th>
					<th width="100">内容数</th>
					<th width="100">创建时间</th>
					<th width="50">操作</th>
				</tr>
				</thead>
				<tbody id="probody">
					<c:forEach var="pro" items="${prolist}">
					<tr>
						<td><a href="project/${pro.p_id}/detail">${pro.p_title}</a></td>
						<td style="width:300px;">${pro.p_desc}</td>
						<td>${fn:length(pro.p_contents)}</td>
						<td><fmt:formatDate value="${pro.p_addtime}" type="date" dateStyle="medium"/></td>
						<td><a href="project/${pro.p_id}/delete">删除</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<script>
				var TbRow = document.getElementById("probody");
				if (TbRow != null)
				{
					for (var i=0;i<TbRow.rows.length ;i++ )
					{
						if (TbRow.rows[i].rowIndex%2==1)
							TbRow.rows[i].style.backgroundColor="#2b6666";
						else
							TbRow.rows[i].style.backgroundColor="";
					}
				}
			</script>
		</div>
	</div>
</body>
</html>