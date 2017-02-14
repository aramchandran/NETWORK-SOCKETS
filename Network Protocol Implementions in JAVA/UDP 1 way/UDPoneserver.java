// UDP one way Server //
import java.net.*;
import java.io.*;
import java.util.*;

class UDPoneserver
{
	public static void main(String args[]) throws IOException
	{
		DatagramSocket ds;
		DatagramPacket dp;
		byte buff[] = new byte[1024];
		String str;

		while(true)
		{
			ds = new DatagramSocket();
			DataInputStream in = new DataInputStream (System.in);
			System.out.println("Enter Message : ");
			str = in.readLine();
			buff = str.getBytes();
			dp = new DatagramPacket (buff,buff.length,InetAddress.getLocalHost(),8000);
			ds.send(dp);
			if(str.equals("END"))
				break;
		}
	}
}