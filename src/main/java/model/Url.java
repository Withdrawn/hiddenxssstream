package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name="xss_url")
public class Url
{
	private Integer url_id;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUrl_id() {
		return url_id;
	}
	public void setUrl_id(Integer url_id) {
		this.url_id = url_id;
	}
	private String u_orginal;
	private String u_convented;
	private Character u_other;
	public Url(String u_orginal,String u_convented,Character u_other)
	{
		this.u_orginal=u_orginal;
		this.u_convented=u_convented;
		this.u_other=u_other;
	}
	public Url(String u_orginal,String u_convented)
	{
		this.u_orginal=u_orginal;
		this.u_convented=u_convented;
	}
	public Url(){}
	@Column(length=100)
	public String getU_orginal() {
		return u_orginal;
	}
	public void setU_orginal(String u_orginal) {
		this.u_orginal = u_orginal;
	}
	@Column(length=7)
	public String getU_convented() {
		return u_convented;
	}
	public void setU_convented(String u_convented) {
		this.u_convented = u_convented;
	}
	@Column
	public Character getU_other() {
		return u_other;
	}
	public void setU_other(Character u_other) {
		this.u_other = u_other;
	}
	
}