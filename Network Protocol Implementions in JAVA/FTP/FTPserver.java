// FTP Server //
import java.net.*;
import java.io.*;
import java.util.*;

class FTPserver
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket ss = new ServerSocket(8000);
		Socket s = ss.accept();
		Scanner sc = new Scanner(System.in);
		PrintStream dos = new PrintStream(s.getOutputStream());	
		BufferedReader br = new BufferedReader(new FileReader("server.txt"));
		String line;
		while ((line = br.readLine()) != null) 
			dos.println(line);
		String abc= "END";
		dos.println(abc);
		br.close();
		System.out.println("File Sent");
	}
}