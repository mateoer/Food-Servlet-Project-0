package controllerlayer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import daolayer.model.Food;
import servicelayer.service.FoodService;
import servicelayer.service.FoodServiceImpl;

public class InsertFoodsController {
	
//	private static FoodService service = new FoodServiceImpl();

	public static void foodAdder(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		FoodService service = new FoodServiceImpl();
		
		ObjectMapper myMapper = new ObjectMapper();
		Food food = myMapper.readValue(req.getInputStream(), Food.class);
		boolean success = service.addFood(food.getFoodName());
		
		resp.setContentType("text/html");
		if(success) {
			resp.getWriter().println("Food added.");
		}else {
			resp.getWriter().println("Food was not added.");
		}
		
//		FoodDao myDao = new FoodDaoImpl();
//		myDao.insertFood(foodName);
//		resp.setContentType("application/json");
//		PrintWriter printer = resp.getWriter();
//		printer.write("Added!");


	}

}
