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
import java.rmi.registry.*;

public class MyServer {

    public static void main(String args[]) {
        try {
            DateTime stub = new DateTimeRemote();
            Naming.rebind("rmi://localhost:5000/narender",stub);  
        } catch (Exception e) {
            System.out.print("exception on server");
            System.out.println(e);
        }
    }
}
