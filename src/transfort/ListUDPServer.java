package transfort;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListUDPServer {
	
	private DatagramSocket socket;
	private List<DatagramPacket> packets=new ArrayList<DatagramPacket>();
	private int ReceivePort=4399;
	List<Map<String,Object>> clients=new ArrayList<Map<String,Object>>();

	public void getData() {
		try {
			socket=new DatagramSocket(ReceivePort);
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {
		public void run() {
			while(true) {
				makeDP();
				for(int i=0;i<packets.size();i++) {
					try {
						socket.receive(packets.get(i));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println(new String(packets.get(0).getData(),0,packets.get(0).getLength()));
				System.out.println(new String(packets.get(1).getData(),0,packets.get(1).getLength()));
				System.out.println(new String(packets.get(2).getData(),0,packets.get(2).getLength()));
    			
			}
		}
		}).start();
	}
	 public void makeDP(){
		 packets.clear();
		 byte getData1[]=new byte[1024];
		 byte getData2[]=new byte[1024];
		 byte getData3[]=new byte[1024];
	     packets.add(new DatagramPacket(getData1,getData1.length));
	     packets.add(new DatagramPacket(getData2,getData2.length));
	     packets.add(new DatagramPacket(getData3,getData3.length));
	    }
}
