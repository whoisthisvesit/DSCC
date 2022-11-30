import java.rmi.*;
import java.net.*;
public class DateServer
{
	public static void main(String args[]) throws Exception
	{
		DateImpl di=new DateImpl();
		Naming.rebind("DateDemo",di);//used to load the object to the server.
	}
}