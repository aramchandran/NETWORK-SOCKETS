// TCP one way Server //
import java.net.*;
import java.io.*;
import java.util.*;

class TCPoneserver
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket ss = new ServerSocket(8000);
		Socket s = ss.accept();
		Scanner sc = new Scanner(System.in);
		PrintStream dos = new PrintStream(s.getOutputStream());
		while(true)
		{
			System.out.println("Enter message : ");
			String str = sc.nextLine();
			dos.println(str);
			if(str.equals("END"))
			{
				ss.close();
				s.close();
				break;
			}
		}
	}
}