package util;

public class ConstSQL{

	public static final String POSTGRES_DRIVER = "org.postgresql.Driver";

    public static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/lesson_db";

    public static final String USER = "postgres";

    public static final String PASS = "postgres";

    public static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

    public static final String LIST_SELECT_SQL = "SELECT id, name, price, img_url FROM items;";

    public static final String LOGIN_SELECT_SQL = "SELECT * FROM users WHERE name = ? AND password = ?;";

    public static final String DETAIL_SELECT_SQL = "SELECT * FROM items WHERE id = ?;";

    public static final String USER_INSERT_SQL = "INSERT INTO users (name, password) VALUES (?,?);";

    public static final String ITEM_INSERT_SQL = "INSERT INTO items (name, price, insert_date, img_url, category, category_name) VALUES (?, ?, ?, ?, ?, ?);";

	public static String FAVORITE_SELECT_SQLS;

	public static String FAVORITE_SQL;

	public static String FAVORITE_UPDATE;
}