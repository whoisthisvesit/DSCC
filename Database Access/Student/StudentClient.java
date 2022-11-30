import java.rmi.*;
import java.net.*;
import java.rmi.server.*;
import java.util.*;
import java.io.*;
import java.sql.*;
public class StudentClient
{
	public static void main(String args[]) throws Exception
	{
		String url="rmi://"+args[0]+"/StdInfo";
		StudentIntf si=(StudentIntf)Naming.lookup(url);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id: ");
		int id=sc.nextInt();
		System.out.println("Enter the name: ");
		String name=sc.next();
		System.out.println("Enter the course: ");
		String course=sc.next();
		System.out.println("Enter the age: ");
		int age=sc.nextInt();
		ArrayList al=si.insert(id,name,course,age);
		Iterator it=al.iterator();
		while(it.hasNext())
		{
			System.out.println("Id:"+it.next()+"\nName:"+it.next()+"\nCourse:"+it.next()+"\nAge:");
		}
	}
}