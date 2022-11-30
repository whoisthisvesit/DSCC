import java.rmi.*;
import java.net.*;
public class CalculatorClient
{
	public static void  main(String args[]) throws Exception
	{
		String URL="rmi://"+args[0]+"/CalciSkel";
		Calculator c=(Calculator)Naming.lookup(URL);
		System.out.println("First Number "+args[1]);
		System.out.println("Second Number "+args[2]);
		double d1=Double.valueOf(args[1]).doubleValue();
		double d2=Double.valueOf(args[2]).doubleValue();
		int d3=Integer.valueOf(args[3]).intValue();
		switch (d3)
		{
			case 1: 
				System.out.println("Addition: "+c.add(d1,d2));
				break;
			case 2:
				System.out.println("Subtarction: "+c.sub(d1,d2));
				break;
			case 3:
				System.out.println("Multiplication: "+c.mul(d1,d2));
				break;
			case 4: 
				System.out.println("Division: "+c.div(d1,d2));
				break;
			default:
				System.out.println("Wrong Choice.");
				break;
		}	
	}
}