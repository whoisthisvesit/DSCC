
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARENDER KESWANI
 */

public class EquationSolverImpl extends UnicastRemoteObject implements IEquationSolver {

    EquationSolverImpl() throws RemoteException {
        super();
    }

    @Override
    public int EvaluateEquation(String equation, ArrayList<Integer> params) {
        System.out.print("Equation recieved: " + equation);

        // (y^n)
        int answer = (int) (Math.pow((params.get(1)), params.get(0)));

        System.out.print(answer);
        return answer;
    }
}
