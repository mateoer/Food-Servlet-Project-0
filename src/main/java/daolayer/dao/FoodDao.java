package daolayer.dao;

import java.util.List;

import daolayer.model.Food;

public interface FoodDao {
	
	//DELETE
	public boolean deleteFood(int foodId);
	
	
	//INSERTS
	public boolean insertFood(String foodName);
	
	//SELECTS
	public List<Food> selectAllFoods();
	
	
	
}
