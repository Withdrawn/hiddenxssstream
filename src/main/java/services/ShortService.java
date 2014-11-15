package services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ShortDao;

@Service("shortService")
public class ShortService
{
	@Resource(name="shortDao")
	private ShortDao shortDao;
	@Transactional(propagation=Propagation.REQUIRED)
	public String createUrl(String url,String orgurl)
	{
		System.out.println(orgurl);
		String temp=shortDao.shortExist(url,orgurl);
		return temp;
	}
	@Transactional(readOnly=true)
	public int getShortCount()
	{
		return shortDao.getShortCount();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public String checkDefine(String longurl,String shorturl)
	{
		String msg=shortDao.checkDefine(longurl, shorturl);
		return msg;
	}
	@Transactional(readOnly=true)
	public String recoverUrl(String shorturl)
	{
		String temp=shortDao.recoverUrl(shorturl);
		return temp;
	}
}