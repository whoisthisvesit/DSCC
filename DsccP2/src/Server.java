/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARENDER KESWANI
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

class Server {

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
            System.out.println("Equation Received:- " + inp);
            if (inp.equals("close")) {
                System.out.println("Client sent closing");
                break;
            }
            int result;
            StringTokenizer st = new StringTokenizer(inp);
            int oprnd1 = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int oprnd2 = Integer.parseInt(st.nextToken());

            if (operation.equals("+")) {
                result = oprnd1 + oprnd2;
            } else if (operation.equals("-")) {
                result = oprnd1 - oprnd2;
            } else if (operation.equals("*")) {
                result = oprnd1 * oprnd2;
            } else {
                result = oprnd1 / oprnd2;
            }
            System.out.println("Sending the result...");
            String res = Integer.toString(result);
            buf = res.getBytes();
            int port = DpReceive.getPort();
            DpSend = new DatagramPacket(
                    buf, buf.length, InetAddress.getLocalHost(), port);
            ds.send(DpSend);
        }
    }
}
