function IsURL(str_url){
        if(str_url.indexOf('.')==-1)
            return false;
        var strRegex = "^((https|http)?://)"
        + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
        + "|" // 允许IP和DOMAIN（域名）
        + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
        + "[a-z]{2,6})" // first level domain- .com or .museum
        + "(:[0-9]{1,4})?" // 端口- :80
        //+ "((/?)|" // a slash isn't required if there is no file name
        + "(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        var re=new RegExp(strRegex);
        //re.test()
        if (re.test(str_url)){
            return (true);
        }else{
            return (false);
        }
}
function IsShort(str_url)
{
	if(str_url.indexOf('/')==-1||str_url.indexOf('.')==-1)
            return false;
    var splits=str_url.split("/");
    var s=splits[splits.length-1];
    console.log(s);
    if(s.length!=6&&s.length!=7){
        alert('不是有效的短网址');
        return false;   
    }
    else
        return true;
}