package controllerlayer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daolayer.model.User;
import servicelayer.service.UserService;
import servicelayer.service.UserServiceImpl;

public class LoginController {

	public static void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myPath = null;

		
		if(!req.getMethod().equals("POST")) {
			myPath = "/index.html";
			req.getRequestDispatcher(myPath).forward(req, resp);
		}
		
		
		//extract the form data
		String username = req.getParameter("theirUsername");
		String password = req.getParameter("theirPassword");
		
		
		UserService myUserService = new UserServiceImpl();
		User currentUser = myUserService.getCredentials(username, password);		
		
		
		if(currentUser.getUserName() != null && currentUser.getPassword() != null) {
			/*
			 * you probably will have a user object that you put into the session
			 * and that user object will contain the username & password. INSTEAD
			 * of putting them in separately like we are doing below
			 */
			
			if(currentUser.getUserName().equals(username) && currentUser.getPassword().equals(password)) {
				req.getSession().setAttribute("currentUser", username );
				req.getSession().setAttribute("loggedInPassword", password);

				myPath = "/resources/html/home.html";
				req.getRequestDispatcher(myPath).forward(req, resp);
			}else {
				System.out.println("Wrong username or password");
			}
			
		}else{
			myPath = "/login/badlogin.html";
			req.getRequestDispatcher(myPath).forward(req, resp);
		}
	}
	
	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		req.getRequestDispatcher("/index.html").forward(req, resp);
	}

}
