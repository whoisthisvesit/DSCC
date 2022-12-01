
import java.rmi.Naming;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARENDER KESWANI
 */
public class Server {
        public static void main(String args[]) {
        try {
            System.out.print("Server started, waiting for client to enter equation");
            IEquationSolver stub = (IEquationSolver) new EquationSolverImpl();
            Naming.rebind("rmi://localhost:5000/narenderEquationSolver", stub);
        } catch (Exception e) {
            System.out.print("exception on server");
            System.out.println(e);
        }
    }
}
