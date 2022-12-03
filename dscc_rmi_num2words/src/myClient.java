import java.io.*;
import java.rmi.*;
public class myClient
{
    public static void main(String args[])throws IOException,RemoteException
    {
        int no;
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           System.out.print("Enter a no:");
          no=Integer.parseInt(br.readLine());
        try{

        myInterface mi=(myInterface)Naming.lookup("rmi://localhost:5000/myInterface");
        String f=mi.fact(no);
        System.out.print("Word of "+no+" is:"+f );

        }
        catch(Exception ex)
        {
        }
       
    }
}