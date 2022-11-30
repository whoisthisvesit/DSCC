import java.rmi.*;
import java.net.*;
public class AddServer
{
	public static void main(String args[])
	{
		try
		{
			AddServerImpl ads = new AddServerImpl();
			Naming.rebind("AddServer",ads);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}