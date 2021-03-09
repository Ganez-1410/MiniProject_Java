import java.sql.*;
import java.util.*;

public class DeleteRecord {

	private static Connection con;
	private static PreparedStatement p;
	private static Statement s;
	private static int num;
	private static ResultSet r;
	private static Scanner in = new Scanner(System.in);

	public static int check(int num) {
		try {
			con = DBconnect.getConnection();
			s = con.createStatement();
			r = s.executeQuery("select * from employee");

			while (r.next()) {
				if (r.getInt(1) == num) {
					return 1;
				} else {
					return 0;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public static void deleteRecord() {
		try {
			con = DBconnect.getConnection();
			num = in.nextInt();
			if (check(num) == 0)
				throw new UserException();
			
			System.out.println("Do you want to delete?");
			char ch = in.next().charAt(0);
			if ('y' == ch || 'Y' == ch) {
				p = con.prepareStatement("delete from employee where emp_no=?");
				p.setInt(1, num);
				p.execute();
				p = con.prepareStatement("delete from Employee_Personal_Info where emp_no=?");
				p.setInt(1, num);
				p.execute();
				System.out.println("deletion successfull");
				Record.getList();
			}
		} catch (SQLException e) {
			System.out.println(e);
			//Record.getList();
		} catch (UserException e) {
			System.out.println("deletion failed");
			//Record.getList();
		}
	}
}
