import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;
		while (true) {
			System.out.print("Enter the number to check whether it is even or odd:");
			String inp = sc.nextLine();
			buf = new byte[65535];
			buf = inp.getBytes();
			DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
			ds.send(DpSend);
			if (inp.equals("bye")) {
				break;
			}
			buf = new byte[65535];
			DatagramPacket DpReceive = new DatagramPacket(buf, buf.length);
			ds.receive(DpReceive);
			System.out.println("Answer = " + new String(buf, 0, buf.length));
		}
	}
}