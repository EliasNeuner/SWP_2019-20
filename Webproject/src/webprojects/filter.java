package webprojects;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class filter1
 */
@WebFilter("/filter1")
public class filter implements Filter {
    /**
     * Default constructor. 
     */
    public filter() {
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	
	//private servletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		//this.context = fConfig.getServletContext();
		//this.context.log("AuthentificationFilter initialized!");
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		//this.context.log("Requested Ressource: " + uri);
		
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			Object o = session.getAttribute("benutzer");
			if(o != null) {
				chain.doFilter(request, response);
			}
			else {
				res.sendRedirect("login2.jsp");
			}
		}
	}

}
