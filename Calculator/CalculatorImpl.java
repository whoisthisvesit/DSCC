import java.rmi.*;
import java.net.*;
import java.rmi.server.*;
public class CalculatorImpl extends UnicastRemoteObject implements Calculator
{
	public CalculatorImpl() throws RemoteException
	{
	}
	public double add(double a,double b) throws RemoteException
	{
		return a+b;
	}
	public double sub(double a,double b) throws RemoteException
	{
		return a-b;
	}
	public double mul(double a,double b) throws RemoteException
	{
		return a*b;
	}
	public double div(double a,double b) throws RemoteException
	{
		return a/b;
	}
} 