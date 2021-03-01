package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import util.ConstSQL;

public class ItemService {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

	public void insert(String item_name, int item_price, String item_img_url, int category_num, String category_name){

		try {

			Class.forName(ConstSQL.POSTGRES_DRIVER);
	        connection = DriverManager.getConnection(ConstSQL.JDBC_CONNECTION, ConstSQL.USER, ConstSQL.PASS);

            Timestamp insert_date = new Timestamp(System.currentTimeMillis());

	        PreparedStatement isExecuteQuery = connection.prepareStatement(ConstSQL.ITEM_INSERT_SQL);

	        isExecuteQuery.setString(1, item_name);
	        isExecuteQuery.setInt(2, item_price);
	        isExecuteQuery.setTimestamp(3, insert_date);
	        isExecuteQuery.setString(4, item_img_url);
	        isExecuteQuery.setInt(5, category_num);
	        isExecuteQuery.setString(6, category_name);

            isExecuteQuery.executeUpdate();

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
