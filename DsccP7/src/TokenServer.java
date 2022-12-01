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

class TokenServer {

    public static DatagramSocket ds;
    public static DatagramPacket dp;

    public static void main(String[] args) throws Exception {
        try {
            ds = new DatagramSocket(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            byte buff[] = new byte[1024];
            ds.receive(dp = new DatagramPacket(buff, buff.length));
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Message from " + str);
        }
    }
}
