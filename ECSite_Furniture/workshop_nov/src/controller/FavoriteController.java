package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DetailService;
import service.FavoriteService;

public class FavoriteController extends HttpServlet{

	HttpServletRequest request;
	HttpServletResponse response;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		try {
			//formで送信された値をgetする
			String pro_id = request.getParameter("proid");
			String usr_id = request.getParameter("usrid");
			//int変換
			int id = Integer.parseInt(pro_id);
			//使うモデルをインスタンス化
			FavoriteService fs = new FavoriteService();
			DetailService detail = new DetailService();
			//お気に入り登録もしくは解除メソッド
			fs.favorite(pro_id, usr_id);
			request.setAttribute("shohin", detail.showDetail(id));

		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	ServletContext context = this.getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/detail.jsp");
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
