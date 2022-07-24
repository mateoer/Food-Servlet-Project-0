package daolayer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daolayer.model.Food;

public class FoodDaoImpl implements FoodDao {
	

	@Override
	public boolean deleteFood(int foodId) {
		try (Connection conn = OurCustomConnectionFactory.getConnection()) {

			
			String sqlTwo = "DELETE FROM foods WHERE food_id =?";

			PreparedStatement ps = conn.prepareStatement(sqlTwo);
			ps.setInt(1, foodId);
			int numOfRowsEffected = ps.executeUpdate();
			
			System.out.println("Num of rows affected during deletion of parent: "+ numOfRowsEffected);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}	

	@Override
	public boolean insertFood(String foodName) {
		try (Connection conn = OurCustomConnectionFactory.getConnection()) {

			String ourSQLStatement = "INSERT INTO foods(food_name) VALUES (?);";

			//PREPARED STATEMENT
			PreparedStatement ps = conn.prepareStatement(ourSQLStatement);
			ps.setString(1, foodName);

			int numberOfRowsEffected = ps.executeUpdate(); //<---update not query
			
			if (numberOfRowsEffected == 1)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Food> selectAllFoods() {
		List<Food> foods = new ArrayList<>();

		try (Connection conn = OurCustomConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM foods";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				foods.add(new Food(rs.getInt("food_id"), rs.getString("food_name")));															 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foods;
	}

}
