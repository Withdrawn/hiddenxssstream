package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import services.ShortService;
import tools.ShortUrlGenerator;

@Controller("shortControler")
public class ShortController 
{
	@Autowired
	private ShortService ss;
	
	@RequestMapping(value="short",method=RequestMethod.POST)
	public String createShort(@RequestParam String long_url,@RequestParam String defineurl,HttpServletRequest req)
	{
		if(defineurl.length()>0)
		{
			String msg=ss.checkDefine(long_url, defineurl);
			if(msg!=null)
			{
				req.setAttribute("msg",msg);
			}else
			{
				req.setAttribute("convented", defineurl);
			}
		}else{
			String[] temp=new ShortUrlGenerator().shortUrl(long_url);
			String str=ss.createUrl(temp[0],long_url);
			req.setAttribute("convented",str);
		}
		int tempcount=ss.getShortCount();
		req.setAttribute("shortcount",tempcount);
	
		return "short";
	}
	@RequestMapping(value="short",method=RequestMethod.GET)
	public String shortPage(HttpServletRequest req)
	{
		//取得收藏本站短网址数
		int temp=ss.getShortCount();
		req.setAttribute("shortcount",temp);
		return "short";
	}
	
	@RequestMapping(value="recovery",method=RequestMethod.GET)
	@ResponseBody
	public String createShort(@RequestParam String short_url,HttpServletRequest req)
	{
		String[] urls=short_url.split("/");
		String temp=urls[urls.length-1];
		temp=ss.recoverUrl(temp);
		return  temp;
	}
	@RequestMapping(value="**",method=RequestMethod.GET)
	public String forward(HttpServletRequest req)
	{
		System.out.println(req.getRequestURI());
		String[] urls=req.getRequestURI().split("/");
		String temp=urls[urls.length-1];
		//temp>=6为shorturl 等于3 且为rec时  为接收参数
		if(temp.equals("rec"))
		{
			System.out.println("receive a session");
			String authcode="";
			
			if(urls.length>2)
			{
				authcode=urls[urls.length-2];
				System.out.println(authcode);
				authcode=ss.recoverUrl(authcode);
				authcode=authcode.substring(authcode.lastIndexOf("/")+1);
			}
			System.out.println(authcode);
			return "forward:/project/"+authcode+"/rec"; //参数接收   此处authcode为shorturl
		}
		String longurl=ss.recoverUrl(temp);
		String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
		String authcode=longurl.substring(longurl.lastIndexOf("/")+1);
		if(longurl.contains(basePath)&&authcode!=null&&authcode.length()==32)
		{
			//返回xss代码
			return "forward:/project/"+authcode+"/getcode";
		}else{
			return  "redirect:http://"+longurl;	//外部网址
		}
	}
}