package daolayer.model;


public class Food {
	int foodId;
	String foodName;
	
	public Food() {
		super();
	}
	
	

	public Food(int foodId) {
		super();
		this.foodId = foodId;
	}



	public Food(String foodName) {
		super();
		this.foodName = foodName;
	}



	public Food(int foodId, String foodName) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "Food [Food Id: " + foodId + ", Food Name: " + foodName + "]";
	}
	
	
}
