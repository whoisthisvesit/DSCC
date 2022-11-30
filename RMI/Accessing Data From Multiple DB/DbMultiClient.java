import java.net.*;
import java.rmi.server.*;
import java.rmi.*;
import java.io.*;
public class DbMultiClient 
{
	public static void main(String args[])
	{
		String db=" ",sql=" ",ch=" ",ch1=" ",res=" ";
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("select an option");
				System.out.println("1.Retrive College Information.");
				System.out.println("2.Retive MTNL Billing Information.");
				System.out.println("3.Exit");
				System.out.println("Enter your Choice...");
				ch=br.readLine();
				if(ch.equals("1"))
				{
					db="ClgDb";
					System.out.println("Select an option....");
					System.out.println("a.Retrive Student Information");
					System.out.println("b.Retrive Book Information");
					System.out.println("Enter your Choice");
					ch1=br.readLine();
					if(ch1.equals("a"))
					{
						sql="select * from Student";
					}
					else if(ch1.equals("b"))
					{
						sql="select * from Book";
					}
					else
					{
						System.out.println("Select valid Option.");
					}
				}
				else if(ch.equals("2"))
				{
					db="MTNLDb";
				}
				else if(ch.equals("3"))
				{
					System.exit(0);
				}
				else
				{
					System.out.println("Select a Valid Option.");
				}
				String url="rmi://127.0.0.1/DbMServer";
				InterfaceDB idb=(InterfaceDB)Naming.lookup(url);
				res=idb.getData(sql,db);
				System.out.println(res);
			}
		}
		catch(Exception e)
		{}
	}
}