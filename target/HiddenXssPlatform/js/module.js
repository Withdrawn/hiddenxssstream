	function changenav(num)
	{
	lis=num.parentNode.parentNode.childNodes;//ul
	for(var i=0;i<lis.length;i++)
		lis[i].className="";
	
		num.parentNode.className="moduleselect";	
		if(num.getAttribute("href")=="#update"){
			if(confirm("确定修改？"))
			{
				$("#moduleform").attr("action","module/update");
				$("#moduleform").submit();
			}
		}
	}
	function changenav_info(num){
		lis=num.parentNode.parentNode.childNodes;//ul
		for(var i=0;i<lis.length;i++)
			lis[i].className="";
		
			num.parentNode.className="moduleselect";
			var type=num.getAttribute("href");
			console.log(type);
			if(type=="#info")
			{
				$('#modulecontent').css('display','none');
				$('#moduleinfo').css('display','block');
			}else if(type=="#now"){
				$('#modulecontent').css('display','block');
				$('#moduleinfo').css('display','none');
			}
	}
	function AddKey(obj,keyname){
		var liObj=document.createElement("li");
		$(obj).parent().before(liObj);
		var input=document.createElement("input");
		$(liObj).append(input);
		var btn=document.createElement("input");
		$(liObj).append(btn);
		$(liObj).append(document.createTextNode(" "));
		btn.type="button";
		$(btn).val("添加");
		$(liObj).append(document.createTextNode(" "));
		var del=document.createElement("a");
		$(liObj).append(del);
		$(del).attr("href","javascript:void(0)");
		$(del).html("删除");
		$(btn).click(function(){
			var txt=$(input).val();
			if(txt==""){
				alert("请输入参数名");
			}else{
				$(input).remove();
				$(btn).remove();
				var checkObj=document.createElement("input");
				$(del).before(checkObj);
				checkObj.type="checkbox";
				checkObj.checked="checked";
				var keyName=keyname!=null ? keyname : "keys";
				$(checkObj).attr("name",keyName);
				$(checkObj).attr("value",txt);
				$(del).before(document.createTextNode(" "+txt+" "));
			}
	});
	$(del).click(function(){
		$(liObj).remove();
	});
}
function createLis(arrays,name)
{
	for(var i=0;i<arrays.length;i++)
	{
		var txt=arrays[i];

		var liObj=document.createElement("li");
		var checkObj=document.createElement("input");
		checkObj.type="checkbox";
		checkObj.checked="checked";
		$(liObj).append(checkObj);
		$(checkObj).attr("name","keys");
		$(checkObj).attr("value",txt);
		$(liObj).append(document.createTextNode(" "+txt+" "));
		if(name=="keys")
			$("#recul").prepend(liObj);
		else
			$("#setul").prepend(liObj);
	}
}
function initParams()
{

	/*初始化参数的li*/
	var recs=$.trim($("#recjson").text());
	var sets=$.trim($("#setjson").text());
	var arrays;
	if(recs.length>0)
	{
		arrays=eval(recs);
		createLis(arrays,"keys");
	}
	if(sets.length>0)
	{
		arrays=eval(sets);
		createLis(arrays,"setkeys");
	}
	
}
window.onload=function()
{
	initParams();
}
