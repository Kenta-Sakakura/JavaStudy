package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.ConstSQL;

public class SignupService{

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

	public void insert(String name, String password){

		try {

			Class.forName(ConstSQL.POSTGRES_DRIVER);
	        connection = DriverManager.getConnection(ConstSQL.JDBC_CONNECTION, ConstSQL.USER, ConstSQL.PASS);

	        PreparedStatement psExecuteQuery = connection.prepareStatement(ConstSQL.USER_INSERT_SQL);
	        psExecuteQuery.setString(1, name);
	        psExecuteQuery.setString(2, password);
            psExecuteQuery.executeUpdate();


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