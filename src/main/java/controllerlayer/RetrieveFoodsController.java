package controllerlayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import daolayer.dao.FoodDao;
import daolayer.dao.FoodDaoImpl;
import daolayer.model.Food;

public class RetrieveFoodsController {

	public static void foodRetriever(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		List<Food> foods = new ArrayList<>();		
		FoodDao myDao = new FoodDaoImpl();
		foods = myDao.selectAllFoods();		

		//servlet logic
		resp.setContentType("application/json");
		PrintWriter  printer = resp.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(foods));
	}
}
