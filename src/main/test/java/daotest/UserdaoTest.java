package daotest;


import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tools.MD5Util;

import dao.UserDao;



@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/xssfrontview-servlet.xml", "classpath:applicationContext.xml"})
public class UserdaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	
	@Resource(name="userDao")
	private UserDao userdao;
	
	@Test
	@Rollback(false)
	public void insertUser() 
	{

		User u=new User();
		u.setU_name("aaaaaaa");
		u.setU_pass(u.MD5("xssuser1"+u.getSalt()));
		
		u.setU_mail("a");
		Timestamp ts=new Timestamp(new Date().getTime());
		u.setU_regtime(ts);
		u.setU_flag("a");
		u.setU_lastip("a");
		u.setU_nick("a");
		Integer i=0;
		u.setU_tries(i);
		System.out.println(u.getU_tries());
		userdao.insertUser(u);
	}
	
	@Test
	@Rollback(false)
	public void getUser()
	{
		/*
		 * 按用户名查找用户  
		 * */
		String uname="aaaaaaa";
		String pass="xssuser1";
		MD5Util md=new MD5Util();
		
		User u=userdao.getUserByName(uname);
		System.out.println(u.getU_tries());
		if(u!=null)
		{
			if(md.MD5(pass+u.getSalt()).equals(u.getU_pass()))
			{
				System.out.println("密码正确");
				//改变登录时间
				//尝试次数改为 0
				Integer i=0;
				userdao.loginUpdate("fine",i,u.getU_id());
			}else
			{
				System.out.println(u.getU_tries().intValue());
				System.out.println("密码不正确 ");
				
				//增加尝试次数 大于5不更新
				System.out.println(u.getU_tries().intValue());
				if(u.getU_tries().intValue()<=5)
					userdao.loginUpdate("fail",u.getU_tries()+1,u.getU_id());
			}
		}else
		{
			System.out.println("不正确的用户名或密码");
		}
	}

}
