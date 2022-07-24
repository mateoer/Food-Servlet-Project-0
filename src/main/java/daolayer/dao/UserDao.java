package daolayer.dao;

import daolayer.model.User;

public interface UserDao {
	
	public User getCredentials(String userName, String password);
	
}
