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
import java.rmi.server.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class DateTimeRemote extends UnicastRemoteObject implements DateTime {

    DateTimeRemote() throws RemoteException {
        super();
    }

    @Override
    public String date(int op) {
        Date dateObj = new Date();
        if (op == 1) {
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
            String formattedDate = df.format(dateObj);
            return formattedDate;
        } else if (op == 2) {
            SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
            String formattedTime = df.format(dateObj);
            return formattedTime;
        }
        return "a";
    }
}
