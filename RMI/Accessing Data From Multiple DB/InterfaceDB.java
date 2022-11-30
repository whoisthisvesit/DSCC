import java.rmi.*;
public interface InterfaceDB extends Remote
{
	public String getData(String s,String db) throws RemoteException;
}