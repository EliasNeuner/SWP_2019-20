package webprojects;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login1
 */
@WebServlet("/login1")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
	
	static DBManager db = DBManager.getInstance();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		Connection con = null;
		
		try {
			try {
				con = db.getConnection();
				if(db.checkUser(con, user, pwd) == true) {
					request.setAttribute("benutzer", user);
					session.setAttribute("benutzer", user);
					ArrayList<topic> t = new ArrayList<>();
					ArrayList<Artikel> p = new ArrayList<>();
						t = db.getAllTopics(con);
						p = db.getAllPosts(con);
					request.setAttribute("topics", t);
					request.setAttribute("posts", p);
					
					RequestDispatcher rd = request.getRequestDispatcher("startseite.jsp");
					rd.forward(request,  response);
				}
				
				else {
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request,  response);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			db.dropConnection(con);
		}
	}
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	}

}
