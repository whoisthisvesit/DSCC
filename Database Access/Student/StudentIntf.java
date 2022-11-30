import java.rmi.*;
import java.net.*;
import java.util.*;
public interface StudentIntf extends Remote
{
	public abstract ArrayList insert(int id,String name,String course,int age) throws RemoteException;
}