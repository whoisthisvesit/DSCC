import java.rmi.*;
import java.rmi.server.*;
public class DateImpl extends UnicastRemoteObject implements DateIntf
{
	public DateImpl() throws RemoteException
	{}
	public String Today_Date() throws RemoteException
	{
		return "Today Date and Time is: "+new java.util.Date()+" ";
	}
}