package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import model.Content;
import model.Project;
import dao.ContentDao;
@Repository("contentDao")
public class ContentImpl implements ContentDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public void saveContent(Content c) {
		Session s=sessionFactory.getCurrentSession();
		s.save(c);
	}

	public List<Content> getContentsByPrject(Project p, int page, int pagenum) {
		String hql="from Project where c_project=:projectid";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setFirstResult((page-1)*pagenum);
		q.setMaxResults(pagenum);
		@SuppressWarnings("unchecked")
		List<Content> contents=q.setInteger("projectid",p.getP_id()).list();
		return contents;
	}
	
}