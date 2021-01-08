package tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import static utils.DBUtils.*;

public class TestPrepareStatement {

	public static void main(String[] args) {
		String sql = "select * from my_emp where deptid=? and join_date > ?";
		try (Scanner sc = new Scanner(System.in);
				// cn
				Connection cn = fetchDBConnection();
				// 1 time jobs : creating PST
				PreparedStatement pst = cn.prepareStatement(sql);

		) {
			// keep on accepting i/ps from user till user types "quit"
			while (true) {
				System.out.println("Enter dept id n join date or type quit to exit from the app");
				String dept = sc.next();
				if (dept.equalsIgnoreCase("quit"))
					break;
				Date joinDate = Date.valueOf(sc.next());
				// set IN params : 2
				pst.setString(1, dept);
				pst.setDate(2, joinDate);
				// execute query n process RST
				try (ResultSet rst = pst.executeQuery()) {
					// RST cursor : before the 1st row
					while (rst.next()) // id name addr salary dept id join date
						System.out.printf("ID %d Name %s Address %s Salary %.1f Dept %s Join Date %s %n ",
								rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5),
								rst.getDate(6));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
