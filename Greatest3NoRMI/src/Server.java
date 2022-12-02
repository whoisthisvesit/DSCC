import java.rmi.*;
import java.rmi.registry.*;

public class Server {
	public static void main(String args[]) {
		try {

			ITGreatest stub = new ITGImpl();
			Naming.rebind("rmi://localhost:5000/narender", stub);
		} catch (Exception e) {
			System.out.print("exception on server");
			System.out.println(e);
		}
	}
}
