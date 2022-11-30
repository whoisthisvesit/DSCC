import java.rmi.*;
import java.net.*;
public class LinearClient
{
	public static void main(String args[]) throws Exception
	{
		String url="rmi://"+args[0]+"/Linearskel";
		LinearIntf li=(LinearIntf)Naming.lookup(url);
		double d1=Double.valueOf(args[1]).doubleValue();
		double d2=Double.valueOf(args[2]).doubleValue();
		System.out.println("Solving a^2-2ab+b^2");
		System.out.println(String.valueOf(li.LinearCalc(d1,d2)));
	}
}