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



@SuppressWarnings("serial")
public class ProjectServlet2 extends HttpServlet 
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
			resp.getWriter().println("get all projects");


			
//			if ( count > 0 )
//			{   			    
//				for (Entity result: pq.asIterable())
//				{
//				
//					
//					
//					String response = "<project>" + "\n   <id>" + id + "</id>\n   <budget>" + budget + "</budget>\n   <name>" + name + "</name>\n</project>" ;
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
				
				resp.getWriter().println("get project with id" + requestId);
							
//				String budget = null;
//				String name = null;
//				ResultSet rs = null;
//								
//				try {
//					stat = conn.createStatement(); 
//					String sql = "select * from Project WHERE id = " + requestId + ";";
//					rs=stat.executeQuery(sql); 
//					
//					while(rs.next())  
//					{
//						budget = rs.getString("budget");
//						name = rs.getString("name");
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
//					if ( budget != null )
//					{
//						String response = "<project>" + "\n   <id>" + requestId + "</id>\n   <budget>" + budget + "</budget>\n   <name>" + name + "</name>\n</project>" ;
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
		String name = null;
		String budget = null;
		try {
			BufferedReader reader = req.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		} catch (Exception e) { e.printStackTrace(); }
		
		StringBuffer sbuf = jb;
		String str = sbuf.toString();
		
		resp.getWriter().println("post these data to Project:" + jb);

//		try 
//		{
//		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//		    Node doc = (Node) dBuilder.parse(new InputSource(new StringReader(str)));
//		    ((Document) doc).getDocumentElement().normalize();
//		    NodeList nList = ((Document) doc).getElementsByTagName("project");
//		    for (int temp = 0; temp < nList.getLength(); temp++) 
//		    {
//		        Node nNode = nList.item(temp);
//		        if (nNode.getNodeType() == Node.ELEMENT_NODE) 
//		        {
//		            Element eElement = (Element) nNode;
//		            id = eElement.getElementsByTagName("id").item(0).getTextContent();
//		            budget = eElement.getElementsByTagName("budget").item(0).getTextContent();
//		            name = eElement.getElementsByTagName("name").item(0).getTextContent();
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
//		Query q = new Query("Project").setFilter(propertyFilter);	
//		int count = datastore.prepare(q).countEntities(FetchOptions.Builder.withDefaults());
//		int count = 1;
//		
//		if(count == 0)
//		{		
//			Entity newProject = new Entity("Project");
//			newProject.setProperty("budget", budget);
//			newProject.setProperty("name", name);
//			newProject.setProperty("id", Id);
//			datastore.put(newProject);
				
//			resp.getWriter().println("The following entity has been created:"); 		
//			String response = "<project>" + "\n   <id>" + id + "</id>\n   <budget>" + budget + "</budget>\n   <name>" + name + "</name>\n</project>" ;			
//			resp.getWriter().println(response);			
//			
//			resp.setStatus(201);
//			resp.addHeader("Location", req.getRequestURI());
//		}
//		else
//		{
//			resp.getWriter().println("The following entity's id has been used:"); 		
//			String response = "<project>" + "\n   <id>" + id + "</id>" + "\n</project>" ;			
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
			String name = null;
			String budget = null;
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
			
			resp.getWriter().println("update project" + requestId + "with following information:" + jb);

//			try 
//			{
//			    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			    Node doc = (Node) dBuilder.parse(new InputSource(new StringReader(str)));
//			    ((Document) doc).getDocumentElement().normalize();
//			    NodeList nList = ((Document) doc).getElementsByTagName("project");
//			    for (int temp = 0; temp < nList.getLength(); temp++) 
//			    {
//			        Node nNode = nList.item(temp);
//			        if (nNode.getNodeType() == Node.ELEMENT_NODE) 
//			        {
//			            Element eElement = (Element) nNode;
//			            name = eElement.getElementsByTagName("name").item(0).getTextContent();
//			            budget = eElement.getElementsByTagName("budget").item(0).getTextContent();
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
//			Query q = new Query("Project").setFilter(propertyFilter);
//			PreparedQuery pq = datastore.prepare(q);			
//			int count = datastore.prepare(q).countEntities(FetchOptions.Builder.withDefaults());
			
//			int count = 1;
//			
//			if(count != 0)
//			{		
//				Entity result = pq.asSingleEntity();
				
//				String response = null;
//				
//				if(name == null)
//				{
//					result.setProperty("budget", budget);
//					response = "<project>" + "\n   <budget>" + budget + "</budget>" + "\n</project>";
//				}
//				else{
//					if(budget == null)
//					{
//						result.setProperty("name", name);
//						response = "<project>" + "\n   <name>" + name + "</name>" + "\n</project>";
//					}
//					else
//					{
//						result.setProperty("budget", budget);
//						result.setProperty("name", name);
//						response = "<project>" + "\n   <budget>" + budget + "</budget>\n   <name>" + name + "</name>\n</project>" ;
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
//				String response = "<project>" + "\n   <id>" + requestId + "</id>" + "\n</project>" ;			
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
			
			resp.getWriter().println("Delete project with id " + requestId);
			
//			Filter propertyFilter =
//				    new FilterPredicate("id", FilterOperator.EQUAL, requestId);
//			Query q = new Query("Project").setFilter(propertyFilter);
//			PreparedQuery pq = datastore.prepare(q);			
//			int count = datastore.prepare(q).countEntities(FetchOptions.Builder.withDefaults());
			
//			int count = 2;
			
//			if(count != 0)
//			{				
//				resp.getWriter().println("The following entity has been deleted:"); 					
//				for (Entity result: pq.asIterable())
//				{				
//					Object id = result.getProperty ("id");
//					String budget = (String) result.getProperty ("budget");
//					String name = (String) result.getProperty ("name");	
//					
//					String response = "<project>" + "\n   <id>" + id + "</id>\n   <budget>" + budget + "</budget>\n   <name>" + name + "</name>\n</project>" ;					
//					resp.getWriter().println(response);			
//					
//					Key projectKey = result.getKey();
//					datastore.delete(projectKey);
//				}				
//			}
//			else
//			{
//				resp.getWriter().println("The following entity's id was not found:"); 		
//				String response = "<project>" + "\n   <id>" + requestId + "</id>" + "\n</project>" ;			
//				resp.getWriter().println(response);	
//				
//				resp.getWriter().println("\nPlease delete with correct id."); 
//				resp.setStatus(404);
//			}			
		}
	}


	public static String getProjectFirstName(int id, Connection conn) {
		
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			String query = "SELECT budget FROM " + "Project" + " WHERE " + id + "=" + id + ";"; 
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
	
	public static String getProjectLastName(int id, Connection conn) {
		
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			String query = "SELECT name FROM " + "Project" + " WHERE " + id + "=" + id + ";"; 
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
public static void postProject(int id, String budget, String name, Connection conn) {
		
		Statement stmt = null;
		
		try {
			String query = "INSERT INTO cmpe281projectdatabase." + "Project" + "(id, budget, lasstName) "
					+ " VALUES ('"+ id + "', '" + budget + "', '" + name + "');";
			
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