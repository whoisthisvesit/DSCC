
import java.io.IOException;
import java.rmi.Naming;

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
     public static void main(String[] args)
            throws IOException {
   try {
            Igcd stub = new GcdImpl();
            Naming.rebind("rmi://localhost:5005/narender1",stub);  
        } catch (Exception e) {
            System.out.print("exception on server");
            System.out.println(e);
        }
     }   
}
