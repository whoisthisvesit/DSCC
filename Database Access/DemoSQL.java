import java.sql.*;
import java.lang.*;
public class DemoSQL
{
	public static void main(String args[])
	{
		Connection con=null;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:STD");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Result");
			while(rs.next())
			{
				int i=rs.getInt(1);
				String n=rs.getString(2);
				int p=rs.getInt(3);
				int c=rs.getInt(4);
				int m=rs.getInt(5);
				System.out.println(""+i+""+n+""+p+""+c+""+m);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{}		
		}
	}
}