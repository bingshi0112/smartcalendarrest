package mypackage;

import java.io.IOException;

//import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HelloWorldServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Welcome to Rest Server, please following the instructions to interact with your database, have fun!");
	}
}

//public class HelloWorldServlet extends HttpServlet {
//	 
//	  private String message;
//
//	  public void init() throws ServletException
//	  {
//	      // Do required initialization
//	      message = "Welcome to Rest Server, please following the instructions to interact with your database, have fun!";
//	  }
//
//	  public void doGet(HttpServletRequest request,
//	                    HttpServletResponse response)
//	            throws ServletException, IOException
//	  {
//	      // Set response content type
//	      response.setContentType("text/html");
//
//	      // Actual logic goes here.
//	      PrintWriter out = response.getWriter();
//	      out.println("<h1>" + message + "</h1>");
//	  }
//	  
//	  public void destroy()
//	  {
//	      // do nothing.
//	  }
//	}