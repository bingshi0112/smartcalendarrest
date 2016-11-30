package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

//import com.google.appengine.api.datastore.*;
//import com.google.appengine.api.datastore.Query.Filter;
//import com.google.appengine.api.datastore.Query.FilterPredicate;
//import com.google.appengine.api.datastore.Query.FilterOperator;
//import com.google.appengine.api.datastore.PreparedQuery;

@SuppressWarnings("serial")
public class EmployeeServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		resp.setContentType("application/xml");
		resp.setCharacterEncoding("utf-8");
		
//		String url = "jdbc:mysql://cmpe281projectdatabase.c2cfw1gzdszr.us-west-2.rds.amazonaws.com:3306/cmpe281projectdatabase";  
//		String userName = "SmartCalendar";
//		String password = "CMPE281Project";
//		Connection conn = null;	
//		Statement stat = null;		
//		try{ 		
//			Class.forName("com.mysql.jdbc.Driver").newInstance();  
//			
//			}
//			catch(Exception e){ e.printStackTrace();;} 
//		
//		try {
//			conn = DriverManager.getConnection(url, userName, password);
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//		}
		
		String request = req.getPathInfo();
		
		if (request == null)
		{		
			resp.getWriter().println("get all employees");


			
//			if ( count > 0 )
//			{   			    
//				for (Entity result: pq.asIterable())
//				{
//				
//					
//					
//					String response = "<employee>" + "\n   <id>" + id + "</id>\n   <firstName>" + firstName + "</firstName>\n   <lastName>" + lastName + "</lastName>\n</employee>" ;
//					
//					resp.getWriter().println(response);
//				}
//			}
//			else
//			{
//				resp.setStatus(404);
//			}
		}
		else
		{
			if(request.startsWith("/"))
			{
				int requestId = Integer.parseInt(request.substring(1));
				
				resp.getWriter().println("get employee with id" + requestId);
							
//				String firstName = null;
//				String lastName = null;
//				ResultSet rs = null;
//								
//				try {
//					stat = conn.createStatement(); 
//					String sql = "select * from Employee WHERE id = " + requestId + ";";
//					rs=stat.executeQuery(sql); 
//					
//					while(rs.next())  
//					{
//						firstName = rs.getString("firstName");
//						lastName = rs.getString("lastName");
//					}
//						resp.getWriter().println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//					conn.close();
//				}  catch(SQLException ex) {
//					System.out.println("SQLException: " + ex.getMessage());
//					ex.printStackTrace();
//					
//				} finally {
//					if(rs != null) {
//						try {
//							rs.close();
//						} catch(SQLException ex) {
//							System.out.println("SQLException: " + ex.getMessage());
//							ex.printStackTrace();
//						}
//						
//						rs = null;
//					}
//					
//					if(stat != null) {
//						try {
//							stat.close();
//						}catch(SQLException ex) {
//							System.out.println("SQLException: " + ex.getMessage());
//							ex.printStackTrace();
//						}
//					}
//						
//					if ( firstName != null )
//					{
//						String response = "<employee>" + "\n   <id>" + requestId + "</id>\n   <firstName>" + firstName + "</firstName>\n   <lastName>" + lastName + "</lastName>\n</employee>" ;
//						resp.getWriter().println(response);	
//					}
//					else
//					{
//						resp.setStatus(404);
//					}	
//				}	
			}
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("application/xml");
		resp.setCharacterEncoding("utf-8");
		
		StringBuffer jb = new StringBuffer();
		String line = null;
		String id = null;
		String lastName = null;
		String firstName = null;
		try {
			BufferedReader reader = req.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		} catch (Exception e) { e.printStackTrace(); }
		
		StringBuffer sbuf = jb;
		String str = sbuf.toString();
		
		resp.getWriter().println("post these data to Employee:" + jb);

//		try 
//		{
//		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//		    Node doc = (Node) dBuilder.parse(new InputSource(new StringReader(str)));
//		    ((Document) doc).getDocumentElement().normalize();
//		    NodeList nList = ((Document) doc).getElementsByTagName("employee");
//		    for (int temp = 0; temp < nList.getLength(); temp++) 
//		    {
//		        Node nNode = nList.item(temp);
//		        if (nNode.getNodeType() == Node.ELEMENT_NODE) 
//		        {
//		            Element eElement = (Element) nNode;
//		            id = eElement.getElementsByTagName("id").item(0).getTextContent();
//		            firstName = eElement.getElementsByTagName("firstName").item(0).getTextContent();
//		            lastName = eElement.getElementsByTagName("lastName").item(0).getTextContent();
//		        }
//		    }
//		} 
//		catch (Exception e) 
//		{
//		    e.printStackTrace();
//		}		
//		
//		int Id = Integer.valueOf(id);
//		Filter propertyFilter =
//			    new FilterPredicate("id", FilterOperator.EQUAL, Id);
//		Query q = new Query("Employee").setFilter(propertyFilter);	
//		int count = datastore.prepare(q).countEntities(FetchOptions.Builder.withDefaults());
//		int count = 1;
//		
//		if(count == 0)
//		{		
//			Entity newEmployee = new Entity("Employee");
//			newEmployee.setProperty("firstName", firstName);
//			newEmployee.setProperty("lastName", lastName);
//			newEmployee.setProperty("id", Id);
//			datastore.put(newEmployee);
				
//			resp.getWriter().println("The following entity has been created:"); 		
//			String response = "<employee>" + "\n   <id>" + id + "</id>\n   <firstName>" + firstName + "</firstName>\n   <lastName>" + lastName + "</lastName>\n</employee>" ;			
//			resp.getWriter().println(response);			
//			
//			resp.setStatus(201);
//			resp.addHeader("Location", req.getRequestURI());
//		}
//		else
//		{
//			resp.getWriter().println("The following entity's id has been used:"); 		
//			String response = "<employee>" + "\n   <id>" + id + "</id>" + "\n</employee>" ;			
//			resp.getWriter().println(response);						
//			resp.getWriter().println("\nPlease create your entity with another id."); 
//			resp.setStatus(409);
//			resp.addHeader("Location", req.getRequestURI());
//		}	
	}

	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("application/xml");
		resp.setCharacterEncoding("utf-8");
		
		String request = req.getPathInfo();
		
		if(request.startsWith("/"))
		{
			int requestId = Integer.parseInt(request.substring(1));
			
			StringBuffer jb = new StringBuffer();
			String line = null;
			String lastName = null;
			String firstName = null;
			try {
				BufferedReader reader = req.getReader();
			    while ((line = reader.readLine()) != null)
			      jb.append(line);
			} 
			catch (Exception e) {
				e.printStackTrace(); 
				}
			
			StringBuffer sbuf = jb;
			String str = sbuf.toString();
			
			resp.getWriter().println("update employee" + requestId + "with following information:" + jb);

//			try 
//			{
//			    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			    Node doc = (Node) dBuilder.parse(new InputSource(new StringReader(str)));
//			    ((Document) doc).getDocumentElement().normalize();
//			    NodeList nList = ((Document) doc).getElementsByTagName("employee");
//			    for (int temp = 0; temp < nList.getLength(); temp++) 
//			    {
//			        Node nNode = nList.item(temp);
//			        if (nNode.getNodeType() == Node.ELEMENT_NODE) 
//			        {
//			            Element eElement = (Element) nNode;
//			            lastName = eElement.getElementsByTagName("lastName").item(0).getTextContent();
//			            firstName = eElement.getElementsByTagName("firstName").item(0).getTextContent();
//			        }
//			    }
//			} 
//			catch (Exception e) 
//			{
//			    e.printStackTrace();
//			}		
//			
//			Filter propertyFilter =
//				    new FilterPredicate("id", FilterOperator.EQUAL, requestId);
//			Query q = new Query("Employee").setFilter(propertyFilter);
//			PreparedQuery pq = datastore.prepare(q);			
//			int count = datastore.prepare(q).countEntities(FetchOptions.Builder.withDefaults());
			
//			int count = 1;
//			
//			if(count != 0)
//			{		
//				Entity result = pq.asSingleEntity();
				
//				String response = null;
//				
//				if(lastName == null)
//				{
//					result.setProperty("firstName", firstName);
//					response = "<employee>" + "\n   <firstName>" + firstName + "</firstName>" + "\n</employee>";
//				}
//				else{
//					if(firstName == null)
//					{
//						result.setProperty("lastName", lastName);
//						response = "<employee>" + "\n   <lastName>" + lastName + "</lastName>" + "\n</employee>";
//					}
//					else
//					{
//						result.setProperty("firstName", firstName);
//						result.setProperty("lastName", lastName);
//						response = "<employee>" + "\n   <firstName>" + firstName + "</firstName>\n   <lastName>" + lastName + "</lastName>\n</employee>" ;
//					}
//				}
//				datastore.put(result);
									
//				resp.getWriter().println("The following entity has been updated:"); 										
//				resp.getWriter().println(response);			
//
//			}
//			else
//			{
//				resp.getWriter().println("The following entity's id has was not found:"); 		
//				String response = "<employee>" + "\n   <id>" + requestId + "</id>" + "\n</employee>" ;			
//				resp.getWriter().println(response);	
//				
//				resp.getWriter().println("\nPlease modify your entity with correct id."); 
//				resp.setStatus(404);
//			}			
		}
	}

	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("application/xml");
		resp.setCharacterEncoding("utf-8");

		String request = req.getPathInfo();
		
		if(request.startsWith("/"))
		{
			int requestId = Integer.parseInt(request.substring(1));
			
			resp.getWriter().println("Delete employee with id " + requestId);
			
//			Filter propertyFilter =
//				    new FilterPredicate("id", FilterOperator.EQUAL, requestId);
//			Query q = new Query("Employee").setFilter(propertyFilter);
//			PreparedQuery pq = datastore.prepare(q);			
//			int count = datastore.prepare(q).countEntities(FetchOptions.Builder.withDefaults());
			
//			int count = 2;
			
//			if(count != 0)
//			{				
//				resp.getWriter().println("The following entity has been deleted:"); 					
//				for (Entity result: pq.asIterable())
//				{				
//					Object id = result.getProperty ("id");
//					String firstName = (String) result.getProperty ("firstName");
//					String lastName = (String) result.getProperty ("lastName");	
//					
//					String response = "<employee>" + "\n   <id>" + id + "</id>\n   <firstName>" + firstName + "</firstName>\n   <lastName>" + lastName + "</lastName>\n</employee>" ;					
//					resp.getWriter().println(response);			
//					
//					Key employeeKey = result.getKey();
//					datastore.delete(employeeKey);
//				}				
//			}
//			else
//			{
//				resp.getWriter().println("The following entity's id was not found:"); 		
//				String response = "<employee>" + "\n   <id>" + requestId + "</id>" + "\n</employee>" ;			
//				resp.getWriter().println(response);	
//				
//				resp.getWriter().println("\nPlease delete with correct id."); 
//				resp.setStatus(404);
//			}			
		}
	}


	public static String getEmployeeFirstName(int id, Connection conn) {
		
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			String query = "SELECT firstName FROM " + "Employee" + " WHERE " + id + "=" + id + ";"; 
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			 
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
			
			ArrayList<String> al = new ArrayList<String>();
			while(rs.next()) {
				ArrayList<String> rowRecord = new ArrayList<String>();
				for(int i = 1; i <= columns; i++) {
					String value = rs.getString(i);
					rowRecord.add(value);
				}
				String rowValue = String.join(": ", rowRecord); // supported in Java 8 or later
				al.add(rowValue);
			}
			
			result = String.join("\n", al);
			
		} catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
			
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException ex) {
					System.out.println("SQLException: " + ex.getMessage());
					ex.printStackTrace();
				}
				
				rs = null;
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException ex) {
					System.out.println("SQLException: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
		
		return result;	
	}
	
	public static String getEmployeeLastName(int id, Connection conn) {
		
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			String query = "SELECT lastName FROM " + "Employee" + " WHERE " + id + "=" + id + ";"; 
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			 
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
			
			ArrayList<String> al = new ArrayList<String>();
			while(rs.next()) {
				ArrayList<String> rowRecord = new ArrayList<String>();
				for(int i = 1; i <= columns; i++) {
					String value = rs.getString(i);
					rowRecord.add(value);
				}
				String rowValue = String.join(": ", rowRecord); // supported in Java 8 or later
				al.add(rowValue);
			}
			
			result = String.join("\n", al);
			
		} catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
			
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException ex) {
					System.out.println("SQLException: " + ex.getMessage());
					ex.printStackTrace();
				}
				
				rs = null;
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException ex) {
					System.out.println("SQLException: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
		
		return result;	
	}
public static void postEmployee(int id, String firstName, String lastName, Connection conn) {
		
		Statement stmt = null;
		
		try {
			String query = "INSERT INTO cmpe281projectdatabase." + "Employee" + "(id, firstName, lasstName) "
					+ " VALUES ('"+ id + "', '" + firstName + "', '" + lastName + "');";
			
//			System.out.println(query);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
		} catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException ex) {
					System.out.println("SQLException: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
	}


}