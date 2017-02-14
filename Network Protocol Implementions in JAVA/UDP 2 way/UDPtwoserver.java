// UDP two way Server //
import java.net.*;
import java.io.*;
import java.util.*;

class UDPtwoserver
{
	public static void main(String args[]) throws IOException
	{
		DatagramSocket ds,ds1;
		DatagramPacket dp,dp1;
		byte buff[] = new byte[1024];
		byte buff1[] = new byte[1024];
		String str,str1;
		ds = new DatagramSocket();
		ds1 = new DatagramSocket(9000);
		while(true)
		{
			DataInputStream in = new DataInputStream (System.in);
			System.out.println("Enter Message : ");
			str = in.readLine();
			buff = str.getBytes();
			dp = new DatagramPacket (buff,buff.length,InetAddress.getLocalHost(),8000);
			ds.send(dp);
			if(str.equals("END"))
				break;
			dp1 = new DatagramPacket (buff1,buff1.length);
			ds1.receive(dp1);
			str1 = new String(dp1.getData(),0,0,dp1.getLength());
			if(str1.equals("END"))
				break;
			System.out.println("Message Received : "+str1+" from "+dp1.getAddress());
		}
	}
}