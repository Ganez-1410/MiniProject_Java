import java.sql.*;

public class DisplayAll {
	private static Connection con;
	private static Statement s;
	private static ResultSet r;
	private static ResultSet r1;
	
	public static void displayAll() throws SQLException {
		try {
			con = DBconnect.getConnection();
			s = con.createStatement();
			r = s.executeQuery("select * from employee");
			// r1=s.executeQuery("select * from Employee_Personal_Info");
			int net_pay;
			System.out.println("emp no" + "\t" + "    name     " 
					+ "\t" + "designation" + "\t" + "dept" + "\t" + "net pay");

			while (r.next()) {
				int d = r.getInt(1);
				net_pay = (int) (d + (d * 0.20) + (d * 0.40) - (d * 0.10));
				System.out.println(d + "  \t" + r.getString(2) + r.getString(3)
						+ "\t\t" + r.getString(5) + "\t" + r.getString(6)
						+ "\t" + net_pay);

			}
			r.close();
			s.close();
			con.close();
		     Record.getList();
		} catch (SQLException e) {
			System.out.println(e);
			Record.getList();
		}

	}
}
