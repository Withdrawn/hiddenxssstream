<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="springform"  %>
<%@ taglib prefix="c" uri="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>项目</title>
	<base href=" <%=basePath%>"> 
	<style>
	body{font-size:14px; color:#c8e1fa;}
	a{color:#0066cc; font-size: 16px;}
	fieldset{background:#265380; border:0px;}
	legend{font-weight: bolder; color:#51aded; font-size:16px; }
	.projecttext{border: 1px solid #bbb; width:300px; padding:5px;}
	.projectarea{ height:80px; padding:5px; resize: none; width:300px;}
	.projectcode{resize: none; width:700px; height:250px;}
	</style>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
		function ShowContent(id,o){
			if($("#"+id).css("display")=="none"){
				$("#"+id).show();
				$(o).html("折叠");
			}else{
				$("#"+id).hide();
				$(o).html("展开");	
			}
		}	
	</script>
</head>
<body>	
	<div class="wrapper">
		<form:form modelAttribute="project" action="project/add" id="projectform" method="post"> 
		  <fieldset>
		    <legend>我的项目</legend>
		    <br/>
		     <span style="float:left;">项目名称:</span>&nbsp;
		    <form:input  path="p_title" tabindex="1"  id="p_title" maxlength="16" cssClass="projecttext"/>
		    <br/><br/>
		    <span style="float:left;">项目描述:</span>&nbsp;
		    <form:textarea path="p_desc" id="p_desc" cssClass="projectarea"/>
		    <br/><br/>
		    模块配置:
		    		<ul id="modulelist">
		    			<c:forEach var="module" items="${modules}">
		    				<li>
		    						<input onclick="if(this.checked){$('#mset_'+this.value).show()}else{ $('#mset_'+this.value).hide() }" type="checkbox" name="checkmodule" value="${module.m_id}"/>
		    						&nbsp;${module.m_title}&nbsp;<a onclick="ShowContent('m_${module.m_id}',this)" href="javascript:void(0)">展开</a>
		    						<div id="mset_${module.m_id}" style="display:none">
		    					
		    						<c:if test="${module.m_setkeys!=null}">
			    						需要配置的参数<br/>
			    						<script>
			    							var setstr=${module.m_setkeys};
			    							var arrays=eval(setstr);
			    							for(var i=0;i<arrays.length;i++)
			    							{
			    								var txt=arrays[i];
			    								document.write(txt+":<input type='text' name='m_"+${module.m_id}+"_"+txt+"' /><br/>");
			    							}
			    							
			    						</script>
			    					</c:if>
		    						</div>
		    						<ul id="m_${module.m_id}" style="display:none">
		    							<li>
		    								参数:<br/>
		    								${module.m_reckeys}
		    							</li>
		    							<li>代码:<br/>
		    								<pre>${module. m_selfcode}</pre>
		    							</li>
		    						</ul>
		    				</li>
		    			</c:forEach>
		    		</ul>
		    自定义代码:<br/><br/>
		    	<div style="width:30px; height:30px; float:left;"></div><form:textarea path="p_code" id="p_code" cssClass="projectcode"/>
		    	<form:hidden path="p_modulesetkeys"/>
		    <br/>
		    <input type="submit" value="创建"/>
		  </fieldset>
		</form:form>
	</div>
</body>
</html>