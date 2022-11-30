import java.rmi.*;
import java.net.*;
import java.rmi.server.*; //used to make skelleton.
import java.sql.*;
public class DbImplementation extends UnicastRemoteObject implements InterfaceDB
{
	String str,str1;
	public DbImplementation() throws RemoteException
	{}
	public String getData(String sql,String dsn)
	{
		String URL="jdbc:odbc:DDD";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection(URL);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			str=" ";
			str1=" ";
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				str1=str1+rsmd.getColumnName(i)+"\t";
			}
			System.out.println("--------------------");
			while(rs.next())
			{
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					str=str+rs.getString(i)+"\t";
				}
				str=str+"\n";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return(str1+"\n"+str);
	}
}