
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

class Server {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(1234);
		byte[] buf = null;
		DatagramPacket DpReceive = null;
		DatagramPacket DpSend = null;
		while (true) {
			buf = new byte[65535];
			DpReceive = new DatagramPacket(buf, buf.length);
			ds.receive(DpReceive);
			String inp = new String(buf, 0, buf.length);
			inp = inp.trim();
			System.out.println("Equation Received:- " + inp);
			if (inp.equals("close")) {
				System.out.println("Client sent closing");
				break;
			}
			String result = null;
			StringTokenizer st = new StringTokenizer(inp);
			int input = Integer.parseInt(st.nextToken());
			if (input % 2 == 0) {
				result = "Number is even";
			} else {
				result = "Number is odd";
			}

			System.out.println("Sending the result...");
			buf = result.getBytes();
			int port = DpReceive.getPort();
			DpSend = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), port);
			ds.send(DpSend);
		}
	}
}
