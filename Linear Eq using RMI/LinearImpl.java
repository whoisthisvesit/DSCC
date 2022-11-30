import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class LinearImpl extends UnicastRemoteObject implements LinearIntf
{
	public LinearImpl() throws RemoteException
	{}
	public double LinearCalc(double a,double b) throws RemoteException
	{
		return ((a*a)-(2*a*b)+(b*b));
	} 
}