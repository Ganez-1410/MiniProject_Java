import java.sql.*;
import java.util.Scanner;

public class AddRecord {
	
	private static PreparedStatement st;
	private static Connection con;
	private static String s;
	private static int i;
	private static int j;
	private static Scanner in = new Scanner(System.in);

	public static void addRecord() {
		try {
			con = DBconnect.getConnection();
			st = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			System.out.println("ENTER YOUR EMPLOYEE NUMBER :");
			i = in.nextInt();
			st.setInt(1, i);
			System.out.println("ENTER YOUR FIRST NAME :");
			s = in.next();
			st.setString(2, s);
			System.out.println("ENTER YOUR LAST NAME :");
			s = in.next();
			st.setString(3, s);
			System.out.println("ENTER CURRENT DATE :");
			s = in.next();
			st.setDate(4, java.sql.Date.valueOf(s));
			System.out.println("ENTER YOUR DESIGNATION :");
			s = in.next();
			st.setString(5, s);
			System.out.println("ENTER YOUR DEPARTMENT :");
			s = in.next();
			st.setString(6, s);
			System.out.println("ENTER YOUR BASIC SALARY :");
			j = in.nextInt();
			st.setInt(7, j);
			int row = st.executeUpdate();
			if (row == 0) {
				Record.getList();
			} else {
				System.out
						.println("the employee table has been created successfully");
			}

			st = con.prepareStatement("insert into Employee_Personal_Info values(?,?,?,?,?,?,?,?)");
			st.setInt(1, i);
			System.out.println("ENTER YOUR DOB :");
			s = in.next();
			st.setDate(2, Date.valueOf(s));
			System.out.println("ENTER YOUR EDUCATIONAL QUALIFICATION :");
			s = in.next();
			st.setString(3, s);
			System.out.println("ENTER YOUR 1st LANE :");
			s = in.next();
			st.setString(4, s);
			System.out.println("ENTER YOUR 2nd LANE :");
			s = in.next();
			st.setString(5, s);
			System.out.println("ENTER YOUR CITY :");
			s = in.next();
			st.setString(6, s);
			System.out.println("ENTER YOUR PIN :");
			j = in.nextInt();
			st.setInt(7, j);
			System.out.println("ENTER YOUR PHONE :");
			j = in.nextInt();
			st.setInt(8, j);
			row = st.executeUpdate();
			if (row == 0) {
				Record.getList();
			} else {
				
                                System.out.println("the employee table has been created successfully");
				Record.getList();
			}
			con.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("not inserted properly");
		}
	}
}
