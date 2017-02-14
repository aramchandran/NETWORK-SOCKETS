// UDP two way Client //
import java.net.*;
import java.io.*;
import java.util.*;

class UDPtwoclient
{
	public static void main(String args[]) throws IOException
	{
		DatagramSocket ds,ds1;
		DatagramPacket dp,dp1;
		byte buff[] = new byte[1024];
		byte buff1[] = new byte[1024];
		String str,str1;
		ds = new DatagramSocket(8000);
		ds1 = new DatagramSocket();

		while(true)
		{
			dp = new DatagramPacket (buff,buff.length);
			ds.receive(dp);
			str = new String(dp.getData(),0,0,dp.getLength());
			if(str.equals("END"))
				break;
			System.out.println("Message Received : "+str+" from "+dp.getAddress());
			DataInputStream in = new DataInputStream (System.in);
			System.out.println("Enter Message : ");
			str1 = in.readLine();
			buff1 = str1.getBytes();
			dp1 = new DatagramPacket (buff1,buff1.length,InetAddress.getLocalHost(),9000);
			ds1.send(dp1);
			if(str1.equals("END"))
				break;
		}
	}
}