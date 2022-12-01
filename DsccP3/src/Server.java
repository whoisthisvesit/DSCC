/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARENDER KESWANI
 */
import java.util.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Server {

    DatagramSocket ds;
    DatagramPacket dp;
    String str, methodName, result;
    int val1, val2;

    Server() {
        try {
            ds = new DatagramSocket(1200);
            byte b[] = new byte[4096];
            while (true) {
                dp = new DatagramPacket(b, b.length);
                ds.receive(dp);
                str = new String(dp.getData(), 0, dp.getLength());
                if (str.equalsIgnoreCase("q")) {
                    System.exit(1);
                } else {
                    StringTokenizer st = new StringTokenizer(str, " ");
                    int i = 0;
                    while (st.hasMoreTokens()) {
                        String token = st.nextToken();
                        methodName = token;
                    }
                }
                Calendar c = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date d = c.getTime();
                InetAddress ia = InetAddress.getLocalHost();
                if (methodName.equalsIgnoreCase("date")) {
                    result = "" + dateFormat.format(d);
                } else if (methodName.equalsIgnoreCase("time")) {
                    result = "" + d.getHours() + " : " + d.getMinutes() + " : " + d.getSeconds();
                }
                byte b1[] = result.getBytes();
                DatagramSocket ds1 = new DatagramSocket();
                DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 1300);
                System.out.println("result : " + result + "\n");
                ds1.send(dp1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
