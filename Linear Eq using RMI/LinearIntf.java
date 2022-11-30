import java.rmi.*;
import java.io.*;
public interface LinearIntf extends Remote
{
	public double LinearCalc(double a,double b) throws RemoteException;
}