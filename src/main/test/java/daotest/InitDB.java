package daotest;


import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import model.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={ "classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/xssfrontview-servlet.xml"})
public class InitDB extends AbstractTransactionalJUnit4SpringContextTests{
	private Session session;
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	//@Test
	public void test() {
			Configuration config=null;
			Transaction tx=null;
			try
			{
				File f=new File("src/main/java/hibernate.cfg.xml");
				System.out.println(f.getAbsolutePath());
				config=new Configuration().configure(f);
				
				SchemaExport schemaExport=new SchemaExport(config);
				schemaExport.create(true,true);
				ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
				SessionFactory sessionFactory=config.buildSessionFactory(sr);
				session=sessionFactory.openSession();
				tx=session.beginTransaction();
				tx.commit();
		
				
			}catch(HibernateException e)
			{
				e.printStackTrace();
			       try {
			       tx.rollback();
			       } catch (HibernateException e1) {
			       e1.printStackTrace();
			       }
			}
	}
	@Test
	public void test2(){}
}
