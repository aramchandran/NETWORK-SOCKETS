// Echo Client //
import java.net.*;
import java.io.*;
import java.util.*;

class Echoclient
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket ss = new ServerSocket(8000);
		Socket s = ss.accept();
		Scanner sc = new Scanner(System.in);
		PrintStream dos = new PrintStream(s.getOutputStream());
		Scanner cc = new Scanner(s.getInputStream());
		Socket c = new Socket("localhost",8000);
		try
		{
			while(true)
			{
				System.out.println("Enter message : ");
				String str = sc.nextLine();
				dos.println(str);
				if(str.equals("END"))
				{
					System.out.println("CONNECTION CLOSED!!!!");
					ss.close();
					s.close();
					break;
				}
				String str1 = cc.nextLine();
				System.out.println("Message Received : "+str1);
				if(str1.equals("END"))
				{
					System.out.println("CONNECTION CLOSED!!!!");
					ss.close();
					s.close();
					break;
				}
			}
		}
		catch(NoSuchElementException n)
		{
			
		}
	}
}