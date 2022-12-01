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

class TokenClient1 {

    public static DatagramSocket ds;
    public static DatagramPacket dp;
    public static BufferedReader br;
    static int cp = 100;

    public static void main(String[] args) throws Exception {
        boolean hasToken;

        try {
            ds = new DatagramSocket(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        hasToken = true;
        while (true) {
            if (hasToken == true) {
                System.out.println("Do you want to enter data...(yes/no):");
                br = new BufferedReader(new InputStreamReader(System.in));
                String ans = br.readLine();
                if (ans.equalsIgnoreCase("yes")) {
                    System.out.println("ready to send");
                    System.out.println("sending");
                    System.out.println("Enter the data");
                    br = new BufferedReader(new InputStreamReader(System.in));
                    String str = "Client-1===> " + br.readLine();
                    byte buff[] = new byte[1024];
                    buff = str.getBytes();
                    ds.send(new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), 1000));
                    System.out.println("now sending");
                } else if (ans.equalsIgnoreCase("no")) {
                    System.out.println("I am busy state");
//sending msg to client-2
                    String msg = "Token";
                    byte bf1[] = new byte[1024];
                    bf1 = msg.getBytes();
                    ds.send(new DatagramPacket(bf1, bf1.length, InetAddress.getLocalHost(), 200));
                    hasToken = false;
//recevingmsg from client-2
                    byte bf2[] = new byte[1024];
                    ds.receive(dp = new DatagramPacket(bf2, bf2.length));
                    String clientmsg = new String(dp.getData(), 0, dp.getLength());
                    System.out.println("The data is " + clientmsg);

                    if (clientmsg.equals("Token")) {
                        hasToken = true;
                    }
                    System.out.println("I am leaving busy state");
                }
            } else {
                System.out.println("Entering in receive mode.");
                byte bf[] = new byte[1024];
                ds.receive(dp = new DatagramPacket(bf, bf.length));
                String clientmsg1 = new String(dp.getData(), 0, dp.getLength());
                System.out.println("The data is " + clientmsg1);
                if (clientmsg1.equals("Token"));
                {
                    hasToken = true;
                }
            }
        }
    }
}
