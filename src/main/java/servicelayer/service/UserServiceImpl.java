package servicelayer.service;

import daolayer.dao.UserDao;
import daolayer.dao.UserDaoImpl;
import daolayer.model.User;

public class UserServiceImpl implements UserService {

	UserDao myUserDao = new UserDaoImpl();
	
	@Override
	public User getCredentials(String userName, String password) {
		return myUserDao.getCredentials(userName, password);
	}

}
