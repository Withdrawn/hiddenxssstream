package vo;

import java.sql.Timestamp;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentVo
{
	private String location;
	private String toplocation;
	private String cookie;
	private String opener;
	private String referer;
	private String useragent;
	private String remote_addr;
	private Integer c_id;
	private Timestamp c_addtime;
	private String domain;
	
	 //用户自己定义的数据用反射增加数据

	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getToplocation() {
		return toplocation;
	}
	public void setToplocation(String toplocation) {
		this.toplocation = toplocation;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getOpener() {
		return opener;
	}
	public void setOpener(String opener) {
		this.opener = opener;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getUseragent() {
		return useragent;
	}
	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}
	public String getRemote_addr() {
		return remote_addr;
	}
	public void setRemote_addr(String remote_addr) {
		this.remote_addr = remote_addr;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public Timestamp getC_addtime() {
		return c_addtime;
	}
	public void setC_addtime(Timestamp c_addtime) {
		this.c_addtime = c_addtime;
	}
	public ContentVo(){}
}

