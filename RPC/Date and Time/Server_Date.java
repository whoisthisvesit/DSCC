import java.net.*;
import java.io.*;
import java.util.*;
public class Server_Date
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(3000);
		Socket csock=ss.accept();
		System.out.println("Cleint with IP Address is: "+csock.getInetAddress()+"has communicated through port no: "+csock.getPort());
		Date d=new Date();
		String s="Current Date and Time on Server is: "+d;
		OutputStream ostream=csock.getOutputStream();
		PrintWriter out=new PrintWriter(ostream,true);
		out.println(s);
		out.flush();
		out.close();
	}
}