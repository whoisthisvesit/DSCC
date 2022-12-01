
import java.rmi.Naming;
import java.rmi.Remote;

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
    public static void main(String args[]) {
        try {
            Icalc stub = new CalcImpl();
            Naming.rebind("rmi://localhost:5000/narender", (Remote) stub);  
        } catch (Exception e) {
            System.out.print("exception on server");
            System.out.println(e);
        }
    }
}
