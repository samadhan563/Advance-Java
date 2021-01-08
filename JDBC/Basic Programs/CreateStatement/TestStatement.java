package tester;

import static utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatement {

	public static void main(String[] args) 
	{
		String query = "select empid,name,salary,join_date from my_emp order by salary desc";
		try (Connection con = fetchDBConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next())
				System.out.printf("ID %d Name %s Salary %.1f Joined on %s %n", rs.getInt(1), 
						rs.getString(2),rs.getDouble(3),rs.getDate(4));

		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
