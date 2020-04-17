package hashlogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DBManager {

	private static DBManager instance;
	private String DBuser;
	private String DBdriver;
	private String url;
	private String pwd;

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DataSource datasource = null;
	public void init(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public Connection getConnection() throws SQLException {
		Connection con = datasource.getConnection();
		return con;
	}

	public void dropConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void init(String DBdriver, String DBuser, String url, String pwd) throws ClassNotFoundException {
		this.DBdriver = DBdriver;
		this.DBuser = DBuser;
		this.url = url;
		this.pwd = pwd;

		Class.forName(this.DBdriver);
	}

	public static void addUser(Connection con, String username, String pwd)
			throws SQLException, ClassNotFoundException {
		String string = "Insert into users(user_name, pwd) values(?,?)";
		PreparedStatement pstm = con.prepareStatement(string);

		try {
			pstm.setString(1, username);
			pstm.setString(3, pwd);
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int checkUser(Connection con, String username, String password)
			throws SQLException, ClassNotFoundException {
		String sql = "Select * from users where user_name = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rts = pstm.executeQuery();

		while(rts.next()) {
			int id = rts.getInt("user_ID");
			String user_name = rts.getString("user_name");
			String email = rts.getString("email");
			String pwd = rts.getString("pwd");
			
			if (user_name.contentEquals(username) && BCrypt.checkpw(password, pwd)) {
				return 1;
			} else {
				return -1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws SQLException{
		DBManager dbmanager = new DBManager();
		dbmanager = DBManager.getInstance();
		
		try {
			dbmanager.init("org.postgresql.Driver", "postgres", "jdbc:postgresql://127.0.0.1:5432/login_db", "neuner9er");
			Connection con = dbmanager.getConnection();
			System.out.println(DBManager.checkUser(con, "eliasneuner", "neuner9er"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}