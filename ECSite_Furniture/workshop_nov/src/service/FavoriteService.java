package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.FavoriteBean;
import util.ConstSQL;

public class FavoriteService {

	Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    FavoriteBean favb = new FavoriteBean();

	@SuppressWarnings("resource")
	public void favorite(String pro_id, String usr_id){

		try {
			Class.forName(ConstSQL.POSTGRES_DRIVER);
	        connection = DriverManager.getConnection(ConstSQL.JDBC_CONNECTION, ConstSQL.USER, ConstSQL.PASS);

	        //お気に入りテーブルの情報を確認する
            PreparedStatement favSelectQuery = connection.prepareStatement(ConstSQL.FAVORITE_SELECT_SQLS);
            int userid = Integer.parseInt(usr_id);
            int proid = Integer.parseInt(pro_id);
            favSelectQuery.setInt(1, userid);
            favSelectQuery.setInt(2, proid);
	        resultSet = favSelectQuery.executeQuery();

	        //Beanに一度格納する。商品IDとユーザIDをもとに取得するので一件だけ取ってくる
            while (resultSet.next()) {
                int userId = resultSet.getInt("users_id");
                int proId = resultSet.getInt("items_id");
                String flag = resultSet.getString("favorite_flag");

                favb.setuserId(userId);
                favb.setproId(proId);
                favb.setflag(flag);
            }

            	//テーブルを確認してフラグがnullか確認。nullだったら一度も登録してない商品なのでinsert
            	if(favb.getflag() == null) {
        	        favSelectQuery = connection.prepareStatement(ConstSQL.FAVORITE_SQL);
    	            favSelectQuery.setInt(1, userid);
    	            favSelectQuery.setInt(2, proid);
    	            favSelectQuery.setString(3, "1");
    	            favSelectQuery.executeUpdate();
    	        //nullじゃなかった場合
            	}else{
            		favSelectQuery = connection.prepareStatement(ConstSQL.FAVORITE_UPDATE);
            		//現在のフラグを確認して登録か解除か分岐
            		if(favb.getflag().equals("0")) {
            			favSelectQuery.setString(1, "1");
            		}else {
            			favSelectQuery.setString(1, "0");
            		}
                    favSelectQuery.setInt(2, proid);
                    favSelectQuery.setInt(3, userid);
                    System.out.println(favSelectQuery);
        	        favSelectQuery.executeUpdate();
        		}

	            while (resultSet.next()) {
	                int userId = resultSet.getInt("users_id");
	                int proId = resultSet.getInt("items_id");
	                String flag = resultSet.getString("favorite_flag");

	                favb.setuserId(userId);
	                favb.setproId(proId);
	                favb.setflag(flag);
	            }

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}

	}
}
