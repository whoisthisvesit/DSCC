import java.net.*;
import java.io.*;
public class ClientRPC
{
	public static void main(String args[]) throws Exception
	{
		Socket soc=new Socket(InetAddress.getLocalHost(),3000);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OutputStream os=soc.getOutputStream();
		PrintWriter out=new PrintWriter(os,true);
		InputStream is=soc.getInputStream();//read content from connection.
		BufferedReader recieveRead=new BufferedReader(new InputStreamReader(is));
		System.out.println("Server Connected.");
		String no1,no2,temp,recieveMessage,sendMessage;
		System.out.println("Enter the operation to be performed(add, sub,mul, div).");
		temp=br.readLine();
		sendMessage=temp.toLowerCase();
		out.println(sendMessage);
		System.out.println("Enter the 1st Number: ");
		no1=br.readLine();
		out.println(no1);
		System.out.println("Enter the 2nd Number: ");
		no2=br.readLine();
		out.println(no2);
		out.flush();
		if((recieveMessage=recieveRead.readLine())!=null)
		{
			System.out.println(recieveMessage);
		}
	}
}