package controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import model.Module;
import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ModuleService;

@Controller
@RequestMapping("module")
public class ModuleController
{
	@Resource(name="moduleService")
	private ModuleService ms;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String moduleIndex(HttpServletRequest req)
	{
		req.setAttribute("mode", "add");
		req.setAttribute("module",new Module());
		return "module";
	}
	@RequestMapping(value="{mId}",method=RequestMethod.GET)
	public String module(@PathVariable Integer mId,HttpServletRequest req)
	{
		System.out.println(mId);
		Module m=ms.getModuleById(mId);
		req.setAttribute("module", m);
		return "module";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ModelAndView addModule(@Valid @ModelAttribute("module")Module m,BindingResult br,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView("module");
		String[] parmaters = (String[]) req.getParameterValues("keys");

		String[] parmaters2 = (String[]) req.getParameterValues("setkeys");
		String uname=(String) req.getSession().getAttribute("uname");
		ms.insertModule(m,parmaters,parmaters2,uname);
		mv.addObject(m);
		mv.addObject("modules",  getModuleList(req,false));
		 return mv;
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ModelAndView updateModule(@Valid @ModelAttribute("module")Module m,BindingResult br,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView("module");
		
		String[] parmaters = (String[]) req.getParameterValues("keys");
		String[] parmaters2 = (String[]) req.getParameterValues("setkeys");
		int u_id=(Integer) req.getSession().getAttribute("u_id");
		
		m=ms.updateModule(m,parmaters,parmaters2,u_id);
		if(m==null)
		{
			req.setAttribute("msg","修改失败");
			return mv;
		}
		mv.addObject(m);
		mv.addObject("modules",  getModuleList(req,false));
		req.setAttribute("msg","修改成功");
		return mv;
	}
	@RequestMapping(value="{mId}/delete",method=RequestMethod.GET)
	public String deleteModule(@PathVariable Integer mId,HttpServletRequest req)
	{
		boolean flag=false;

		int u_id=(Integer) req.getSession().getAttribute("u_id");

		flag=ms.deleteModuleById(u_id, mId);
		if(flag)
		{
			req.setAttribute("mode", "add");
			req.setAttribute("module",new Module());
			req.setAttribute("msg","模块删除成功");
		}else{
			req.setAttribute("msg","模块删除失败");
		}
		
		req.setAttribute("modules", getModuleList(req,false));
		return "homepage";
	}
	
	public List<Module> getModuleList(HttpServletRequest req,boolean pub)
	{
		User u=new User();
		u.setU_name((String)req.getSession().getAttribute("uname"));
		List<Module> modules=ms.getModuleList(u,pub);
		return modules;
	}
}