import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	public static void main(String args[])
			throws IOException {
			Scanner sc = new Scanner(System.in);
			DatagramSocket ds = new DatagramSocket();
			InetAddress ip = InetAddress.getLocalHost();
			byte buf1[] = null;
			byte buf2[] = null;
			byte buf3[] = null;
			byte buf4[] = null;
			while (true) {
				
			System.out.print("Enter the hour for input 1:");
			String inph1 = sc.nextLine();
			System.out.print("Enter the miniutes for input 1:");
			String inpm1 = sc.nextLine();

			System.out.print("Enter the hour for input 2:");
			String inph2 = sc.nextLine();
			System.out.print("Enter the miniutes for input 2:");
			String inpm2 = sc.nextLine();
			
			buf1 = new byte[65535];
			buf2 = new byte[65535];
			buf3 = new byte[65535];
			buf4 = new byte[65535];
			
			buf1 = inph1.getBytes();
			buf2 = inpm1.getBytes();
			buf3 = inph2.getBytes();
			buf4 = inpm2.getBytes();
			
			DatagramPacket DpSend1 = new DatagramPacket(buf1, buf1.length, ip, 1234);
			DatagramPacket DpSend2 = new DatagramPacket(buf2, buf2.length, ip, 1234);
			DatagramPacket DpSend3 = new DatagramPacket(buf3, buf3.length, ip, 1234);
			DatagramPacket DpSend4 = new DatagramPacket(buf4, buf4.length, ip, 1234);
			
			ds.send(DpSend1);
			ds.send(DpSend2);
			ds.send(DpSend3);
			ds.send(DpSend4);
			
			buf1 = new byte[65535];
			buf2 = new byte[65535];
			buf3 = new byte[65535];
			
			DatagramPacket DpReceive1 = new DatagramPacket(buf1, buf1.length);
			ds.receive(DpReceive1);

			DatagramPacket DpReceive2 = new DatagramPacket(buf2, buf2.length);
			ds.receive(DpReceive2);
			
			DatagramPacket DpReceive3 = new DatagramPacket(buf3, buf3.length);
			ds.receive(DpReceive3);
			
			System.out.print("Answer1 = " + new String(buf1, 0, buf1.length));
			System.out.print("Answer2 = " + new String(buf2, 0, buf2.length)); 
			System.out.print("Answer3 = " + new String(buf3, 0, buf3.length)); 
			
			}
			}
}
