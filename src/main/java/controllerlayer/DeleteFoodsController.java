package controllerlayer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import daolayer.model.Food;
import servicelayer.service.FoodService;
import servicelayer.service.FoodServiceImpl;

public class DeleteFoodsController {
	
//	private static FoodService service = new FoodServiceImpl();
	
	public static void foodRemover(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		FoodService service = new FoodServiceImpl();
		
		ObjectMapper myMapper = new ObjectMapper();
//		Integer foodId = myMapper.readValue(req.getInputStream(), Integer.class);
		
		Food food = myMapper.readValue(req.getInputStream(), Food.class);		
		
		boolean success = service.deleteFood(food.getFoodId());
		
		resp.setContentType("text/html");
		if(success) {
			resp.getWriter().println("Food deleted");
		}else {
			resp.getWriter().println("Food was not deleted");
		}
		
		
		

		//FoodDao myDao = new FoodDaoImpl();
//		String fid = req.getParameter("foodIndex");
		
//		FoodDao myDao = new FoodDaoImpl();
//		ObjectMapper myMapper = new ObjectMapper();
//		
////		String foodName = req.getParameter("foodName");
//		String foodId = myMapper.readValue(req.getInputStream(), String.class);
//		
//		int foodIndex = Integer.parseInt(foodId);
//		myDao.deleteFood(foodIndex);
//
//		resp.setContentType("application/json");
//		PrintWriter printer = resp.getWriter();
//		printer.write("Deleted!");

	}
}
