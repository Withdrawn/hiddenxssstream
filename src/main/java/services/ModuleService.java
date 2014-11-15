package services;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import model.Module;
import model.User;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ModuleDao;
import dao.UserDao;

@Service("moduleService")
public class ModuleService
{
	@Resource(name="moduleDao")
	private ModuleDao moduleDao;
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
	public Module insertModule(Module m,String[] parmaters,String[] parmaters2,String uname)
	{
		setModuleJson(m, parmaters, parmaters2);
		
		User u=userDao.getIdByName(uname);
		m.setM_addtime(new Timestamp(new Date().getTime()));
		m.setM_managerId(u);
		moduleDao.insertModule(m);
		return m;
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
	public List<Module> getModuleList(User u,boolean pub)
	{
		u=userDao.getIdByName(u.getU_name());
		return moduleDao.getModuleList(u,pub);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
	public List<Module> getModuleDetailList(User u,boolean pub){
		u=userDao.getIdByName(u.getU_name());
		List<Module> ml=moduleDao.getModuleDetailList(u,pub);
		
		return ml;
	}
	@Transactional(readOnly=true)
	public Module getModuleById(int m_id)
	{
		Module m=moduleDao.getModuleById(m_id);
		return m;
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
	public boolean deleteModuleById(int u_id,int m_id)
	{
		//check if this module belong login user
		Module m=moduleDao.getModuleById(m_id);
		if(u_id!=m.getM_managerId().getU_id())
			return false;
		moduleDao.deleteModule(m_id);
		return true;
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
	public Module updateModule(Module m, String[] parmaters, String[] parmaters2,
			int  u_id) {
		Module module=moduleDao.getModuleById(m.getM_id());
		if(u_id!=module.getM_managerId().getU_id())
			return null;
		setModuleJson(m, parmaters, parmaters2);
		module.setM_title(m.getM_title());
		module.setM_desc(m.getM_desc());
		module.setM_reckeys(m.getM_reckeys());
		module.setM_setkeys(m.getM_setkeys());
		module.setM_isopen(m.getM_isopen());
		m=moduleDao.updateModule(module);
		return m;
	}
	public void setModuleJson(Module m, String[] parmaters, String[] parmaters2)
	{
		ObjectMapper objectMapper = new ObjectMapper();  
		String temp=null;
		try {
			if(parmaters!=null){
			temp=objectMapper.writeValueAsString(parmaters);
			System.out.println(temp);
			m.setM_reckeys(temp);
			}
			if(parmaters2!=null)
			{
				temp=objectMapper.writeValueAsString(parmaters2);
				System.out.println(temp);
				m.setM_setkeys(temp);
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}