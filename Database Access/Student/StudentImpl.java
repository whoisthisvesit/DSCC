import java.rmi.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.rmi.server.*;
public class StudentImpl extends UnicastRemoteObject implements StudentIntf
{
	int id,age;
	String name,course,filename,db;
	public StudentImpl() throws RemoteException
	{}
	public ArrayList insert(int id,String name,String course,int age) throws RemoteException
	{
		ArrayList al=new ArrayList();
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			filename="E:\\ADC Lab\\Database Access\\Student.accdb";
			db="jdbc:odbc:Driver={Microsoft Access Driver(*.mdb,*.accdb)};DBQ="+filename;
			Connection con=DriverManager.getConnection(db,"","");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into Result values("+id+",'"+name+"','"+course+"',"+age+")");
			System.out.println("Record Inserted");
			ResultSet rs=stmt.executeQuery("select * from Result");
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				course=rs.getString(3);
				age=rs.getInt(4);
			}
			al.add(new Integer(id));
			al.add(new String(name));
			al.add(new String(course));
			al.add(new Integer(age));
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;

	}
}