import java.net.*;
import java.io.*;
public class DateClient
{
	public static void main(String args[]) throws Exception
	{
		Socket soc=new Socket(InetAddress.getLocalHost(),3000);//used to establish connection with server.
		BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
		System.out.println("Server Date is: "+br.readLine());
	}
}