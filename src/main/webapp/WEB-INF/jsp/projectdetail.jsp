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
	 <base href=" <%=basePath%>"> 
	<style>
	table,body,caption,div,td,tr,ul,li{margin:0;padding:0;}
	body{font-size:14px; }
	a{color:#0066cc; font-size: 16px; text-decoration: none;}

	#wrapper{width:100%; height:auto;}
	#detailheader {width:100%; height:auto; }
	#detailheader  table{width:100%; height:auto; background:#c8e1fa;}
	#detailheader caption{width:100%; height:80px; background:#224b73;  text-align:left;padding: 4px 7px 4px 5px;}
	#detailheader caption a{float:right; font-size:12px;text-decoration:underline;  margin-left:3px; margin-right:3px;  text-align:center;width:70px; height:20px ; line-height:20px; display:block; cursor: pointer;color: #c8e1fa;}
	#detailheader thead{display: table-header-group;}
	#detailheader thead th{text-align:left;}
	#detailheader tbody{color: #224b73;}
	#detailheader tbody a{font-size:12px;}
	#detailheader ul{margin:0; width:220px; overflow:scroll-x; word-break:break-all}
	.ohidden ul { height:18px; overflow:hidden }
	a.oall,a.un { text-decoration:none }
	td { vertical-align:top }
	</style>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
$(document).ready(function(){
	$("a.oall").click(function(){
		if($(this).attr("class")=="oall"){
			$("table tbody tr").attr("class","");
			$("a.un").html("-折叠");
			$(this).attr("class","uall");
			$(this).html("-全部");	
		}else{
			$("table tbody tr").attr("class","ohidden");
			$("a.un").html("+展开");
			$(this).attr("class","oall");
			$(this).html("+全部");	
		}
	});
	$("a.un").click(function(){
		if($(this).parent().parent().attr("class")=="ohidden"){
			$(this).parent().parent().attr("class","");
			$(this).html("-折叠");
		}else{
			$(this).parent().parent().attr("class","ohidden");
			$(this).html("+展开");	
		}
	});
});
function Delete(id,obj,token){
	if(confirm("确定删除吗?")){
		$.post('/index.php?do=project&act=delcontent&r='+Math.random(),{'id':id,'token':token},function(re){
			if(re==1){
				$(obj).parent().parent().remove();
			}
		});
	}
}
function MutiDelete(){
	if(confirm("确定删除选中的内容吗?")){
		var ids=[];
		$.each($(".checon"),function(k,v){
			if($(v).is(":checked")) ids.push($(v).val());
		});
		$.post('/index.php?do=project&act=delcontents&r='+Math.random(),{'ids':ids.join("|"),'token':$("#token").val()},function(re){
			if(re==1){
				$(".checon").parent().parent().remove();
			}
		});
	}
}
function CheckAll(obj){
	if($(obj).is(":checked")){
		$(".checon").attr("checked","checked");
	}else{
		$(".checon").removeAttr("checked");
	}
}
	</script>
</head>
<body>
<div class="wrapper">
	<div id="detailheader">
		<table>
			<caption align="top">
				<h3>项目名称:<a>配置</a><a href="viewcode">查看代码</a></h3>
			
				Domain:<select><option value="">全部</option></select>		 			时间<select><option value="">1小时前</option></select>	
			</caption>
			<thead>
				 <tr>
					<th width="20"><input type="checkbox" id="checkall" onclick="CheckAll(this)"></th>
					<th width="40"><a style="font-size:14px;" class="oall" href="javascript:void(0)">+全部</a></th>
					<th width="120">时间</th>
					<th width="220">接收的内容</th>
					<th  width="220">Request Headers</th>
					<th width="30">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr class="ohidden">
					<td width="20"><input type="checkbox" class="checon" value=""></td>
					<td  width="40"><a href="javascript:void(0)"  class="un">+展开</a></td>
					<td width="120">2014-10-30 00:09:47</td>
					<td width="220"> 
						<ul>
							<li>location:</li>
							<li>toplocation:</li>
							<li>cookie:</li>
							<li>opener:</li>
						</ul>
					</td>
					<td width="220">
						<ul>
							<li>REFERER</li>
							<li>USER_AGENT</li>
							<li>REMOTE_ADDR</li>
						</ul>
					</td>
					<td width="30"><a href="content/delete" onclick="return confirm('确定删除吗?');">删除</a></td>
					
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>