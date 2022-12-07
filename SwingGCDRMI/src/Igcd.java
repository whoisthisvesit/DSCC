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
import java.util.ArrayList;
public interface Igcd extends Remote {
	public int EvaluateGcd(int a, int b) throws RemoteException;
}
