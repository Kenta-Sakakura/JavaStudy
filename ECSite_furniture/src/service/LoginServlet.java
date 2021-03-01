package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.LoginBean;
import bean.ShohinBean;

public class LoginServlet{

    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";

    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/lesson_db";

    private static final String USER = "postgres";

    private static final String PASS = "postgres";

    private static final String LIST_SELECT_SQL = "SELECT id,name,price,img_url FROM items";

//    ログインのテーブル作る
    private static final String SQL_SELECT = "SELECT * from  workshop where username = ? and password = ?";
    LoginBean userData ;

    private ShohinBean shohinData;

    public LoginBean search(String username, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;



        try {
            Class.forName(POSTGRES_DRIVER);
            connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
            statement = connection.createStatement();


            /*
             *  UPDATEが成功したものを即座に表示
             *  任意のユーザーを検索できるように、プリペアドステートメントを記述。
             */
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            //問⑥ 一番目のindexにIDをセットしてください。2番目のindexにPASSWORDをセット。
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            // SQLを実行。実行した結果をresultSetに格納。
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                    String tmpUsername = resultSet.getString("username");
                    String tmpPassword = resultSet.getString("password");

                    userData = new LoginBean();

                    userData.setuserName(tmpUsername);
                    userData.setpassWord(tmpPassword);

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

//      return shohinList;
    }
}