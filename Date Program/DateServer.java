import java.net.*;
import java.io.*;
import java.util.*;
public class DateServer
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(3000);//used to start virtual server on the mentioned port no.
		while(true)
		{
			Socket s=ss.accept();
			DataOutputStream out=new DataOutputStream(s.getOutputStream());
			out.writeBytes("Today's date is: "+(new Date()).toString()+"\n");
			out.close();
			s.close();
		}
	}
}