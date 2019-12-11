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
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static DBManager dbmanager = DBManager.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		
		try {
			Connection con = dbmanager.getConnection();
			try {
				dbmanager.addUser(con, user, email, pwd);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		session.setAttribute("benutzer", user);
		request.setAttribute("benutzer", user);
		ArrayList<topic> t = new ArrayList<>();
		ArrayList<Artikel> po = new ArrayList<>();
		try {
		Connection c = dbmanager.getConnection();
		t = dbmanager.getAllTopics(c);
		po = dbmanager.getAllPosts(c);
		request.setAttribute("topics", t);
		request.setAttribute("posts", po);
		}
		catch(SQLException e2) {
			e2.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("startseite.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
