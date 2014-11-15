package dao;

import java.util.List;

import model.Project;
import model.User;

public interface ProjectDao
{
	public List<Project> getProjectList(User u);
	public Project insertProject(Project p);
	public Project findProjectById(int p_id);
	public boolean deleteProjectById(Project p);
	public Project getProjectDetail(int p_id);
	public Project getProjectByCode(String authcode);
}
