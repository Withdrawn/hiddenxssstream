package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import model.Project;
import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import dao.ProjectDao;

@Repository("projectDao")
public class ProjectImpl implements ProjectDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectList(User u) {
		//返回用户项目 id  项目名称 描述   内容数   创建时间 
		String hql="select new Project(p.p_id,p.p_title,p.p_desc,p.p_addtime) from Project p where p.userid=:user";
		Query q=sessionFactory.getCurrentSession().createQuery(hql).setEntity("user",u);
		return q.list();
	}
	
	public Project insertProject(Project p)
	{
		Session s=sessionFactory.getCurrentSession();
		s.save(p);
		return p;
	}

	@Override
	public Project findProjectById(int p_id) {
		String hql="select new Project(p.p_id,p.userid) from Project p where p.p_id=:p_id";
		Query q=sessionFactory.getCurrentSession().createQuery(hql).setInteger("p_id",p_id);
		return (Project) q.uniqueResult();
	}

	@Override
	public boolean deleteProjectById(Project p) {
		Session s=sessionFactory.getCurrentSession();
		s.delete(p);
		return true;
	}

	@Override
	public Project getProjectDetail(int p_id) {
		String hql="from Project p where p.p_id=:p_id";
		Query q=sessionFactory.getCurrentSession().createQuery(hql).setInteger("p_id", p_id);
		return (Project) q.uniqueResult();
	}

	@Override
	public Project getProjectByCode(String authcode) {
		String hql="from Project p where p.authcode=:authcode";
		Query q=sessionFactory.getCurrentSession().createQuery(hql).setString("authcode",authcode);
		return (Project) q.uniqueResult();
	}
}