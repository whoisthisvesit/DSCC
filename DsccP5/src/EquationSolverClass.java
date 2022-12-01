/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARENDER KESWANI
 */
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class EquationSolverClass extends UnicastRemoteObject implements
        EquationSolverInterface {

    EquationSolverClass() throws RemoteException {
        super();
    }

    @Override
    public int EvaluateEquation(String equation, ArrayList<Integer> params) {
        System.out.print("Equation recieved: " + equation);
        int a = 0, b = 0, c = 0;
        HashMap<String, Integer> map = new HashMap<>();
        if (params.size() == 2) {
            params.add(c);
        }
        map.put("a^2-b^2", (params.get(0) - params.get(1)) * (params.get(0) + params.get(1)));
        map.put("a^2+b^2", (int) (Math.pow((params.get(0) - params.get(1)), 2)
                + 2 * params.get(0) * params.get(1)));

        map.put("(a+b)^2", (int) (Math.pow(params.get(0), 2) + 2 * params.get(0) * params.get(1)
                + Math.pow(params.get(1), 2)));

        map.put("(a-b)^2", (int) (Math.pow(params.get(0), 2) - 2 * params.get(0) * params.get(1)
                + Math.pow(params.get(1), 2)));

        map.put("(a+b+c)^2", (int) (Math.pow(params.get(0), 2) + Math.pow(params.get(1), 2)
                + Math.pow(params.get(2), 2) + 2 * params.get(0) * params.get(1)
                + 2 * params.get(1) * params.get(2) + 2 * params.get(0) * params.get(2)));

        map.put("(a-b-c)^2", (int) (Math.pow(params.get(0), 2) + Math.pow(params.get(1), 2)
                + Math.pow(params.get(2), 2) - 2 * params.get(0) * params.get(1) + 2 * params.get(1) * params.get(2)
                - 2 * params.get(0) * params.get(1)));

        map.put("a^3-b^3", (int) ((params.get(0) - params.get(1))
                * (Math.pow(params.get(0), 2) + params.get(0) * params.get(1) + Math.pow(params.get(1), 2))));

        map.put("a^3+b^3", (int) ((params.get(0) + params.get(1)) * (Math.pow(params.get(0), 2)
                - params.get(0) * params.get(1) + Math.pow(params.get(1), 2))));

        map.put("(a+b)^3", (int) (Math.pow(params.get(0), 3) + 3 * Math.pow(params.get(0), 2)
                * params.get(1) + 3 * params.get(0) * Math.pow(params.get(1), 2) + Math.pow(params.get(1), 3)));

        map.put("(a-b)^3", (int) (Math.pow(params.get(0), 3) - 3 * Math.pow(params.get(0), 2)
                * params.get(1) + 3 * params.get(0) * Math.pow(params.get(1), 2) - Math.pow(params.get(1), 3)));
        int answer = map.get(equation);

        System.out.print(answer);
        return answer;
    }
}
