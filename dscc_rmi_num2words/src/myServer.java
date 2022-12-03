import java.rmi.*;
import java.rmi.server.*;
public class myServer extends UnicastRemoteObject implements myInterface
{
    public myServer()throws RemoteException
    {
        super();
    }

    public String fact(int i)throws RemoteException
    {
        int n1=i,n2=i;
        int b=n1%10,a=n2/10; //  n1/10 means last digit is removed and n2%10 means last digit by modulus
 
        String[] single_digits = new String[]{"zero","one","two","three","four","five", "six","seven","eight","nine"};
        String[] two_digits = new String[]{"","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen", "nineteen"};
        String[] tens_multiple = new String[]{"","","twenty","thirty","forty","fifty","sixty", "seventy","eighty","ninety"};
        if(a==1)
        {
            return two_digits[b+1];
        }
        else if(b==0)
            return tens_multiple[a];
        else
            return ""+ tens_multiple[a]+"-"+single_digits[b];

    }
    public static void main(String args[])
    {
        try{
            myServer ms=new myServer();
            Naming.rebind("rmi://localhost:5000/myInterface",ms);
/*  bolded area must replace with your computer name */
            System.out.print("Start...");
           
        }

        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}