package dao;

import java.util.List;

import model.Content;
import model.Project;

public interface ContentDao
{
	public void saveContent(Content c);
	public List<Content> getContentsByProject(Project p,int page,int pagenum);

}