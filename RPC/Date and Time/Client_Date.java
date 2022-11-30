import java.net.*;
import java.io.*;
public class Client_Date
{
	public static void main(String args[]) throws Exception
	{
		Socket soc=new Socket(InetAddress.getLocalHost(),3000);
		System.out.println("Client "+soc.getInetAddress()+" is communicating from port no: "+soc.getPort());
		InputStream istream=soc.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(istream));
		System.out.println(br.readLine());
		br.close();
		soc.close();
	}
}