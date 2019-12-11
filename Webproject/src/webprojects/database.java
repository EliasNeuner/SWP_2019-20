package webprojects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class database {
	/*
	private database() {}
	private static database instance;
	public static database getInstance() {
		if(instance == null) {
			instance = new database();
		}
		return instance;
	}
	
	private String usr = "postgres";
	private String pwd = "postgres";
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://127.0.0.1:5432/blog";
	
	public void init() throws ClassNotFoundException {
		Class.forName(this.driver);
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, usr, pwd);
	}
	
	public void releaseConnection (Connection con) throws SQLException {
		if(con != null && ! con.isClosed()) {
			con.close();
		}
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {}
	
	public static boolean checkUser(Connection con, String username, String password) throws SQLException, ClassNotFoundException {
		String sql = "Select * from users where user_name = ?"; 
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rts = pstm.executeQuery();
		
		while(rts.next()) {
			int id = rts.getInt("user_ID");
			String user_name = rts.getString("user_name");
			String email = rts.getString("email");
			String pwd = rts.getString("pwd");
			
			if(user_name.contentEquals(username) && pwd.contentEquals(password)) {
				return true;
			}
			else {
				return false;
			}
			
		}
		return false;
	}
	
	public static void addUser(String username, String email, String pwd) throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/blog", "postgres", "postgres");
		String string = "Insert into users(user_name, email, pwd) values(?,?,?)";
		PreparedStatement pstm = con.prepareStatement(string);
		
		try {
			pstm.setString(1, username);
			pstm.setString(2, email);
			pstm.setString(3, pwd);
			pstm.executeUpdate();
			pstm.close();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	*/
}
