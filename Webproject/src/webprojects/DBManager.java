package webprojects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

	public Connection getConnection() throws SQLException {
		System.out.println("url = " + url);
		System.out.println("DBuser = " + DBuser);
		System.out.println("pwd = " + pwd);
		Connection con = DriverManager.getConnection(url, DBuser, pwd);
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

	public void addUser(Connection con, String username, String email, String pwd)
			throws SQLException, ClassNotFoundException {
		String string = "Insert into users(user_name, email, pwd) values(?,?,?)";
		PreparedStatement pstm = con.prepareStatement(string);

		try {
			pstm.setString(1, username);
			pstm.setString(2, email);
			pstm.setString(3, pwd);
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<topic> getAllTopics(Connection con) throws SQLException {
		ArrayList<topic> topics = new ArrayList<>();
		String sql = "Select * from topic";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rts = pstm.executeQuery();

		while (rts.next()) {
			int id = rts.getInt(1);
			String name = rts.getString(2);
			topic t = new topic(id, name);
			topics.add(t);
		}
		return topics;
	}

	public ArrayList<Artikel> getAllPosts(Connection con) throws SQLException {
		ArrayList<Artikel> posts = new ArrayList<>();
		String sql = "Select * from post";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rts = pstm.executeQuery();

		while (rts.next()) {
			int postid = rts.getInt("post_id");
			String head = rts.getString("post_headline");
			String text = rts.getString("post_text");
			Artikel a = new Artikel(postid, head, text);
			posts.add(a);
		}
		return posts;
	}

	public ArrayList<Artikel> getPostsFromTopic(Connection con, int themenID) throws SQLException {
		ArrayList<Artikel> a = new ArrayList<>();
		String sql = "Select * from post where topic_id = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, themenID);
		ResultSet rts = pstm.executeQuery();

		while (rts.next()) {
			int postid = rts.getInt("post_id");
			String head = rts.getString("post_headline");
			String text = rts.getString("post_text");
			Artikel artikel = new Artikel(postid, head, text);
			a.add(artikel);
		}
		return a;
	}

	public boolean checkUser(Connection con, String username, String password)
			throws SQLException, ClassNotFoundException {
		String sql = "Select * from users where user_name = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rts = pstm.executeQuery();

		while (rts.next()) {
			int id = rts.getInt("user_ID");
			String user_name = rts.getString("user_name");
			String email = rts.getString("email");
			String pwd = rts.getString("pwd");

			if (user_name.contentEquals(username) && pwd.contentEquals(password)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
