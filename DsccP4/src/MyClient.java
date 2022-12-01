/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARENDER KESWANI
 */
import java.rmi.*;

public class MyClient {

    public static void main(String args[]) {
        try {
            DateTime stub=(DateTime)Naming.lookup("rmi://localhost:5000/narender");  
            System.out.println("Current Date: " + stub.date(1) + "\n" + "Current Time:" + stub.date(2));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
