package model;

import java.io.File;
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
@Table(name="xss_arm")
public class Arm
{
	
	private Integer a_id;
	private String a_orginal;
	private String a_save;
	private String a_hash;
	private Long a_size;
	private User a_uploader;
	private Timestamp a_uptime;
	private short a_pass;
	private Integer a_download;
	private String a_desc;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	@Column
	public String getA_orginal() {
		return a_orginal;
	}
	public void setA_orginal(String a_orginal) {
		this.a_orginal = a_orginal;
	}
	@Column
	public String getA_save() {
		return a_save;
	}
	public void setA_save(String a_save) {
		this.a_save = a_save;
	}
	@Column
	public String getA_hash() {
		return a_hash;
	}
	public void setA_hash(String a_hash) {
		this.a_hash = a_hash;
	}
	@Column
	public Long getA_size() {
		return a_size;
	}
	public void setA_size(Long a_size) {
		this.a_size = a_size;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	public User getA_uploader() {
		return a_uploader;
	}
	public void setA_uploader(User a_uploader) {
		this.a_uploader = a_uploader;
	}
	@Column
	public Timestamp getA_uptime() {
		return a_uptime;
	}
	public void setA_uptime(Timestamp a_uptime) {
		this.a_uptime = a_uptime;
	}
	@Column
	public short getA_pass() {
		return a_pass;
	}
	public void setA_pass(short a_pass) {
		this.a_pass = a_pass;
	}
	@Column
	public Integer getA_download() {
		return a_download;
	}
	public void setA_download(Integer a_download) {
		this.a_download = a_download;
	}
	@Column(length=200)
	public String getA_desc() {
		return a_desc;
	}
	public void setA_desc(String a_desc) {
		this.a_desc = a_desc;
	}

}