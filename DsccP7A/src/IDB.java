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

public interface IDB extends Remote {

    public String getData() throws RemoteException;
    public String getData(int id) throws RemoteException;
}
