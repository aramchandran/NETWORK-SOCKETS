// UDP one way Client //
import java.net.*;
import java.io.*;
import java.util.*;

class UDPoneclient
{
	public static void main(String args[]) throws IOException
	{
		DatagramSocket ds;
		DatagramPacket dp;
		byte buff[] = new byte[1024];
		String str;
		ds = new DatagramSocket(8000);

		while(true)
		{
			dp = new DatagramPacket (buff,buff.length);
			ds.receive(dp);
			str = new String(dp.getData(),0,0,dp.getLength());
			if(str.equals("END"))
				break;
			System.out.println("Message Received : "+str+" from "+dp.getAddress());
		}
	}
}