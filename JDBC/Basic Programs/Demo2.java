package connection.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {

	public static void main(String[] args)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","0904");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from emp");
			System.out.println("EMPNO  ENAME	 JOB        MGR   HIREDATE    SAL      COMM     DEPTNO");
			while(rs.next())
			{							
				String str = String.format("%-5d %-10s %-10s %-5d %tD  %6.2f %-6.2f %-5d", rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getDate(5)
						,rs.getDouble(6),rs.getDouble(7),rs.getInt(8));
				System.out.println(str);
				//System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t "+rs.getString(3)+"\t "+rs.getInt(4)+"\t "+rs.getDate(5)+"\t "
					//	+ " "+rs.getDouble(6)+"\t "+rs.getDouble(7)+"\t "+rs.getInt(8));
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
