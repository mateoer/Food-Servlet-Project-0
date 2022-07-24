package daolayer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import daolayer.model.User;

public class UserDaoImpl implements UserDao {
	
	public static void main(String[] args) {
		UserDao myUser = new UserDaoImpl();
		System.out.println(myUser.getCredentials("Ana","123"));
		System.out.println(myUser.getCredentials("Raj","123"));
		
	}

	@Override
	public User getCredentials(String userName, String password) {
		
		User myUser = new User();
		
		try (Connection conn = OurCustomConnectionFactory.getConnection()) {
			
			
			
			String sql = "SELECT * FROM userFood u WHERE u.userFood_name = ? AND u.userFood_password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				myUser.setUserName(rs.getString("userfood_name"));
				myUser.setPassword(rs.getString("userfood_password"));
				myUser.setUserId(rs.getInt("userfood_id"));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return myUser;
		
		
		
		
	}

}
