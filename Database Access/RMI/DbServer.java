import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class DbServer
{
	public static void main(String args[]) throws Exception
	{
		DbImplementation dbi=new DbImplementation();
		Naming.rebind("DBI",dbi);
		System.out.println("Server Started it's Execution.");
	}
}