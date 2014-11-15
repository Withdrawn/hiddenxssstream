package model;

import java.security.MessageDigest;
import java.sql.Timestamp;

import javax.validation.constraints.Pattern;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Set;

import org.hibernate.validator.constraints.Length;



@Entity
@Table(name="xss_user") 
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class User
{
	private Integer u_id;
	private final String salt="hiddenxss";//防撞库

	@Pattern(regexp="^[a-zA-Z0-9_]{6,16}")
	private String u_name;
	
	private String u_nick;
	private String u_lastip;
	private Timestamp u_lastlogin;
	private Timestamp u_regtime;
	private String u_code;
	@Transient
	public String getU_code() {
		return u_code;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}
	
	public User(int u_id)
	{
		this.u_id=u_id;
	}
	public User(String u_name)
	{
		this.u_name=u_name;
	}
	public User(){}
	@Length(max=32)
	private String u_pass;
	private String u_mail;
	private String u_flag;//找回密码
	private Integer u_tries;//尝试次数超5 开验证
	
	private String u_photopath;
	
	private Set<Module> modules;
	
	private Set<Arm> arms;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="a_uploader")
	public Set<Arm> getArms() {
		return arms;
	}

	public void setArms(Set<Arm> arms) {
		this.arms = arms;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="m_managerId")
	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}


	private int u_money;
	@Column
	public int getU_money() {
		return u_money;
	}
	@Column(length=100)
	public void setU_money(int u_money) {
		this.u_money = u_money;
	}
	
	public String getU_signature() {
		return u_signature;
	}

	public void setU_signature(String u_signature) {
		this.u_signature = u_signature;
	}


	private String u_signature;
	@Column()
	public String getU_photopath() {
		return u_photopath;
	}

	public void setU_photopath(String u_photopath) {
		this.u_photopath = u_photopath;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getU_id() {
		return u_id;
	}
	
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	@Column(length=32,nullable=false,unique=true)
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	@Column(length=16)
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	@Column(length=16)
	public String getU_lastip() {
		return u_lastip;
	}
	public void setU_lastip(String u_lastip) {
		this.u_lastip = u_lastip;
	}
	@Column()
	public Timestamp getU_lastlogin() {
		return u_lastlogin;
	}
	public void setU_lastlogin(Timestamp u_lastlogin) {
		this.u_lastlogin = u_lastlogin;
	}
	@Column(nullable=false,length=32)
	public String getU_pass() {
		return u_pass;
	}
	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}
	@Column(nullable=false,length=32)
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	@Column(length=7)
	public String getU_flag() {
		return u_flag;
	}
	public void setU_flag(String u_flag) {
		this.u_flag = u_flag;
	}
	@Column(columnDefinition="int default 0",nullable = false)   
	public Integer getU_tries() {
		return u_tries;
	}
	public void setU_tries(Integer u_tries) {
		this.u_tries = u_tries;
	}
	 @Column(nullable = false)
	public Timestamp getU_regtime() {
		return u_regtime;
	}
	public void setU_regtime(Timestamp u_regtime) {
		this.u_regtime = u_regtime;
	}
	@Transient
	public String getSalt() {
		return salt;
	}
	
	
	public String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
