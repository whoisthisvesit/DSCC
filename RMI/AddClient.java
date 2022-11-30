import java.rmi.*;
public class AddClient
{
	public static void main(String args[])
	{
		try
		{
			String URL="rmi://"+args[0]+"/AddServer";
			AddServerIntf addserverIntf=(AddServerIntf)Naming.lookup(URL);
			System.out.println("First No: "+args[1]);
			System.out.println("Second No: "+args[2]);
			double d1=Double.valueOf(args[1]).doubleValue();
			double d2=Double.valueOf(args[2]).doubleValue();
			System.out.println("The sum is: "+addserverIntf.add(d1,d2));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}