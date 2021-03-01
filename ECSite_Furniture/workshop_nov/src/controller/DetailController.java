package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DetailService;

public class DetailController extends HttpServlet{

	HttpServletRequest request;
	HttpServletResponse response;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		try {

			//top.jspから商品IDとユーザIDを取得
			String pro_id = request.getParameter("id");
			String user = request.getParameter("user");
			//商品IDをint変換
			int id = Integer.parseInt(pro_id);
			//詳細とお気に入りのModelをインスタンス化する
			DetailService detail = new DetailService();
			//ユーザがログインしていた場合お気に入りした商品をBeanに格納
			if(user != null) {
				request.setAttribute("flag", detail.showDetails(user, id));
			}

			//商品詳細を取得してセット
			request.setAttribute("shohin", detail.showDetail(id));

			//お気に入りのModelから
//			fs.favorite(pro_id, user);


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
