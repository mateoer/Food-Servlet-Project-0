package frontcontrollerlayer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerlayer.DeleteFoodsController;
import controllerlayer.InsertFoodsController;
import controllerlayer.LoginController;
import controllerlayer.RetrieveFoodsController;
import controllerlayer.HomeController;


public class Dispatcher {

	public static void myVirtualRouterMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("\n\n\tIN OUR DISPATCHER (myVirtualRouter()) ");

		System.out.println("Current URL: "+req.getRequestURL());
		System.out.println("Current URI: "+req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/FoodServlet2/json/foodlist":
			System.out.println("case 1");
			RetrieveFoodsController.foodRetriever(req, resp);
			break;
		case "/FoodServlet2/food/addfood":
			System.out.println("case 2");
			InsertFoodsController.foodAdder(req, resp);
			break;
		case "/FoodServlet2/food/deletefood":
			System.out.println("case 3");
			DeleteFoodsController.foodRemover(req, resp);
			break;
			
		case "/FoodServlet2/login":
			System.out.println("case 4");
			LoginController.login(req, resp);
			break;
			
		case "/FoodServlet2/json/getCurrentUserObject":
			System.out.println("case 5");
			HomeController.getCurrentUserFromTheirSession(req, resp);
			break;
			
		case "/FoodServlet2/logout":
			LoginController.logout(req, resp);
			break;
		
		default:
				System.out.println("You gave me a bad URL");
				req.getRequestDispatcher("/resources/html/badlogin.html").forward(req, resp);
		}
	}
}