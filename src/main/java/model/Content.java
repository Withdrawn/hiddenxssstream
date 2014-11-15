package model;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="xss_content")
public class Content
{
	private Integer c_id;
	private String c_content;
	private String c_domain;
	private String c_sercontent;
	private String c_cookiehash;
	private short c_num;
	private Timestamp c_addtime;
	private Timestamp c_updatetime;
	private Project c_project;
	//private User conOwner;用来统计用户content数   加入这个防止关系的断层
	@ManyToOne(fetch=FetchType.EAGER)
	public Project getC_project() {
		return c_project;
	}
	public void setC_project(Project c_project) {
		this.c_project = c_project;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	@Column(length=65535)
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	@Column
	public String getC_domain() {
		return c_domain;
	}
	public void setC_domain(String c_domain) {
		this.c_domain = c_domain;
	}
	@Column(length=65535)
	public String getC_sercontent() {
		return c_sercontent;
	}
	public void setC_sercontent(String c_sercontent) {
		this.c_sercontent = c_sercontent;
	}
	@Column(length=50)
	public String getC_cookiehash() {
		return c_cookiehash;
	}
	public void setC_cookiehash(String c_cookiehash) {
		this.c_cookiehash = c_cookiehash;
	}
	@Column
	public short getC_num() {
		return c_num;
	}
	
	public void setC_num(short c_num) {
		this.c_num = c_num;
	}
	@Column
	public Timestamp getC_addtime() {
		return c_addtime;
	}
	public void setC_addtime(Timestamp c_addtime) {
		this.c_addtime = c_addtime;
	}
	@Column
	public Timestamp getC_updatetime() {
		return c_updatetime;
	}
	public void setC_updatetime(Timestamp c_updatetime) {
		this.c_updatetime = c_updatetime;
	}
}