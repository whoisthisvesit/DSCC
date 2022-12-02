
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITGreatest extends Remote {
	public int grestestOfThree(int i, int j, int k) throws RemoteException;
}
