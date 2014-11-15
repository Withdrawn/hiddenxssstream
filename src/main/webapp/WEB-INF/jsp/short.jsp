<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="c"  %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Hidden Xss Platform</title>
	<script src="js/jquery-1.9.1.min.js"></script>
	 <script src="js/check.js"></script>
	<link rel="stylesheet" type="text/css" href="css/short.css">
	<script>
        function checkShortForm(oform)
        {
            var divid="#"+oform.parentNode.id;
            var shortvalue=$("#inputshort").val();
            if(shortvalue!=""&&(shortvalue.length<6||shortvalue.length>7))
            {
            	alert('自定义的网址不正确');
            	return false;
            }
            if(IsURL($(divid+" #inputurl input").val()))
                return true;
            else
            {
                alert('网址不合法');
                return false;
            }
        }
    </script>
</head>
<body>
  <jsp:include page="nav.jsp"></jsp:include>
     <div id="wrap">

        <div id="content">
            <h1 style="font-family:Pmingliu;">xss 短网址<span  class="font">当前收藏</span><span class="num">${requestScope.shortcount }</span><span class="font">个</span></h1>
    	<div class="tabs" >
            <ul id="tabs">
                <li class="tab-nav-action">生成短网址</li>
                <li class="tab-nav">其它短网址</li>
                <li class="tab-nav">网址还原</li>
            </ul>
        </div>
        <div id="tabs-body" class="tabs-body">
            <div style="display:block" id="div1">
                <form action="short" method="post" onsubmit="return checkShortForm(this)">
                    输入长网址:&nbsp;&nbsp;<br/>
                        <div id="inputurl">
                            <input type="text" name="long_url" maxlength="100">
                        </div>
                    <br/>
                    自定义:&nbsp;http://xx.cn/<input id="inputshort" type="text" name="defineurl" size="10"  maxlength="6">字母数字(6位)<br/><br/>
                    <div style="width:400px; marign:0 auto; height:40px;">
                        <input type="submit" value="生成" name="send" style="float:right;">    
                    </div>
                      <c:if test="${convented!=null}">
                      <span>短网址：
                        <script >
	                        host = window.location.host;
	                        document.write(host);
	                        </script>/HiddenXssPlatform?${convented}<br/><a href="javascript:void(0)" >复制</a>
                        </span>
                        </c:if>
                        ${msg }
                </form>
            </div>
            <div style="display:none" id="div2">
                  其他短网址
                    <form action="">
                        <input type="radio" value="baidu.com" name="x" checked=checked> 百度
                        <input type="radio" value="baidu.com" name="x"> 新浪
                        <input type="radio" value="baidu.com" name="x"> 腾讯
                        <input type="radio" value="baidu.com" name="x"> qoiob
                        <br/>
                        输入长网址:&nbsp;&nbsp;
                        <div id="inputurl">
                            <input type="text" name="long_url" maxlength="100">
                        </div>
                        <br/>
                        <div style="width:400px; marign:0 auto; height:40px;">
                           <input type="submit" value="还原网址" name="send" style="float:right;">    
                        </div>
                    </form>   
            </div>
            <div style="display:none" id="div3">
                   <form action="javascript:void(0)">
                        请输入短网址:<br/>
                        <div id="inputurl">
                            <input type="text" name="short_url"  id="short_url" maxlength="100">
                        </div>
                        <br/>
                        <div style="width:400px; marign:0 auto; height:40px;">
                           <input type="submit" value="还原网址" name="send" id="recovery"style="float:right;">    
                        </div>
                      	<span id="shortmsg">
                      		
                      	</span>
                    </form>
            </div>
        </div>
        </div>
    </div>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#tabs li").bind("click", function () {
                var index = $(this).index();
                var divs = $("#tabs-body > div");
                $(this).parent().children("li").attr("class", "tab-nav");//将所有选项置为未选中
                $(this).attr("class", "tab-nav-action"); //设置当前选中项为选中样式
                divs.hide();//隐藏所有选中项内容
                divs.eq(index).show(); //显示选中项对应内容
            });
        });
        $("#recovery").click(function(){
        	if(IsShort($("#short_url").val()))
        	{
        			$.ajax({
			        type: "GET",
			        url: "recovery?short_url="+$("#short_url").val(), 
			        contentType: "application/json; charset=utf-8",
			        data:"",
			        dataType: "html",
			        success: function (result,textStatus) {
			       		if(result!='null')
			      		   $("#shortmsg").text(result);
			      		else
			      		$("#shortmsg").text("无法还原该短网址");
			        }
		      });
        	}else
        	{
        		alert('网址不合法');
        	}
        });
    </script>
</body>
</html>

