<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="shortcut icon" href="favicon.jpg" type="image/x-icon">
	
	<style>
	body,div,ul,li,a,img{margin:0; padding: 0;}
	html{font-size: 62.5%;}
	body{font-family: "Open Sans", Arial, "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", "STHeiti", "WenQuanYi Micro Hei", SimSun, sans-serif}
	.fix{position: fixed; top: 0; border-bottom: none !important ;background: #fefefe;box-shadow: 0 1px 3px rgba(0,0,0,0.2); height:80px; width:100%;}
	 .scrolled { background: #fefefe; box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2) }
	 .navinner{width:980px; height:60px; margin: 0 auto; padding-top: 10px;}
	 .navinner ul{list-style-type: none; width: 980px; height: 60px;}
	 .navinner li{width: 100px; height: 60px; float: left;}
	 .navinner li a{width: 100px; height:60px; display: block; line-height:60px; float: left; font-size:2rem; text-decoration: none; color: #51aded; font-weight: bolder; text-align: center;}
	 #logo{float: left; margin-right:50px;}
	 #sddm div
	{	
		position: relative;
		visibility: hidden;

		height: auto;
		width: 100px;
		background: #EAEBD8;
		border: 1px solid #5970B2;
		float: left;
		filter:Alpha(opacity=50);
	}
	#sddm div a
	{
		height:30px; width: 100px;
		font-size: 14px;
		line-height: 30px;
	}
	</style>
	<script>
	window.onscroll = function(){ 
	    var t = document.documentElement.scrollTop || document.body.scrollTop;  
	    var top_div = document.getElementById( "fix" ); 
	 
	   	if(t>0&&top_div.className.indexOf("scrolled")==-1)
	   	{
	   		top_div.className+=' scrolled';
	   	}else if(t==0){top_div.className='fix';}
	} 
	var ddmenuitem=0;
	var timeout=1500;
	var closetimer= 0;
	function mopen(id)
	{	
		ddmenuitem = document.getElementById(id);
		ddmenuitem.style.visibility = 'visible';
		
		document.getElementById("aux").innerHTML="辅&nbsp;助▼";
	}
	function mclose()
	{
			//var order=event.srcElement||event.taget;  
			//	if(order.tagName!='A')
			//	{ onmouselevel代替out   level会把事件对象内当一个整体
				//	}
			if(ddmenuitem) 
				ddmenuitem.style.visibility = 'hidden';
			document.getElementById("aux").innerHTML="辅&nbsp;助◄";
		}

	function mclosetime()
	{
		closetimer = window.setTimeout(mclose, timeout);
	}
	function mcancelclosetime()
	{
		if(closetimer)
		{
			window.clearTimeout(closetimer);
			closetimer = null;
		}
	}
	</script>

</head>
<body>
	<div id="fix" class="fix">
		<div class="navinner">
			<span id="logo">
				<img src="images/logo.png" alt="HiddenXss">
			</span>
			<ul id="sddm">
				<li><a href="javascript:void(0)">首&nbsp;页</a></li>
				<li><a href="javascript:void(0)">记&nbsp;忆</a></li>
				<li><a href="javascript:void(0)">小知识</a></li>
				<li><a href="javascript:void(0)">寻访利器</a></li>
				<li><a href="aa" id="aux" onmouseover="mopen('m1')"  onmouseout="mclosetime()">辅&nbsp;助◄</a>
					<div id="m1" onmouseover="mcancelclosetime()" onmouseleave="mclose()">
						<a href="short">短域名</a>
						<a href="#">社工库</a>
						<a href="#">加解密</a>
						<a href="#">笔记</a>
						<a href="#" ></a>
					</div>
				</li>
				<li><a href="javascript:void(0)">吃货榜</a></li>
			</ul>
		</div>
	</div>
	
</body>
</html>