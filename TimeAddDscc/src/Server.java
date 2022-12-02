import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class Server {
	public static int ConvertHoursToSeconds(int n)
	{
		
		return n * 3600;
	
	}
	
	public static int ConvertMinutuesToSeconds(int n)
	{
		
		return n * 60;
	
	}
	
	public static void main(String[] args)
			throws IOException {
			DatagramSocket ds = new DatagramSocket(1234);
			
			byte[] buf1 = null;
			byte[] buf2 = null;
			byte[] buf3 = null;
			byte[] buf4 = null;
			
			DatagramPacket DpReceive1 = null;
			DatagramPacket DpReceive2 = null;
			DatagramPacket DpReceive3 = null;
			DatagramPacket DpReceive4 = null;
			
			DatagramPacket DpSend1 = null;
			DatagramPacket DpSend2 = null;
			DatagramPacket DpSend3 = null;
			
			while (true) {
				
			buf1 = new byte[65535];
			buf2 = new byte[65535];
			buf3 = new byte[65535];
			buf4 = new byte[65535];
			
			DpReceive1 = new DatagramPacket(buf1, buf1.length);
			ds.receive(DpReceive1);
			DpReceive2 = new DatagramPacket(buf2, buf2.length);
			ds.receive(DpReceive2);
			DpReceive3 = new DatagramPacket(buf3, buf3.length);
			ds.receive(DpReceive3);
			DpReceive4 = new DatagramPacket(buf4, buf4.length);
			ds.receive(DpReceive4);
			
			String inp1 = new String(buf1, 0, buf1.length);
			inp1 = inp1.trim();
			
			String inp2 = new String(buf2, 0, buf2.length);
			inp2 = inp2.trim();
			
			String inp3 = new String(buf3, 0, buf3.length);
			inp3 = inp3.trim();
			
			String inp4 = new String(buf4, 0, buf4.length);
			inp4 = inp4.trim();
			
			System.out.println("Hour 1: " + inp1);
			System.out.println("Minutes 1: " + inp2);
			System.out.println("Hour 2: " + inp3);
			System.out.println("Minutes 2: " + inp4);
			
			int h1 = ConvertHoursToSeconds(Integer.parseInt(inp1));
			int h2 = ConvertHoursToSeconds(Integer.parseInt(inp3));
			int m1 = ConvertMinutuesToSeconds(Integer.parseInt(inp2));
			int m2 = ConvertMinutuesToSeconds(Integer.parseInt(inp4));
			
			int result = h1 + h2 + m1 + m2;
			
			int day = (int)TimeUnit.SECONDS.toDays(result);        
			long hours = TimeUnit.SECONDS.toHours(result) - (day *24);
			long minutes = TimeUnit.SECONDS.toMinutes(result) - (TimeUnit.SECONDS.toHours(result)* 60);

			long minutes2 =  TimeUnit.HOURS.toMinutes(hours) + minutes; 
			
				System.out.println("Sending the result...");
				String res1 = Long.toString(hours);
				String res2 = Long.toString(minutes);
				String res3 = Long.toString(minutes2);
				
				buf1 = res1.getBytes();
				buf2 = res2.getBytes();
				buf3 = res3.getBytes();

				
				int port = DpReceive1.getPort();
				
				DpSend1 = new DatagramPacket(buf1, buf1.length, InetAddress.getLocalHost(), port);
				ds.send(DpSend1);
				
				DpSend2 = new DatagramPacket(buf2, buf2.length, InetAddress.getLocalHost(), port);
				ds.send(DpSend2);
				
				DpSend3 = new DatagramPacket(buf3, buf3.length, InetAddress.getLocalHost(), port);
				ds.send(DpSend3);
			}
	}
}
