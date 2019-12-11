package webprojects;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplContextListener
 *
 */

@WebListener
public class ApplContextListener implements ServletContextListener {
	
    /**
     * Default constructor. 
     */
    public ApplContextListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext svc = sce.getServletContext();
		
		String DBuser = svc.getInitParameter("DBUser");
		String DBdriver = svc.getInitParameter("DBDriver");
		String pwd = svc.getInitParameter("pwd");
		String url = svc.getInitParameter("url");
		
		DBManager dbmanager = DBManager.getInstance();
		try {
			dbmanager.init(DBdriver, DBuser, url, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
}
