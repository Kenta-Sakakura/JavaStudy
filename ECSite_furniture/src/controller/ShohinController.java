package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ShohinList;

public class ShohinController extends HttpServlet{

    HttpServletRequest request;
    HttpServletResponse response;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
        try {

            ShohinList ss = new ShohinList();

            request.setAttribute("shohin", ss.showList());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ServletContext context = this.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
            } catch (IOException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
            }
        }
    }

}
