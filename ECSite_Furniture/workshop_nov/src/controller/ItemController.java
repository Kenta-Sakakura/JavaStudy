package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ItemService;

public class ItemController extends HttpServlet{

	HttpServletRequest request;
	HttpServletResponse response;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		request.setCharacterEncoding("utf-8");
		try {

			String item_name = request.getParameter("item_name");
			String price = request.getParameter("item_price");
			String item_img_url = request.getParameter("item_img_url");
			String category = request.getParameter("category");
			String category_name = null;

			int category_num = Integer.parseInt(category);
			int item_price = Integer.parseInt(price);

			switch(category_num) {
			case 1:
				category_name = "テーブル";
				break;
			case 2:
				category_name = "机";
				break;
			case 3:
				category_name = "椅子";
				break;
			case 4:
				category_name = "その他";
				break;
			}

			ItemService item = new ItemService();
			item.insert(item_name, item_price, item_img_url, category_num, category_name);

		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ServletContext context = this.getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/insert.jsp");
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
