import java.rmi.*;
import java.sql.*;
public interface IDb extends Remote
{
	public String getData(String s) throws RemoteException;
}