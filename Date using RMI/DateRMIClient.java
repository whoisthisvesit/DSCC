import java.net.*;
import java.rmi.*;
public class DateRMIClient
{
	public static void main(String args[]) throws Exception
	{
		String url="rmi://"+args[0]+"/DateDemo";
		DateIntf dateintf=(DateIntf)Naming.lookup(url);
		System.out.println(""+dateintf.Today_Date());
	}
}

//step 1:-Compile all 4 program
//Step 2:-rmic DateImpl
//Step 3:-start rmiregistry
//step 4:-java DateServer

//Step 1:-java DateRMIClient 127.0.0.1