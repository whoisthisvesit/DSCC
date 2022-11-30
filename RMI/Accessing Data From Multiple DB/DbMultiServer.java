import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class DbMultiServer
{
	public static void main(String args[]) throws Exception
	{
		DbImplementation dbi=new DbImplementation();
		Naming.rebind("DbMServer",dbi);
	}
}