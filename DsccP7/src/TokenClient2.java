/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author NARENDER KESWANI
 */
import java.net.*;
import java.io.*;

class TokenClient2 {

    static DatagramSocket ds;
    static DatagramPacket dp;
    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        try {
            ds = new DatagramSocket(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean hasToken = true;
        while (true) {
//System.out.println("Entering if");
            if (hasToken == true) {
                System.out.println("Do you want to enter data(Yes/No):");
                br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                if (str.equalsIgnoreCase("yes")) {
                    System.out.println("Enter Data; ");
                    br = new BufferedReader(new InputStreamReader(System.in));
                    String msg = "Client-2===>" + br.readLine();
                    byte bf1[] = new byte[1024];
                    bf1 = msg.getBytes();
                    ds.send(new DatagramPacket(bf1, bf1.length, InetAddress.getLocalHost(), 1000));
                    System.out.println("Data sent");
                } else {
//send to client 1.
                    String clientmsg = "Token";
                    byte bf2[] = new byte[1024];
                    bf2 = clientmsg.getBytes();
                    ds.send(new DatagramPacket(bf2, bf2.length, InetAddress.getLocalHost(), 100));
                    hasToken = false;
                }
            } else {
                try {
                    byte buff[] = new byte[1024];
                    System.out.println("Entering in receiving mode.");
                    ds.receive(dp = new DatagramPacket(buff, buff.length));
                    String clientmsg1 = new String(dp.getData(), 0, dp.getLength());
                    System.out.println("The data is " + clientmsg1);
                    if (clientmsg1.equals("Token")) {
                        hasToken = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
