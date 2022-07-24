package daolayer.model;

public class User {
	String userName;
	String password;
	Integer userId;
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", userId=" + userId + "]";
	}

	
	
}
