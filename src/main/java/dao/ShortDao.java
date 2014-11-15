package dao;

import model.Url;


public interface ShortDao
{
	public String shortExist(String url,String orgurl);
	public String recoverUrl(String convented);
	public int getShortCount();
	public String checkDefine(String longurl, String shorturl);
	public boolean saveUrl(Url u);
	public String getAuthCode(String shorturl);
}