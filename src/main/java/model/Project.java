package model;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="xss_project")
public class Project
{
	private Integer p_id;
	private User userid;
	private String p_desc;
	private String p_title;
	private Timestamp p_addtime;
	private Set<Module> p_modules;
	private String p_urlkey;
	private String p_modulesetkeys;
	private String authcode;
	private String p_code;

	@OneToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER,mappedBy="c_project")
	public Set<Content> getP_contents() {
		return p_contents;
	}
	public void setP_contents(Set<Content> p_contents) {
		this.p_contents = p_contents;
	}
	private Set<Content> p_contents;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	@Column(length=100)
	public String getP_desc() {
		return p_desc;
	}
	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}
	@Column(length=16)
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	@Column
	public Timestamp getP_addtime() {
		return p_addtime;
	}
	public void setP_addtime(Timestamp p_addtime) {
		this.p_addtime = p_addtime;
	}
	@ManyToMany(targetEntity=Module.class,fetch=FetchType.EAGER)
	public Set<Module> getP_modules() {
		return p_modules;
	}
	public void setP_modules(Set<Module> p_modules) {
		this.p_modules = p_modules;
	}
	@Column(length=6)
	public String getP_urlkey() {
		return p_urlkey;
	}
	public void setP_urlkey(String p_urlkey) {
		this.p_urlkey = p_urlkey;
	}
	@Column
	public String getP_modulesetkeys() {
		return p_modulesetkeys;
	}
	public void setP_modulesetkeys(String p_modulesetkeys) {
		this.p_modulesetkeys = p_modulesetkeys;
	}
	@Column(length=32)
	public String getAuthcode() {
		return authcode;
	}
	@Column
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}
	public Project(){}
	public Project(Integer p_id,User p_userid)
	{
		this.p_id=p_id;
		this.userid=p_userid;
	}
	//id  项目名称 描述   内容数   创建时间 
	public Project(Integer p_id,String p_title,String p_desc,Object p_addtime)
	{
		this.p_id=p_id;
		this.p_title=p_title;
		this.p_addtime=Timestamp.valueOf(p_addtime.toString());
		this.p_desc=p_desc;
	}
	public Project(String authcode)
	{
		this.authcode=authcode;
	}
}