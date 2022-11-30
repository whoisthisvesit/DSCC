import java.net.*;
import java.util.*;
import java.io.*;
public class Server_Chat
{
	static Vector ClientSockets;
	static Vector LoginNames;
	public Server_Chat() throws Exception
	{
		ServerSocket soc=new ServerSocket(5271);
		ClientSockets=new Vector();
		LoginNames=new Vector();
		while(true)
		{
			Socket CSoc=soc.accept();
			AcceptClient obClient=new AcceptClient(CSoc);
		}
	}
	public static void main(String[] args) 
	{
		Server_Chat ob=new Server_Chat();	
	}
	class AcceptClient extends Thread
	{
		Socket ClientSocket;
		DataInputStream dis;
		DataOutputStream dout;
		AcceptClient(Socket CSoc) throws Exception
		{
			ClientSocket=CSoc;
			dis=new DataInputStream(ClientSocket.getInputStream());
			String LoginName=dis.readUTF();
			System.out.println("User Logged in: "+LoginName);
			LoginNames.add(LoginName);
			ClientSockets.add(ClientSocket);
			start();
		}
		public void run()
		{
			while(true)
			{
				try
				{
					String msgFromClient=new String();
					msgFromClient=dis.readUTF();
					StringTokenizer st=new StringTokenizer(msgFromClient);
					String Sendto=st.nextToken();
					Strong MsgType=st.nextToken();
					int iCount=0;
					if (MsgType.equals("LOGOUT")) 
					{
						for (iCount=0;iCount<LoginNames.size() ;iCount++ ) 
						{
							if (LoginNames.elementAt(iCount).equals(Sendto))
							{
								LoginNames.removeElementAt(iCount);
								ClientSockets.removeElementAt(iCount);
								System.out.println("User"+Sendto+"Logged Out");
								break;
							}			
						}	
					}
					else
					{
						String msg=" ";
						while(st.hasMoreTokens())
						{
							
						}
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
}