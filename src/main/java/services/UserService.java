package services;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tools.MD5Util;

import dao.UserDao;

@Service("userService")
public class UserService
{
	@Resource(name="userDao")
	private UserDao userDao;

	public String insertUser(User u) {
		
		boolean flag=userDao.insertUser(u);
		if(!flag)
		{
			return "发生错误,注册失败";
		}
		return "";
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public String userLogin(User u,HttpServletRequest req)
	{
		MD5Util md=new MD5Util();
		User dbuser=userDao.getUserByName(u.getU_name());
	
		if(dbuser!=null)
		{
			
			if(dbuser.getU_tries()>5)
			{
				String temp=req.getParameter("u_code");
				if(temp==null||temp.trim().length()==0)
					return "验证码有误";
				if(!temp.equals(req.getSession().getAttribute("capthcacode")))
					return "验证码有误";
			}
			
			if(md.MD5(u.getU_pass()+dbuser.getSalt()).equals(dbuser.getU_pass()))
			{
				System.out.println("密码正确");
				//改变登录时间
				//尝试次数改为 0
				Integer i=0;
				userDao.loginUpdate("fine",i,dbuser.getU_id());
				u.setU_pass(dbuser.getU_pass());
				u.setU_id(dbuser.getU_id());
				return "fine";
			}else
			{
					System.out.println("密码错误");
					userDao.loginUpdate("fail",dbuser.getU_tries()+1,dbuser.getU_id());
					return "密码错误";
			}
		}else
		{
			return "不正确的用户名或密码 ";
		}
	}
	
	
}