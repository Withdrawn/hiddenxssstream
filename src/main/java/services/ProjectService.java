package services;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import model.Module;
import model.Project;
import model.User;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tools.MD5Util;
import tools.ShortUrlGenerator;

import dao.ModuleDao;
import dao.ProjectDao;
import dao.ShortDao;
import dao.UserDao;

@Service("projectService")
public class ProjectService
{
	@Resource(name="projectDao")
	private ProjectDao projectDao;
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="moduleDao")
	private  ModuleDao moduleDao;
	@Resource(name="shortDao")
	private ShortDao shortDao;
	@Transactional(readOnly=true)
	public List<Project> projectIndex(User u)
	{
		u=userDao.getIdByName(u.getU_name());
		List<Project> prolist=projectDao.getProjectList(u);
		return prolist;
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
	public Project insertProject(Project p,HttpServletRequest req,String[] checkms)
	{
		
		//模块要配置的参数转成json string
		String jsonstr=p.getP_modulesetkeys();
		ObjectMapper objectMapper = new ObjectMapper();  
		
		 try {
			Map<String, String> maps = objectMapper.readValue(jsonstr, Map.class);
			maps=generateMap(maps, req);
			p.setP_modulesetkeys(objectMapper.writeValueAsString(maps));
		} catch (Exception e) {
			e.printStackTrace();
		}
		 //选择的模块
		 if(checkms!=null)
		 {
			 p.setP_modules(new HashSet<Module>());
			 for(int i=0;i<checkms.length;i++)
			 {
				 Module m=moduleDao.loadModuleById(Integer.parseInt(checkms[i]));	 
				 p.getP_modules().add(m);
			 }
		 }
		 //创建者
		 Integer u_id=(Integer) req.getSession().getAttribute("u_id");
		 p.setUserid(userDao.loadUserById(u_id));
		 p.setP_addtime(new Timestamp(new Date().getTime()));
		 //auth code
		 p.setAuthcode(new MD5Util().MD5(new Date().getTime()+""));
		 
		 //url key
		 
		String url= new ShortUrlGenerator().shortUrl(new Date().getTime()+"")[0];
		
		String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
		String orgurl=basePath+p.getAuthcode();
		url=shortDao.shortExist(url, orgurl);
		p.setP_urlkey(url);
		projectDao.insertProject(p);
		//没有关联 url 与project 所以就先使用了project里的authcode
		 
		return p;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
	public boolean deleteProjectById(int u_id,int p_id)
	{
		//check if this project belong login user
		Project p=projectDao.findProjectById(p_id);
		if(p!=null&&p.getUserid().getU_id()!=u_id)
			return false;
		return projectDao.deleteProjectById(p);
		
	}
	@Transactional(readOnly=true)
	public Project showProjectDetail(int u_id,int p_id)
	{
		Project p=projectDao.getProjectDetail(p_id);
		if(p==null&&p.getUserid().getU_id()!=u_id)
			return null;
		else
			return p;
	}
	@Transactional(readOnly=true)
	public String getProjectCode(Project p)
	{
		String code="";
		//将需要项目中需要设置的模块参数转成 map   模块名_参数名 value  为一个实体
		if(p!=null&&!p.getP_modulesetkeys().equals(""))
		{
			ObjectMapper objectMapper = new ObjectMapper();  
			Map<String, String> setmaps=new HashMap<String, String>();
			try {
				setmaps = objectMapper.readValue(p.getP_modulesetkeys(), Map.class);
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			//格式     模块名_参数名 value	
			Set<Module> modules=p.getP_modules();
			Iterator iterator=modules.iterator();
			while(iterator.hasNext())
			{
				Module m=(Module) iterator.next();
				code+=m.getM_selfcode();
				//对参数进行替换
				String[] moduleps=null;
				try {
					if(m.getM_setkeys()!=null&&!m.getM_setkeys().equals(""))
						moduleps=objectMapper.readValue(m.getM_setkeys(),String[].class);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				if(moduleps!=null)
				{
					for(String pstr:moduleps)
					{
						System.out.println(pstr);
						code=code.replaceAll("\\{set."+pstr+"\\}",setmaps.get(m.getM_id()+"_"+pstr));
					}
				}
			}
			// add project self code
			code+=p.getP_code();
		}
		// replace {projectId}
		code=code.replaceAll("\\{projectId\\}",p.getP_id()+"");
		
		return code;
	}
	@Transactional(readOnly=true)
	public Project getProjectByCode(String authcode)
	{
		Project p=projectDao.getProjectByCode(authcode);
		return p;
	}
	public Map<String,String> generateMap(Map<String,String> maps,HttpServletRequest req)
	{
		Map<String,String> map=new HashMap<String, String>();
		Set<String> key = maps.keySet();
        Iterator<String> iter = key.iterator();
        while(iter.hasNext())
        {
        	String mid=iter.next();
        	String[] properties=maps.get(mid).split(",");
        	for(int i=0;i<properties.length;i++)
        	{
        		String value= req.getParameter("m_"+mid+"_"+properties[i]);
        		if(value!=null&&!value.equals(""))
        			map.put(mid+"_"+properties[i],value);
        	}
        }

		return map;
	}
	
}