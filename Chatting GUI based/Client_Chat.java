import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;
import java.*;
public class Client_Chat extends Frame
{
	TextArea ta;
	TextField tf;
	Button btnSend,btnClose;
	Socket soc;
	String sendTo,LoginName;
	DataOutputStream dout;
	DataInputStream din;
	Thread t;
	public Client_Chat(String LoginName,String chatwith) throws Exception
	{
		super(LoginName);
		this.LoginName=LoginName;
		sendTo=chatwith;
		ta=new TextArea(50,50);
		tf=new TextField(50);
		btnSend=new Button("Send");
		btnClose=new Button("Close");
		soc=new Socket(InetAddress.getLocalHost(),5271);
		din=new DataInputStream(soc.getInputStream());
		dout=new DataOutputStream(soc.getOutputStream());
		dout.writeUTF(LoginName);
		// t=new Thread(this);
		// t.start();
	}
	void setup()
	{
		setSize(600,600);
		setLayout(new GridLayout(2,1));
		add(ta);
		Panel p=new Panel();
		p.add(tf);
		p.add(btnSend);
		p.add(btnClose);
		add(p);
		show();
	}
	public static void main(String args[]) throws Exception
	{
		Client_Chat client=new Client_Chat(args[0],args[1]);
		client.setup();
	}
	public void run()
	{
		while(true)
		{
			try
			{
				ta.append("\n"+sendTo+"Says:"+din.readUTF());
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	public boolean action(Event e,Object o)
	{
		if(e.arg.equals("Send"))
		{
			try
			{
				dout.writeUTF(sendTo+" "+"DATA"+" "+tf.getText().toString());
				ta.append("\n"+LoginName+"Says"+tf.getText().toString());
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else if(e.arg.equals("Close"))
		{
			try
			{
				dout.writeUTF(LoginName+"LOGOUT");
				System.exit(1);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return super.action(e  ,o);
	}
}