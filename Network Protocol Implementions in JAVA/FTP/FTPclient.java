// FTP Client //
import java.net.*;
import java.io.*;
import java.util.*;

class FTPclient
{
	public static void main(String args[]) throws IOException
	{
		Socket s = new Socket("localhost",8000);
		Scanner sc = new Scanner(s.getInputStream());
		String content = "";
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("END"))
			{
				s.close();
				break;
			}
			content = content + str + "\r\n";
		}
		System.out.println("File Received");
		PrintStream out = new PrintStream(new FileOutputStream("client.txt"));
		out.print(content);
	}
}