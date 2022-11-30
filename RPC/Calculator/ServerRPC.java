import java.net.*;
import java.io.*;
public class ServerRPC
{
	public static void main(String args[]) throws Exception
	{
		//creating the virtual server on the required port number
		ServerSocket sersock=new ServerSocket(3000);
		System.out.println("Server Started Executing.");
		
		//establishing connection between client and the server
		Socket csock=sersock.accept();
		
		//to write
		OutputStream ostream=csock.getOutputStream();
		PrintWriter out=new PrintWriter(ostream,true);

		//to read
		InputStream istream=csock.getInputStream();
		BufferedReader recieveRead=new BufferedReader(new InputStreamReader(istream));

		int a,b,c;
		String recieveMessage,sendMessage,function;
		while(true)
		{
			function=recieveRead.readLine();
			if(function!=null)
			{
				System.out.println("Operation is: "+function);
				a=Integer.parseInt(recieveRead.readLine());
				System.out.println("1st Number: "+a);
				b=Integer.parseInt(recieveRead.readLine());
				System.out.println("2nd Number: "+b);
				if(function.compareTo("add")==0)
				{
					c=a+b;
					out.println("Addition is: "+c);
				}
				if(function.compareTo("sub")==0)
				{
					c=a-b;
					out.println("Subtraction is: "+c);
				}
				if(function.compareTo("mul")==0)
				{
					c=a*b;
					out.println("Multiplication is: "+c);
				}
				if(function.compareTo("div")==0)
				{
					try
					{
						c=a/b;
						out.println("Division is: "+c);
					}
					catch(Exception e)
					{
						out.println(e);
					}
				}
				out.flush();
			}
		}
	}
}