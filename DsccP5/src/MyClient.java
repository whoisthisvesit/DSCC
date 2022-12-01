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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner; // Import the Scanner class
import java.util.Set;
import java.util.TreeSet;

public class MyClient {

    public static void main(String args[]) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter equation: ");
                String equation = sc.nextLine();
                Set<String> tree = new TreeSet<>();
                ArrayList<Integer> params = new ArrayList<Integer>();
                for (char c : equation.toCharArray()) {
                    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                        tree.add(Character.toString(c));
                    }
                }
                int n = tree.size();
                Iterator value = tree.iterator();
                while (value.hasNext()) {
                    System.out.println("Enter value for " + value.next());
                    int temp = sc.nextInt();
                    params.add(temp);
                }
                EquationSolverInterface stub = (EquationSolverInterface) Naming.lookup("rmi://localhost:5000/narenderEquationSolver");
                System.out.println("Answer: " + stub.EvaluateEquation(equation, params));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
