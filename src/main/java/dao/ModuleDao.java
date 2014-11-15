package dao;

import java.util.List;

import model.Module;
import model.Project;
import model.User;

public interface ModuleDao
{
	public boolean insertModule(Module m);
	public Module getModuleById(int mid);
	public Module loadModuleById(int mid);
	public boolean deleteModule(int mid);
	public Module updateModule(Module m);
	public List<Module> getModuleList(User u,boolean pub);
	public List<Module> getModuleDetailList(User u,boolean pub);
}