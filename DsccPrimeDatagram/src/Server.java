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

public class Server {

    DatagramSocket ds;
    DatagramPacket dp;
    String str, methodName;
    int val1, val2;

     public boolean isPrime(int n) {
     int count = 0;

     if (n < 2)
       return false;

     for (int i = 2; i < Math.sqrt (n); i++)
       {
 	if (n % i == 0)
 	  return false;
       }

     return true;
    
    }
     
    Server() {
        try {
            ds = new DatagramSocket(1200);
            byte b[] = new byte[4096];
            while (true) {
                dp = new DatagramPacket(b, b.length);
                ds.receive(dp);
                str = new String(dp.getData(), 0, dp.getLength());
                int limit = Integer.parseInt(str);
                
                StringBuilder singleString = new StringBuilder();

                for (int i = 1; i <= limit; i++) {
                    if (isPrime(i)) {
                        singleString.append(i);
                        singleString.append(" ");
                    }
                }

                InetAddress ia = InetAddress.getLocalHost();

                byte b1[] = singleString.toString().getBytes();
                DatagramSocket ds1 = new DatagramSocket();
                DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 1300);
                System.out.println("result : " + singleString + "\n");
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
