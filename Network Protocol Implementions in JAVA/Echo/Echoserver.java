// Echo Server //
import java.net.*;
import java.io.*;
import java.util.*;

class Echoserver
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			Socket s = new Socket("localhost",8000);
			Scanner sc = new Scanner(s.getInputStream());
			PrintStream dos = new PrintStream(s.getOutputStream());
			while(true)
			{
				String str = sc.nextLine();
				if(str.equals("END"))
				{
					System.out.println("CONNECTION CLOSED!!!!");
					s.close();
					break;
				}
				System.out.println("Message Received : "+str);
				dos.println(str);
			}
		}
		catch(NoSuchElementException n)
		{
			
		}
	}
}