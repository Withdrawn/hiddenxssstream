package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import services.ModuleService;
import services.ShortService;
import tools.SecurityCode;
import tools.SecurityCode.SecuirtyCodeLevel;
import tools.SecurityImage;
import tools.ShortUrlGenerator;

@Controller("publicControler")
public class PublicController
{
	
	@RequestMapping("capthca")
	public void createCapthca(HttpServletRequest req,HttpServletResponse res)
	{
		  res.setHeader("Pragma", "No-cache");
		  res.setHeader("Cache-Control", "No-cache");
		  res.setDateHeader("Expires", 0);
		 
		 res.setContentType("image/jpeg");
		 
			SecurityCode sc=new SecurityCode();
			String word=sc.getSecurityCode(4,SecuirtyCodeLevel.Medium,false);
			System.out.println(word);
			req.getSession().setAttribute("capthcacode", word);
			BufferedImage image=new SecurityImage().createImage(word);
			try {
				ImageIO.write(image,"jpg",res.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@RequestMapping("homepage")
	public String homepage(HttpServletRequest req)
	{
		//找出用户自定义模块
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		ModuleService ms=(ModuleService) context.getBean("moduleService");
		User u=new User();
		String uname=(String) req.getSession().getAttribute("uname");
		u.setU_name(uname);
		List modules=ms.getModuleList(u,false);
		req.setAttribute("modules", modules);
		return "homepage";
	}
}