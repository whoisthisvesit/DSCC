import java.rmi.*;
import java.net.*;
public class LinearServer 
{
	public static void main(String args[]) throws Exception
	{
		try
		{
			LinearImpl li=new LinearImpl();
			Naming.rebind("Linearskel",li);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}