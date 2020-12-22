package connection.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args)
	{
		System.out.println("Creating Connection");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","0904");
			Statement st=conn.createStatement();
			
			
			String query0="drop table if exists emp20";
			int x=st.executeUpdate(query0);
			System.out.println("Table is droped");
			
			String query1="Create table if not exists emp20(eid int primary key,ename varchar(5),esal decimal(5,2))";
			x=st.executeUpdate(query1);	
			System.out.println("Table is created");
			
			String query3="alter table emp20 modify esal double";
			x=st.executeUpdate(query3);
			System.out.println("Table is altered");
			
			String query2="insert into emp20 values(101,'Samad',2000),(102,'Rohit',2000),(103,'Vinod',2500)";
			x=st.executeUpdate(query2);
			System.out.println("Data inserted");
			
			System.out.println("Data in Table");
			String query4="select * from emp20";		
			ResultSet rs1=st.executeQuery(query4);
			while(rs1.next())
			{
				System.out.println(""+rs1.getInt(1)+"  "+rs1.getString("ename")+"  "+rs1.getDouble(3)+"");		
			}
			String q5="update emp20 set ename='sama' where eid=101";
			st.executeUpdate(q5);
			
			String q6="select * from emp20";
			rs1=st.executeQuery(q6);
			System.out.println("Data after updation");
			while(rs1.next())
			{
				System.out.println(""+rs1.getInt(1)+"  "+rs1.getString("ename")+"  "+rs1.getDouble(3)+"");
			}
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

}
