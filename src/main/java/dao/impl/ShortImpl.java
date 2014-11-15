package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import model.Url;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ShortDao;

@Repository("shortDao")
public class ShortImpl implements ShortDao
{

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	@Override

	public String shortExist(String url,String orgurl) {
		Session s =sessionFactory.getCurrentSession();
		Url u=null;
		String hql="select new model.Url(u_orginal,u_convented) from Url as u where u.u_orginal=:org";
		Query q=s.createQuery(hql);
		q.setString("org",orgurl);
		u=(Url) q.uniqueResult();
		if(u!=null){
			String shorturl=u.getU_other()==null?u.getU_convented():u.getU_convented()+u.getU_other();
			return shorturl;
		}
			
		//找出传进来的这6位是否存在在数据库 如存在找出则改为7位 u_other为第7个字符  如果重复的超过了9个则为字符a+x
		hql="select count(*) from Url as u  where u.u_convented=:con";
		
		q=s.createQuery(hql);
		q.setString("con", url);
		
		int temp=((Long)q.uniqueResult()).intValue();
		if(temp>0&&temp<9)
		{
			//增加数字在后面
			System.out.println(1);
			url=url+temp;
		}else if(temp>=9)
		{
			//增加字母  a=97
			System.out.println(2);
			char c=(char)(87+temp+1);
			url=url+c;
		}
		
		if(url.length()>6)
		{
			u=new Url(orgurl,url.substring(0,url.length()-1),url.charAt(url.length()-1));
			s.save(u);
			return url.substring(0,url.length()-1);
		}else
		{
			u=new Url(orgurl,url);
			s.save(u);
			return url;
		}
	}
	public String recoverUrl(String convented) {
		Session s =sessionFactory.getCurrentSession();
		String hql="";
		Query q=null;
		if(convented.length()==6)
		{
			hql="from Url as u where u.u_convented=:shorturl";
			q=s.createQuery(hql);
			q.setString("shorturl",convented);
		}else if(convented.length()==7)
		{
			hql="from Url as u where u.u_convented=:shorturl and u.u_other=:other";
			q=s.createQuery(hql);
			q.setString("shorturl",convented.substring(0,6));
			q.setString("other", convented.substring(6,7));
		}
		if(q==null)
			return "null";
		Url u=(Url) q.uniqueResult();
		if(u!=null)
		{
			return u.getU_orginal();
		}else
		{
			return "null";	
		}
	}
	
	public int getShortCount() {
		Session s =sessionFactory.getCurrentSession();
		String hql="select count(*) from Url";
		Query q=s.createQuery(hql);
		int temp=((Long)q.uniqueResult()).intValue();
		return temp;
	}
	
	public String checkDefine(String longurl, String shorturl) {
		Session s =sessionFactory.getCurrentSession();
		String hql="from Url as u where u.u_orginal=:longurl or u.u_convented=:shorturl";
		Query q=s.createQuery(hql);
		q.setString("longurl", longurl);
		q.setString("shorturl", shorturl);
		@SuppressWarnings("unchecked")
		List<Url> urllist=q.list();
		
		if(urllist.size()==0)
		{
			Url u=new Url(longurl,shorturl);
			s.save(u);
		}else{
			Url u=(Url) urllist.get(0);
			if(u.getU_orginal().equals(longurl))
				return "该网址已存在短网址";
			else
				return "该短网址已存在";
		}
		return null;
	}
	public boolean saveUrl(Url u)
	{
		Session s =sessionFactory.getCurrentSession();
		s.save(u);
		return true;
	}
	@Override
	public String getAuthCode(String shorturl) {
		
		return null;
	}
	
	}