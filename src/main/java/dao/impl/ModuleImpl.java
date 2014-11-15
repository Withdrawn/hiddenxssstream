package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import model.Module;
import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import dao.ModuleDao;

@Repository("moduleDao")
public class ModuleImpl  implements ModuleDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	private static final Logger log = LoggerFactory.getLogger(ModuleImpl.class);
	
	
	public Module getModuleById(int mid)
	{
		String hql="from Module m where m.m_id=:mid";
		Query q=sessionFactory.getCurrentSession().createQuery(hql).setInteger("mid",mid);
		@SuppressWarnings("rawtypes")
		Module m=(Module) q.uniqueResult();
		return m; 
	}

	public boolean insertModule(Module m) {
		Session s=sessionFactory.getCurrentSession();
		s.save(m);
		return true;
	}
	

	public boolean deleteModule(int mid) {
		String hql="delete from Module m where m.m_id=:mid";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger("mid",mid);
		
		q.executeUpdate();
		return true;
	}

	public Module updateModule(Module m) {
		Session s=sessionFactory.getCurrentSession();
		s.update(m);
		return m;
	}

	public List<Module> getModuleList(User u,boolean pub) {
		//返回用户自定义模块列表  时间 标题 id    ,m.m_addtime
		String hql="select new Module(m.m_id,m.m_title,m.m_addtime) from Module m where m.m_managerId=:user";
		if(pub)
			hql+=" or m.m_managerId=null";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setEntity("user", u);
		return q.list();
	}
	public List<Module> getModuleDetailList(User u,boolean pub)
	{
		String hql ="from Module m where m.m_managerId=:user";
		if(pub)
			hql+=" or m.m_managerId=null";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setEntity("user", u);
		return q.list();
	}
	
	public Module loadModuleById(int m_id)
	{
		Session s=sessionFactory.getCurrentSession();
		return (Module) s.load(Module.class,m_id);
	}


	
}