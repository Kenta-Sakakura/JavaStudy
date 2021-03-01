package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import service.UserService;

public class UserController extends HttpServlet{

	HttpServletRequest request;
	HttpServletResponse response;

	UserBean bean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		try {
		    HttpSession session = request.getSession(true);
		    session.invalidate();

		    response.sendRedirect("/login.jsp");

		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("pass");

			UserService userService = new UserService();
			bean = userService.userLogin(name, password);

		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {

	    	if(bean != null) {
	    		HttpSession session = request.getSession();
	    		session.setAttribute("userInfo", bean);

	    		ServletContext context = this.getServletContext();
		        RequestDispatcher dispatcher = context.getRequestDispatcher("/top.jsp");
				dispatcher.forward(request, response);
	    	}

	    	String message = "ユーザー名かパスワードに誤りがあります";
	    	request.setAttribute("message", message);

	    	ServletContext context = this.getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
	    }
	}
}
