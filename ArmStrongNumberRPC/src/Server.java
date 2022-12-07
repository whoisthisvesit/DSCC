
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NARENDER KESWANI
 */
public class Server {

    public static boolean checkArmstrong(int number) {
        boolean check = false;
        int originalNumber, remainder, result = 0;

        originalNumber = number;

        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }

        if (result == number) {
            check = true;
        } else {
            check = false;
        }

        return check;
    }

    public static void main(String[] args)
            throws IOException {
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
            System.out.println("Number Received:- " + inp);
            
            boolean answer = checkArmstrong(Integer.parseInt(inp));
            
            System.out.println("Sending the result...");
            String res = String.valueOf(answer);
            buf = res.getBytes();
            int port = DpReceive.getPort();
            DpSend = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), port);
            ds.send(DpSend);
        }
    }
}
