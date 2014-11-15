package model;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.metamodel.source.annotations.attribute.type.LobTypeResolver;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="xss_module")
public class Module
{
	private Integer m_id;
	private short m_level;
	private String m_title;
	private String m_desc;
	private String m_reckeys;
	private String m_setkeys;
	private String m_selfcode;
	private short m_isopen;
	private User m_managerId;
	private short m_isaudit;
	private Timestamp m_addtime;
	private Set<Project> m_project;
	//使用次数
	public Module(Integer m_id,String m_title)
	{
		this.m_id=m_id;
		this.m_title=m_title;
	}
	public Module(Integer m_id,String m_title,Object m_addtime)
	{
		this.m_id=m_id;
		this.m_title=m_title;
		this.m_addtime=Timestamp.valueOf(m_addtime.toString());
	}
	public Module(Integer m_id,String m_title,Object m_addtime,User m_managerId)
	{
		this.m_id=m_id;
		this.m_title=m_title;
		this.m_addtime=Timestamp.valueOf(m_addtime.toString());
		this.m_managerId=m_managerId;
	}
	public Module(){
	}
	@ManyToMany(targetEntity=Project.class,mappedBy="p_modules")
	public Set<Project> getM_project() {
		return m_project;
	}
	public void setM_project(Set<Project> m_project) {
		this.m_project = m_project;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	@Column
	public short getM_level() {
		return m_level;
	}
	public void setM_level(short m_level) {
		this.m_level = m_level;
	}
	@Column
	@Length(max=16,min=2)
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	@Length(max=100,min=10)
	public String getM_desc() {
		return m_desc;
	}
	public void setM_desc(String m_desc) {
		this.m_desc = m_desc;
	}
	@Column
	public String getM_reckeys() {
		return m_reckeys;
	}
	public void setM_reckeys(String m_reckeys) {
		this.m_reckeys = m_reckeys;
	}
	@Column
	public String getM_setkeys() {
		return m_setkeys;
	}
	public void setM_setkeys(String m_setkeys) {
		this.m_setkeys = m_setkeys;
	}
	@Column(length=65535)
	public String getM_selfcode() {
		return m_selfcode;
	}
	public void setM_selfcode(String m_selfcode) {
		this.m_selfcode = m_selfcode;
	}
	@Column
	public short getM_isopen() {
		return m_isopen;
	}
	public void setM_isopen(short m_isopen) {
		this.m_isopen = m_isopen;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	public User getM_managerId() {
		return m_managerId;
	}
	public void setM_managerId(User m_managerId) {
		this.m_managerId = m_managerId;
	}
	@Column
	public short getM_isaudit() {
		return m_isaudit;
	}
	public void setM_isaudit(short m_isaudit) {
		this.m_isaudit = m_isaudit;
	}
	@Column
	public Timestamp getM_addtime() {
		return m_addtime;
	}
	public void setM_addtime(Timestamp m_addtime) {
		this.m_addtime = m_addtime;
	}
	

}
