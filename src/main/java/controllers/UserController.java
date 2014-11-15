package controllers;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import services.UserService;



import model.User;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Resource(name="userService")
	private UserService us;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginByGet()
	{
		ModelAndView mv=new ModelAndView("index");
		mv.addObject(new User());
		return mv;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginByPost(@Valid @ModelAttribute("user")User u,BindingResult br,HttpServletRequest req,HttpServletResponse res)
	{
		String code=req.getParameter("u_code");
		
		ModelAndView mv=new ModelAndView("index");
		System.out.println(u.getU_name());
		
		if(br.hasErrors())
		{
			System.out.println("产生错误 ");
			return mv;
		}
		String temp=us.userLogin(u,req);
		if(temp.equals("fine"))
		{
			req.getSession().setAttribute("check","1");
			req.getSession().setAttribute("uname",u.getU_name());
			req.getSession().setAttribute("u_id",u.getU_id());
			
			Cookie cookie = new Cookie("xss_uname",u.getU_name());
			Cookie cookie2=new Cookie("xss_upass",u.getU_pass());
			cookie.setPath("/");
			cookie2.setPath("/");
			cookie2.setMaxAge(604800);
		    cookie.setMaxAge(604800);//保留7天  60*60*24*7
		    res.addCookie(cookie); 
		    res.addCookie(cookie2);
		    //httponly 还没使用
		    mv.setView(new RedirectView("../homepage"));
		    
		    return mv;
		}
		
		mv.addObject("errormsg", temp);
		
		return mv;
	}
	@RequestMapping(value="/userdataJson",method=RequestMethod.GET)
	@ResponseBody
	public User getUserJsonData(@RequestParam String id)
	{
		//ObjectMapper mapper = new ObjectMapper(); 
		
		System.out.println(id);
		User u=new User();
	
		u.setU_id(Integer.valueOf(id));
		System.out.println(u.getU_id());
		return u;
	}
	
	@RequestMapping(value="/updateUserData",method=RequestMethod.POST)
	public String updateUserData(@RequestParam(value = "photo", required = false) MultipartFile file, HttpServletRequest request, ModelMap model)
	{
		String path = request.getSession().getServletContext().getRealPath("upload");  
		String fileName = file.getOriginalFilename();  
//      String fileName = new Date().getTime()+".jpg";  
      System.out.println(path);  
      File targetFile = new File(path, fileName);  
      if(!targetFile.exists()){  
          targetFile.mkdirs();  
      }  

      try {  
          file.transferTo(targetFile);  
      } catch (Exception e) {  
          e.printStackTrace();  
      }  
      model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  

      return "userData";  
	}
	
	@RequestMapping(value="/updateUserData",method=RequestMethod.GET)
	public String updateUserData()
	{
		
      return "userData";  
	}
	@RequestMapping(value="/insertUser",method=RequestMethod.GET)
	public String insertUserData(HttpServletRequest req)
	{
		User u=new User();
		u.setU_name("aaaaaa");
		u.setU_pass(u.MD5("xssuser1"+u.getSalt()));
		System.out.print(u.getU_pass().length());
		u.setU_mail("a");
		Timestamp ts=new Timestamp(new Date().getTime());
		u.setU_regtime(ts);
		u.setU_flag("a");
		u.setU_lastip("a");
		u.setU_nick("a");
		u.setU_tries(Integer.getInteger("0"));
		
		String result=us.insertUser(u);
		req.setAttribute("errormsg",result);
		return "userData";
	}
}