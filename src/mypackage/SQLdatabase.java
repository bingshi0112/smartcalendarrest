package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLdatabase {
	
	public static void main(String[] args) {
//		SQLdatabase database = new SQLdatabase();
		
//		Connection conn = database.connect();
		
//		String user0info = getUserCalendarInTimePeriod("TESTUSER0", "2016-10-20 00:00:00", "2016-11-01 00:00:00", conn);
//		System.out.println(user0info);

//		postEmployee( 1, "1990-03-10 05:30:00.0000", "2020-03-13 05:40:00.0000", conn);
		
		/*******DISCONNECT:  NOT UNTIL GRADED********/
	}
	
	public Connection connect() {
		String url = "jdbc:mysql://cmpe281projectdatabase.c2cfw1gzdszr.us-west-2.rds.amazonaws.com:3306/cmpe281projectdatabase";  
		String userName = "SmartCalendar";
		String password = "CMPE281Project";
		String driver = "com.mysql.jdbc.Driver";
		Connection connection = null;
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to the database.");
			
		} catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return connection;
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

}
