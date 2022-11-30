import java.io.*;
import java.net.*;
public class ClientChat1
{
	public static void main(String args[]) throws Exception
	{
		Socket sock=new Socket(InetAddress.getLocalHost(),3000);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OutputStream os=sock.getOutputStream();
		PrintWriter out=new PrintWriter(os,true);
		InputStream istream=sock.getInputStream();
		BufferedReader clientMsg=new BufferedReader(new InputStreamReader(istream));
		System.out.println("Strat Chatting....");
		String receiveMsg,sendMsg;
		while(true)
		{
			sendMsg=br.readLine();
			out.println(sendMsg);
			out.flush();
			if((receiveMsg=clientMsg.readLine())!=null)
			{
				System.out.println(receiveMsg);
			}
		}
	}
}