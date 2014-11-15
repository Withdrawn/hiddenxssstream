package services;
import java.io.IOException;
import java.sql.Timestamp;
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

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


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
		
		//use a md5 to flag a content   finish later 

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
		if(referer!=null&&!referer.equals(""))
		{
			String[] temps=referer.split("/");
			if(temps.length>0)
				c.setC_domain(temps[0]);
		}
		cdao.saveContent(c);
	}
	
	public List<Content> getContentsByPrject(Project p,int page,int pagenum)
	{
		List<Content> contents=cdao.getContentsByPrject(p, page, pagenum);
		return contents;
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
			headers.put(temp,value);
		}
		ObjectMapper objectMapper = new ObjectMapper();  
		try {
			temp=objectMapper.writeValueAsString(headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(temp.length());
		return temp;
		
	}
}