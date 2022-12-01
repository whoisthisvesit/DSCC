
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARENDER KESWANI
 */
public class CalcImpl extends UnicastRemoteObject implements Icalc {

    CalcImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) {
       return a+b;
    }
}
