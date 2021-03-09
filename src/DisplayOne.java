import java.util.*;
import java.sql.*;

public class DisplayOne {

	private static Connection con;
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

	public static void displayOne() throws SQLException {
		try {
			con = DBconnect.getConnection();
			s = con.createStatement();
			num = in.nextInt();
			if (check(num) == 0)
				throw new UserException();
			r = s.executeQuery("select * from employee");
			while (r.next()) {
				if (r.getInt(1) == num) {
					System.out.println("employee no:" + r.getInt(1) + " \n"
							+ "name :" + r.getString(2) + r.getString(3) + "\n"
							+ "date :" + r.getDate(4) + "\n" + "designation :"
							+ r.getString(5) + "\n" + "department :"
							+ r.getString(6) + "\n" + "salary :" + r.getInt(7));
				}
			}
			r = s.executeQuery("select * from Employee_Personal_Info");
			while (r.next()) {
				if (r.getInt(1) == num) {
					System.out.println("date :" + r.getDate(2) + "\n"
							+ "educationalqualification :" + r.getString(3)
							+ "\n" + "1st lane :" + r.getString(4) + "\n"
							+ "2nd lane:" + r.getString(5) + "\n" + "city:"
							+ r.getString(6) + "\n" + "pin:" + r.getInt(7)
							+ "phone  : " + r.getInt(8));
				}
				r.close();
				s.close();
				con.close();
				Record.getList();
			}
		} catch (SQLException e) {
			System.out.println(e);
			Record.getList();
		} catch (UserException e) {
			System.out.println(e);
			Record.getList();
		}
	}
}
