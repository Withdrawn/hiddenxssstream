package dao;

import model.User;



public interface UserDao {
	public User userLogin(String uname,String upass);
	public User getUserById(int id); 
	public boolean insertUser(User u);
	public User getIdByName(String uname);
	public User getUserByName(String uname);
	public void loginUpdate(String type,Integer tries,Integer u_id);
	public User loadUserById(Integer u_id);
}