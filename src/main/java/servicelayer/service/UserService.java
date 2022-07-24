package servicelayer.service;

import daolayer.model.User;

public interface UserService {

	public User getCredentials(String userName, String password);
	
}
