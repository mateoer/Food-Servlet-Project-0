package servicelayer.service;

import java.util.List;

import daolayer.model.Food;

public interface FoodService {
	
	//delete
	public boolean deleteFood(int foodId);
	
	//insert
	public boolean addFood(String foodName);
	
	//select
	public List<Food> selectAllFoods(); 
}
