
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NARENDER KESWANI
 */
public class Client implements ActionListener {

    JTextField t1, t2;
    JButton b1;
    JLabel l1;

    Client() {
        JFrame f = new JFrame("GCD EXAMPLE");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        b1 = new JButton("Eval");
        l1 = new JLabel("PREM MC HAI");
        t1.setBounds(50, 100, 200, 30);
        t2.setBounds(50, 150, 200, 30);
        b1.setBounds(50, 180, 200, 30);
        l1.setBounds(50, 210, 200, 30);
        f.add(t1);
        f.add(t2);
        f.add(b1);
        f.add(l1);
        f.setVisible(true);
        f.setLayout(new GridLayout(4,1));    
        f.setSize(400,400);  

        b1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            int a = Integer.parseInt(t1.getText().toString());
            int b = Integer.parseInt(t2.getText().toString());

            Igcd stub = (Igcd) Naming.lookup("rmi://localhost:5005/narender1");
            int c = stub.EvaluateGcd(a, b);
            System.out.println(c);
            l1.setText(String.valueOf(c));
        } catch (NumberFormatException | MalformedURLException | NotBoundException | RemoteException f) {
            System.out.println(f);
        }
    }

    public static void main(String args[]) {

        new Client();
    }

}
