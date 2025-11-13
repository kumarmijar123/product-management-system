package dbutil;

import java.sql.*;

public class DBUtil {

	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Connection conn = null;
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagementsystem", "root", "123@12Kumar");
		
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
	
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
