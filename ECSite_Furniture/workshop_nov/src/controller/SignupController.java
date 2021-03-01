package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SignupService;

public class SignupController extends HttpServlet{

	HttpServletRequest request;
	HttpServletResponse response;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		try {

			String name = request.getParameter("user");
			String password = request.getParameter("pass");

			SignupService signUp = new SignupService();
			signUp.insert(name, password);

		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ServletContext context = this.getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");
	        try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}

}
