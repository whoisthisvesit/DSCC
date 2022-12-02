
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ITGImpl extends UnicastRemoteObject implements ITGreatest {
	ITGImpl() throws RemoteException {
		super();
	}

	@Override
	public int grestestOfThree(int i, int j, int k) throws RemoteException {
		// TODO Auto-generated method stub
		int result;
		if (i >= j && i >= k) {
			result = i;
		} else if (j >= i && j >= k) {
			result = j;
		} else {
			result = k;
		}
		return result;
	}

}
