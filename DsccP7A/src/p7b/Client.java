/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

/**
 *
 * @author NARENDER KESWANI
 */
public class Client {
     public static void main(String[] args) {
        String res = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String url = "rmi://127.0.0.1/DBServerBill";
            System.out.println("Retriving Bill Information....");
            while (true) {
                System.out.print("Enter choice:\n1. Get Bill By Id ");
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    IDB id1 = (IDB) Naming.lookup(url);
                    res = id1.getData(Integer.parseInt(br1.readLine()));
                    System.out.println(res);
                } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
