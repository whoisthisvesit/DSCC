
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARENDER KESWANI
 */
    
    public interface IEquationSolver extends Remote {

    public int EvaluateEquation(String equation, ArrayList<Integer> params) throws RemoteException;
}

