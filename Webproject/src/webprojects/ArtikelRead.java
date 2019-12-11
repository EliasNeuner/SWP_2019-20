package webprojects;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ReadArtikel
 */
@WebServlet("/ReadArtikel")
public class ArtikelRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String themID = request.getParameter("themenId");
		int themenID = Integer.parseInt(themID);
		DBManager dbmanager = new DBManager();
		Connection con = null;
		ArrayList<Artikel> art = new ArrayList<>();
		try {
			con = dbmanager.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			art = dbmanager.getPostsFromTopic(con, themenID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String jsonResult = gson.toJson(art);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.append(jsonResult);
		out.flush();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtikelRead() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
