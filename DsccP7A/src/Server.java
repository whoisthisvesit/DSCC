
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

    public static void main(String[] args) {
        try {
            DBImpl di = new DBImpl();
            Naming.rebind("rmi://127.0.0.1/DBServer", di);
            System.out.println("Server Registered.");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
