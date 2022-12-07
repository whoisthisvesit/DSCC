import java.util.*;
import java.net.*;

public class Server {

	DatagramSocket ds;
	DatagramPacket dp;
	String str, methodName;
	int val1, val2;

	public boolean isPalindrome(int n) {
		int r, sum = 0, temp;
		// int n=454;//It is the number variable to be checked for palindrome

		temp = n;
		while (n > 0) {
			r = n % 10; // getting remainder
			sum = (sum * 10) + r;
			n = n / 10;
		}
		if (temp == sum) {
			System.out.println("palindrome number ");
			return true;
		} else {
			System.out.println("not palindrome");
			return false;
		}

	}

	Server() {
		try {
			ds = new DatagramSocket(1200);
			byte b[] = new byte[4096];
			System.out.println("Server Started : ");

			while (true) {
				dp = new DatagramPacket(b, b.length);
				ds.receive(dp);
				str = new String(dp.getData(), 0, dp.getLength());
				int n = Integer.parseInt(str);

				StringBuilder singleString = new StringBuilder();

				/*
				 * for (int i = 1; i <= limit; i++) { if (isPallindrome(i)) {
				 * singleString.append(i); singleString.append(" "); } }
				 */

				if (isPalindrome(n)) {
					//singleString.append(n);
					singleString.append(n+ " Is a palindrome");

				}
				else
				{
					singleString.append(n+ " is not a palindrome");
				}

				InetAddress ia = InetAddress.getLocalHost();

				byte b1[] = singleString.toString().getBytes();
				DatagramSocket ds1 = new DatagramSocket();
				DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 1300);
				System.out.println("result : " + singleString + "\n");

				ds1.send(dp1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}
