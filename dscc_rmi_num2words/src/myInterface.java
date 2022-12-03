import java.rmi.*;
public interface myInterface extends Remote
{
    String fact(int i)throws RemoteException;
}