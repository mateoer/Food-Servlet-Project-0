package servicelayer.service;

import java.util.List;

import daolayer.dao.FoodDao;
import daolayer.dao.FoodDaoImpl;
import daolayer.model.Food;

public class FoodServiceImpl implements FoodService {
	
	FoodDao myFoodDao = new FoodDaoImpl();
	
//	public static void main(String[] args) {
//		FoodDao muyDao = new FoodDaoImpl();
////		System.out.println(muyDao.selectAllFoods());
////		muyDao.insertFood("petunias");
//		muyDao.deleteFood(1);
//		System.out.println(muyDao.selectAllFoods());
//	}

	@Override
	public boolean deleteFood(int foodId) {
		return myFoodDao.deleteFood(foodId);
	}

	@Override
	public boolean addFood(String foodName) {
		return myFoodDao.insertFood(foodName);
	}

	@Override
	public List<Food> selectAllFoods() {
		return myFoodDao.selectAllFoods();
	}

}
