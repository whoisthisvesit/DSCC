
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
public class Client {

    public static void main(String[] args) {
        String ch1 = "", res = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String url = "rmi://127.0.0.1/DBServer";
            System.out.println("Retriving Books Information....");
            while (true) {
                System.out.print("Enter choice:\n1. Get All Books\n2. Get Book By Id ");
                ch1 = br.readLine();
                if (ch1.equals("1")) {
                    IDB id = (IDB) Naming.lookup(url);
                    res = id.getData();
                    System.out.println(res);
                } else if (ch1.equals("2")) {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    IDB id1 = (IDB) Naming.lookup(url);
                    res = id1.getData(Integer.parseInt(br1.readLine()));
                    System.out.println(res);
                } else {
                    System.out.println("Please select an option");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
