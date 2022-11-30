import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class StudentServer
{
	public static void main(String args[]) throws Exception
	{
		StudentImpl si=new StudentImpl();
		Naming.rebind("StdInfo",si);
	}
}