import java.net.*;
import java.io.*;
public class ServerChat1
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket sersock=new ServerSocket(3000);
		System.out.println("Server Chatting Started....");
		Socket sock = sersock.accept();
		BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwrite=new PrintWriter(ostream,true);
		InputStream istream=sock.getInputStream();
		BufferedReader receiveRead=new BufferedReader(new InputStreamReader(istream));
		String receiveMsg,sendMsg;
		while(true)
		{
			if((receiveMsg=receiveRead.readLine())!=null)
			{
				System.out.println(receiveMsg);			
			}
			sendMsg=keyRead.readLine();
			pwrite.println(sendMsg);
			pwrite.flush();
		}
	}
}