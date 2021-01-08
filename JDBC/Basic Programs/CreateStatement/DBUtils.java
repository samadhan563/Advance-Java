package utils;
import java.sql.*;

public interface DBUtils 
{
	static Connection fetchDBConnection() throws ClassNotFoundException, SQLException
	{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root","0904");		
	}
}
