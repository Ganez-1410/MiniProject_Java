import java.sql.*;
import java.sql.Date;
import java.util.*;
public class Modify {
	private static Connection con;
	private static PreparedStatement p;
	private static Scanner in = new Scanner(System.in);
	private static int empno;
	private static String name;
	private static String date;
	private static int salary;
	private static int ch;
	private static ResultSet r;
	private static Statement s;

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
			s.close();
			r.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public static void modifyData() throws SQLException {
		try {
			empno = in.nextInt();
			if (check(empno) == 0)
				throw new UserException();

			con = DBconnect.getConnection();

			System.out
					.println("\n1. firstname\n2. lastname\n 3. join date\n 4.designation\n 5. department\n 6.basic salary");
			ch = in.nextInt();
			int i = 0;
			switch (ch) {
			case 1: {
				p = con.prepareStatement("update Employee    set  first_name=?   where emp_no=?");
				name = in.next();
				empno = in.nextInt();
				p.setString(1, name);
				p.setInt(2, empno);
				i = p.executeUpdate();
				break;
			}
			case 2: {
				p = con.prepareStatement("update Employee"
						+ "set  last_name=?   where emp_no=?");
				name = in.next();
				empno = in.nextInt();
				p.setString(1, name);
				p.setInt(2, empno);
				i = p.executeUpdate();
				break;
			}
			case 3: {
				p = con.prepareStatement("update Employee  set  join_date=?    where emp_no=?");

				empno = in.nextInt();
				date = in.next();
				p.setDate(1, Date.valueOf(date));
				p.setInt(2, empno);
				i = p.executeUpdate();
				break;
			}
			case 4: {
				p = con.prepareStatement("update Employee   set  designation=?   where emp_no=?");
				name = in.next();
				empno = in.nextInt();

				p.setString(1, name);
				p.setInt(2, empno);
				i = p.executeUpdate();
				break;
			}
			case 5: {
				p = con.prepareStatement("update Employee   set  dept=?    where emp_no=?");
				name = in.next();
				empno = in.nextInt();

				p.setString(1, name);
				p.setInt(2, empno);
				i = p.executeUpdate();
				break;
			}
			case 6: {
				p = con.prepareStatement("update Employee  set  basic_salary=?    where emp_no=?");
				salary = in.nextInt();
				empno = in.nextInt();

				p.setInt(1, salary);
				p.setInt(2, empno);
				i = p.executeUpdate();
				break;
			}
			}
			p.close();
			con.close();
			if (i >= 1) {
				System.out.println("its is successfully modified!");
			} else {
				System.out.println("its is not successfully modified):");
			}
			Record.getList();
		} catch (SQLException e) {
			System.out.println(e);
			Record.getList();
		} catch (UserException e) {
			System.out.println("there no such employee number ): ");
			Record.getList();
		}
	}
}
