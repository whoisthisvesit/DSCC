import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class ICalculatorImpl extends UnicastRemoteObject implements ICalculatorIntf
{
	public ICalculatorImpl() throws RemoteException
	{}
	public double add(double x,double y) throws RemoteException
	{
		return x+y;
	}
	public double sub(double x,double y) throws RemoteException
	{
		return x-y;
	}
	public double mul(double x,double y) throws RemoteException
	{
		return x*y;
	}
	public double div(double x,double y)  throws RemoteException
	{
		return x/y;
	}
}