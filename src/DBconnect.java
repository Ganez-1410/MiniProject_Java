import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnect {
	private static Connection c;
	public static Connection getConnection(){
	try{
	Class.forName("com.mysql.jdbc.Driver");
	c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","helloworld");
	return c;
	}
	catch(ClassNotFoundException e)
	{
	e.printStackTrace();
	 return null;
	}
	catch(SQLException e){
	e.printStackTrace();
	return null;
	}
  }
}
