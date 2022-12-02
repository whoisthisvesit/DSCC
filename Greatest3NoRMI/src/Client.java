import java.rmi.Naming;
import java.util.Scanner;
import java.rmi.*;

public class Client {
	public static void main(String args[]) {
		try {
			ITGreatest stub = (ITGreatest) Naming.lookup("rmi://localhost:5000/narender");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number A");
			int inp1 = Integer.parseInt(sc.nextLine());
			System.out.println("Enter number B");
			int inp2 = Integer.parseInt(sc.nextLine());
			System.out.println("Enter number C");
			int inp3 = Integer.parseInt(sc.nextLine());
			System.out.println("Greatest of Three is" + stub.grestestOfThree(inp1, inp2, inp3));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
