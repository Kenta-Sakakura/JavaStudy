package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.UserBean;
import util.ConstSQL;

public class UserService{

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    UserBean userData;

	public UserBean userLogin(String name, String pass){

		try {

			Class.forName(ConstSQL.POSTGRES_DRIVER);
	        connection = DriverManager.getConnection(ConstSQL.JDBC_CONNECTION, ConstSQL.USER, ConstSQL.PASS);

	        PreparedStatement psExecuteQuery = connection.prepareStatement(ConstSQL.LOGIN_SELECT_SQL);
	        psExecuteQuery.setString(1, name);
	        psExecuteQuery.setString(2, pass);
            resultSet = psExecuteQuery.executeQuery();

            while (resultSet.next()) {
                String setId = resultSet.getString("id");
                String setName = resultSet.getString("name");
                userData = new UserBean(setId, setName);
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

		return userData;
	}
}