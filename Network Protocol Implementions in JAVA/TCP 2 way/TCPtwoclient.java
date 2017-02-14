// TCP two way Client //
import java.net.*;
import java.io.*;
import java.util.*;

class TCPtwoclient
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			Socket s = new Socket("localhost",8000);
			Scanner sc = new Scanner(s.getInputStream());
			Scanner cc = new Scanner(System.in);
			PrintStream dos = new PrintStream(s.getOutputStream());
			while(true)
			{
				System.out.println("Enter message : ");
				String str1 = cc.nextLine();
				dos.println(str1);
				if(str1.equals("END"))
				{
					System.out.println("CONNECTION CLOSED!!!!");
					s.close();
					break;
				}
				String str = sc.nextLine();
				if(str.equals("END"))
				{
					System.out.println("CONNECTION CLOSED!!!!");
					s.close();
					break;
				}
				System.out.println("Message Received : "+str);
			}
		}
		catch(NoSuchElementException n)
		{
			
		}
	}
}