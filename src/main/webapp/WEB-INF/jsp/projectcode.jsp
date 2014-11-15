<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>项目</title>
	<style>
	table,h3,body,caption,div,td,tr,textarea{margin:0;padding:0;}
	span{
		 background-color: #F8F8F8;
	    border: 1px solid #CCCCCC;
	    color: #333333;
	    display: block;
	    font-family: Lucida Console,Courier New,Courier,mono,monospace;
	    font-size: 12px;
	    line-height: 18px;
	    margin: 0 auto;
	    overflow: auto;
	    padding: 4px 8px;
	    word-wrap: break-word;
	}
	</style>
</head>
<body>
	<div class="wrapper">
		<h3>项目名称:${p.p_title }</h3>
		<p>
			<label>项目代码:</label>
			<span>${allcode}</span>
		</p>
		<label>如何使用：</label>
		<p>将如下代码植入怀疑出现xss的地方（注意'的转义），即可在 <a href="<%=basePath%>/project/${p.p_id}">项目内容</a> 观看XSS效果。</p>
		<span>
			${codeshow1 }
		</span>
		<p>
或者
</p>
<p>
<span>
${codeshow2 }
</span>
</p>

<p>
再或者以你任何想要的方式插入
</p>

<p>
<span>
<%=basePath%>${p.p_urlkey}
</span>
</p>
<p>
参数接收地址
<br/>
<span>
<%=basePath%>${p.p_urlkey}/rec?参数1=xx&参数2=yy
</span>
</p>
	</div>
</body>
</html>