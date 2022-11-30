import java.rmi.*;
import java.net.*;
import java.rmi.server.*;
public class CalculatorServer 
{
	public static void main(String args[])
	{
		try
		{
			CalculatorImpl calimp=new CalculatorImpl();
			Naming.rebind("CalciSkel",calimp);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}