package frontcontrollerlayer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name="FoodServlet2", urlPatterns= {"/master/*", "/json/*", "/forwarding/*", "/redirecting/*", "/login/*", "/home/*","/js/*", "/logout/*"})
@WebServlet(name="FoodServlet2", urlPatterns= {"/food/*", "/login/*", "/logout", "/json/*"})
public class DatabaseServlet extends HttpServlet {
	

	protected boolean isLoggedIn(HttpServletRequest req) {
		
		boolean unrestrictedURI = req.getRequestURI().equals("/FoodServlet2/login")
				|| req.getRequestURI().equals("/FoodServlet2/login/badlogin.html")
				|| req.getRequestURI().equals("/FoodServlet2/logout");

		if (!unrestrictedURI & req.getSession(false) == null)
			return false;
		else
			return true;
		
//		if ( req.getRequestURI().indexOf("/FoodServlet2/login")==-1 &&  req.getSession(false)==null)
//			return false;
//		else
//			return true;		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN OUR MASTER SERVLET: doGet");
		if(isLoggedIn(req)) {
			
			Dispatcher.myVirtualRouterMethod(req, resp); //HERE I am offloading my work to another entity
		}else {
			resp.getWriter().println("You're not logged in");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN OUR MASTER SERVLET: doPost");

		if(isLoggedIn(req)) {
			
			Dispatcher.myVirtualRouterMethod(req, resp); //HERE I am offloading my work to another entity
		}else {
			resp.getWriter().println("You're not logged in");
		}
	}
	
	
}
