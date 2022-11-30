import java.rmi.*;
import java.io.*;
public interface DateIntf extends Remote
{
	public String Today_Date() throws RemoteException;
}

//rmic DateImpl.java
//start rmiregistry
//java DateServer