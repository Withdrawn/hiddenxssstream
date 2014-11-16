package services;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import model.Content;
import model.Module;
import model.Project;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;



import tools.MD5Util;
import vo.ContentVo;


import dao.ContentDao;


@Service("contentService")
public class ContentService
{
	@Resource(name="contentDao")
	private ContentDao cdao;
	
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
	public void saveContent(Project p,HttpServletRequest req)
	{
		Content c=new Content();
	
		c.setC_project(p);		
		//普通属性
		c.setC_sercontent(getHttpHeader(req));
		
		//模块属性
		if(p==null)
			return ;
		Set<Module> modules=p.getP_modules();
		Iterator<Module> iterator=modules.iterator();
		ObjectMapper objectMapper = new ObjectMapper();  
		Map<String,String> paras=new HashMap<String,String>();
		while(iterator.hasNext())
		{
			Module m=(Module) iterator.next();
			String[] moduleps={};
			if(m.getM_reckeys()!=null&&!m.getM_reckeys().equals(""))
			{
					try {
						moduleps=objectMapper.readValue(m.getM_reckeys(),String[].class);
					} catch (Exception e) {
						e.printStackTrace();
					} 
				for(String s:moduleps)
				{
					paras.put(s,req.getParameter(s));
				}
			}
		}
		String c_content=null;
		try {
			c_content = objectMapper.writeValueAsString(paras);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		c.setC_content(c_content);
		c.setC_addtime(new Timestamp(new Date().getTime()));
		//set doamin
		String referer=req.getHeader("referer");
		if(referer != null &&referer.length() > 0)
		{
			String[] temps=referer.split("/");
			if(temps.length>0)
				c.setC_domain(temps[0]);
		}
		//use a md5 to flag a content    (flag=md5(p_id+getQueryString+domain)) think a method to avoid repeat insert of content 
		String md5=new MD5Util().MD5(p.getP_id()+req.getQueryString()+c.getC_domain());
		c.setC_cookiehash(md5);
		
		cdao.saveContent(c);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<ContentVo> getContentsByProject(Project p,int page,int pagenum)
	{
		List<Content> contents=cdao.getContentsByProject(p, page, pagenum);
		System.out.println("容量"+contents.size());
		// convent to vo
		List<ContentVo> cvs=new ArrayList<ContentVo>(contents.size());
		ObjectMapper objectMapper=new ObjectMapper();
		Map<String, String> maps =null;
		Field[] fields=new ContentVo().getClass().getDeclaredFields();
		for(Content c:contents)
		{
			try {
				//save type is map so i can't convent directly finally add self define property to this vo
				maps= objectMapper.readValue(c.getC_sercontent(), Map.class);
				 ContentVo cv=new ContentVo();
				 for(Field field:fields)
				 {
					 field.setAccessible(true);
					 //get value from map then set to object
					 field.set(cv, maps.get(field.getName()));
				 }
				 cvs.add(cv);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(cvs.size());
		return cvs;
	}
	
	public String getHttpHeader(HttpServletRequest req) 
	{
		//referer host useragent  ip  cookie
		Map<String,String> headers=new HashMap<String,String>();
		Enumeration<?> names = req.getHeaderNames();
		String temp="";
		while(names.hasMoreElements())
		{
			temp=(String) names.nextElement();
			
			// replace quot
			String value=req.getHeader(temp);
			value.replaceAll("\"","&quot;");
			value.replaceAll("[\\[|\\]]","");  //replace [ or ]
			if(temp.equals("user-agent"))
				temp="useragent";
			headers.put(temp,value);
		}
		// get ip
		headers.put("remote_addr",getAddr(req));
		//get referer
		if(req.getHeader("Referer")!=null)
			headers.put("referer",req.getHeader("Referer"));
		//location
		String tempstr=req.getParameter("location");
		if(tempstr != null &&tempstr.length() > 0)
			headers.put("location",tempstr);
		//toplocation
		tempstr=req.getParameter("toplocation");
		if(tempstr != null &&tempstr.length() > 0)
			headers.put("toplocation",tempstr);
		//opener
		tempstr=req.getParameter("opener");
		if(tempstr != null &&tempstr.length() > 0)
			headers.put("opener",tempstr);
		ObjectMapper objectMapper = new ObjectMapper();  
		try {
			temp=objectMapper.writeValueAsString(headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	public String getAddr(HttpServletRequest request){
			String ip=request.getHeader("x-forwarded-for");
	       if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
	         ip=request.getHeader("Proxy-Client-IP");
	       }
	        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
	         ip=request.getHeader("WL-Proxy-Client-IP");
	       }
	       if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
	         ip=request.getRemoteAddr();
	       }
	     return ip;
	}
}