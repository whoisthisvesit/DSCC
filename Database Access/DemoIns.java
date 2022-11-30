import java.sql.*;
public class DemoIns
{
	public static void main(String args[])
	{
		Connection con=null;
		try
		{
			DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
			con=DriverManager.getConnection("jdbc:odbc:STD");
			PreparedStatement pstmt=con.prepareStatement("insert into Result values (?,?,?,?,?)");
			pstmt.setInt(1,Integer.parseInt(args[0]));
			pstmt.setString(2,args[1]);
			pstmt.setInt(3,Integer.parseInt(args[2]));
			pstmt.setInt(4,Integer.parseInt(args[3]));
			pstmt.setInt(5,Integer.parseInt(args[4]));
			int i=pstmt.executeUpdate();
			System.out.println(""+i+"row(s) inserted");
		}
		catch(Exception e)
		{}
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