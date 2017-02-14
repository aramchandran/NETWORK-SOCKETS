// TCP one way Client //
import java.net.*;
import java.io.*;
import java.util.*;

class TCPoneclient
{
	public static void main(String args[]) throws IOException
	{
		Socket s = new Socket("localhost",8000);
		Scanner sc = new Scanner(s.getInputStream());
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("END"))
			{
				s.close();
				break;
			}
			System.out.println("Message Received : "+str);
		}
	}
}