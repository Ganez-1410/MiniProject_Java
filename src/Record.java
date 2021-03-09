import java.sql.*;
import java.util.Scanner;
public class Record {
	
public static Scanner in=new Scanner(System.in);

public static void getList()throws SQLException{

	System.out.println("1.add a record\n2.delete \n3.modify \n4. display a single record\n5.display all\n6.exit");

	System.out.println("....................................make a choice..................................................");

	int ch=in.nextInt();
switch(ch)
{
case 1: AddRecord.addRecord();
        break;
case 2:DeleteRecord.deleteRecord();
       break;
case 3:Modify.modifyData();
       break;
case 4:DisplayOne.displayOne();
       break;
case 5:DisplayAll.displayAll();
       break;
default:System.out.println("Thank you for using this application");
       System.exit(0);
}
}
public static void main(String a[])throws SQLException
{
	Connection con=DBconnect.getConnection();
	if(con!=null)
	{
		System.out.println("connection established ( :");
	}
	else
	{
		System.out.println("connection not established ):");
	}
     getList();
 
}
}
