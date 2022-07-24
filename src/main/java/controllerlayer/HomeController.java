package controllerlayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import daolayer.model.User;

//import daolayer.model.User;
//import servicelayer.service.UserService;
//import servicelayer.service.UserServiceImpl;

public class HomeController {

	public static void home(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String myPath = "/resources/html/home.html";
		
		req.getRequestDispatcher(myPath).forward(req, res);
	}
	
	public static void getCurrentUserFromTheirSession(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		
		User myUser = new User();
		String n = (String) req.getSession().getAttribute("currentUser");
		myUser.setUserName(n);
		
		res.setContentType("application/json");
		PrintWriter  printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myUser));
	}
}
