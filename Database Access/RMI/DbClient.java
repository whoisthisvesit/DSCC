import java.rmi.*;
import java.net.*;
public class DbClient
{
	public static void main(String args[]) throws Exception
	{
		String url="rmi://"+args[0]+"/DBI";
		IDb id=(IDb)Naming.lookup(url);//typecasting interface.
		String res=id.getData("select * from Result");
	}
}