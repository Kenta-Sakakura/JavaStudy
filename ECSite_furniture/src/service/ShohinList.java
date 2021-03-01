package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.ShohinBean;

public class ShohinList{

    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";

    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/lesson_db";

    private static final String USER = "postgres";

    private static final String PASS = "postgres";

    private static final String LIST_SELECT_SQL = "SELECT id,name,price,img_url FROM items";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    ShohinBean shohinData;

    ArrayList<ShohinBean> shohinList = new ArrayList<ShohinBean>();

    public ArrayList<ShohinBean> showList(){

        try {

            Class.forName(POSTGRES_DRIVER);
            connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

            PreparedStatement psExecuteQuery = connection.prepareStatement(LIST_SELECT_SQL);
            resultSet = psExecuteQuery.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String imageUrl = resultSet.getString("img_url");

                shohinData = new ShohinBean();
                shohinData.setId(id);
                shohinData.setName(name);
                shohinData.setPrice(price);
                shohinData.setImageUrl(imageUrl);
                shohinList.add(shohinData);
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

        return shohinList;
    }
}