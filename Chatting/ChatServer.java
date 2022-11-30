import java.io.*;
import java.net.*;
public class ChatServer extends Thread
{
	ServerSocket ss;
	Socket soc;
	BufferedReader br,br1;
	PrintWriter out;
	String str;
	public ChatServer()
	{
		try
		{
			ss=new ServerSocket(9999);
			soc=ss.accept();
			br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			start();
			new InnerServer();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void run()
	{
		try
		{
			while(true)
			{
				str=br.readLine();
				System.out.println("Client Message: "+str);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	class InnerServer
	{
		String str1;
		InnerServer()
		{
			try
			{
				br1=new BufferedReader(new InputStreamReader(System.in));
				out=new PrintWriter(soc.getOutputStream(),true);
				while(true)
				{
					str1=br1.readLine();
					out.println(str1);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public static void main(String args[])
	{
		new ChatServer();
	}
}