package dao.impl;



import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import model.Module;
import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;



@Repository("userDao")
public class UserImpl  implements UserDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	private static final Logger log = LoggerFactory.getLogger(UserImpl.class);
	public User userLogin(String uname, String upass) {
		String hql="select distinct new User(u.u_name,u.u_pass) from User u where u.u_name=:name and u.u_pass=:pass";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setString("name",uname);
		q.setString("pass",upass);
		List l=q.list();
		if(l.size()>0)
			return (User) l.get(0);
		else
			return null;
	}
	
	public User getUserById(int id)
	{
		String hql="from User u where u.u_id=:id";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger("id",id);
		@SuppressWarnings("rawtypes")
		List l=q.list();
		if(l.size()>0)
		{
			return (User) l.get(0); 
		}else
		return null;
	}
	public User getIdByName(String name)
	{		
		String hql="select distinct new User(u.u_id) from User u where u.u_name=:name";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setString("name",name);
		User u=(User) q.uniqueResult();
		if(u!=null)
			return u;
		return null;
	}
	
	public User getUserByName(String name)
	{		
		String hql="from User u where u.u_name=:name";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setString("name",name);
		User u=(User) q.uniqueResult();
		if(u!=null)
			return u;
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean insertUser(User u) {
		Session s=sessionFactory.getCurrentSession();
		s.save(u);
		return true;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void loginUpdate(String type,Integer tries,Integer u_id)
	{
		Session s=sessionFactory.getCurrentSession();
		Query query=null;
		if(type.equals("fine"))
		{
			query= s.createQuery("update User u set  u.u_lastlogin=:last,u.u_tries=:tries where u.u_id =:id");
			query.setTimestamp("last",new Timestamp(new Date().getTime()));
			query.setInteger("tries",tries);
			query.setInteger("id",u_id);
		}
		else
		{
			query = s.createQuery("update User u set  u.u_tries=:tries where u.u_id =:id");
			query.setInteger("tries",tries);
			query.setInteger("id",u_id);
		}
		query.executeUpdate();
	}


	public User loadUserById(Integer u_id) {
			Session s=sessionFactory.getCurrentSession();
			return (User) s.load(User.class,u_id);
	}
	
}