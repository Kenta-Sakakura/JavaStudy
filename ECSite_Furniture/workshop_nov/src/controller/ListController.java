package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ShohinService;

public class ListController extends HttpServlet{

	HttpServletRequest request;
	HttpServletResponse response;
	ServletContext sc;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		try {

			ShohinService ss = new ShohinService();
			sc = this.getServletContext();
			sc.setAttribute("shohin", ss.showList());


		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        RequestDispatcher dispatcher = sc.getRequestDispatcher("/top.jsp");
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
