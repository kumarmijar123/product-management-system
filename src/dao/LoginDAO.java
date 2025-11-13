package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbutil.DBUtil;
import pojo.LoginInfo;

public class LoginDAO {

	public static boolean isUserValid(LoginInfo userDetails)
	{
		boolean validStatus = false;
		try
		{
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();	
			ResultSet rs= st.executeQuery("SELECT * FROM logininfo WHERE userName = '"+userDetails.getUserName()+"' AND password = '"+userDetails.getPassword()+"'");
			while(rs.next())
			{
				validStatus = true;
			}
			
			rs.close();
			st.close();
			DBUtil.closeConnection(conn);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return validStatus;
	}
}
