
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NARENDER KESWANI
 */
public class GcdImpl extends UnicastRemoteObject implements Igcd {

     GcdImpl() throws RemoteException {
        super();
    }
        
    @Override
    public int EvaluateGcd(int a, int b) throws RemoteException {
        int answer;
        System.out.println("Numbers are " + a + " and " + b);
        a = (a > 0) ? a : -a;
        b = (b > 0) ? b : -b;
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        answer = a;
        return answer;
    }

}
