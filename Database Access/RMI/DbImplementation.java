import java.rmi.*;
import java.sql.*;
import java.rmi.server.*;
public class DbImplementation extends UnicastRemoteObject implements IDb
{
	String sql,str=" ";
	public DbImplementation() throws RemoteException
	{}
	public String getData(String sql)
	{
		this.sql=sql;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn=DriverManager.getConnection("jdbc:odbc:STD1");	
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				int i=rs.getInt(1);
				String n=rs.getString(2);
				int p=rs.getInt(3);
				int c=rs.getInt(4);
				int m=rs.getInt(5);
				System.out.println(""+i+""+n+""+p+""+c+""+m);
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}	
}