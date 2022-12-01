
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Client implements ActionListener{
    
    JTextField t1,t2;  
    JButton b1;
    JTextField l1;
    Client()
    {
          JFrame f= new JFrame("ADD EXAMPLE");  
    
    t1=new JTextField(20);  
    t1.setBounds(50,100, 200,30);  
    t2=new JTextField(20);  
    t2.setBounds(50,150, 200,30);  
    b1 = new JButton("ADD");
    b1.setBounds(50,250, 200,30);  
    l1 = new JTextField(20);
    l1.setBounds(50,300, 200,30); 
    f.add(t1);
    f.add(t2); 
    f.add(b1);
    f.add(l1);
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true); 
    
     b1.addActionListener(this); 
    }
    @Override
    public void actionPerformed(ActionEvent e)  {  
        String s1=t1.getText();  
        String s2=t2.getText();  
        int a=Integer.parseInt(s1);  
        int b=Integer.parseInt(s2); 
        
         Icalc stub;  
        try {
            stub = (Icalc)Naming.lookup("rmi://localhost:5000/narender");
        
         
         int c = stub.add(a, b);
         System.out.println(c);
         l1.setText(String.valueOf(c));
        }
        catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
     public static void main(String args[]) {
      
new Client();
    }
}
