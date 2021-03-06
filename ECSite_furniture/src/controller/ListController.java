package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;
import service.LoginServlet;

public class ListController extends HttpServlet{

    HttpServletRequest request;
    HttpServletResponse response;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
        try {

            String username = request.getParameter("id");
            String password = request.getParameter("pass");

            LoginServlet ss = new LoginServlet();
            LoginBean login = ss.search(username, password);
            request.setAttribute("Loginbean", login);


           }catch (Exception e) {
            e.printStackTrace();
           } finally {
            ServletContext context = this.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/Login.jsp");
            dispatcher.forward(request, response);

            }
        }
    }


