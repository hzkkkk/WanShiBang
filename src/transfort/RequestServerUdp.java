package transfort;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestServerUdp {
	private DatagramSocket socket=null;									//UDP�׽���,���ڷ��ͺͽ������ݰ�
    private DatagramPacket packet1=null;   									//UDP���ݰ�����װ���ݺ�IP��ַ�Ͷ˿�
    private DatagramPacket packet2=null; 
    private DatagramPacket packet3=null; 
    private int ReceivePort=4399;										//ָ�����ܶ˿�Ϊ4399
	private String request;												//�����ַ���
    private InetAddress clientAddress;									//�ͻ���IP
    private int clientPort;												//�ͻ��˶˿�
    List<Map<String,Object>> Clients=new ArrayList<Map<String,Object>>();
    String clientRequest="ע��";
    String answer="�õ����ܵ���";										//�������������������ַ���
    
	public void getData() {
    	try {
			socket=new DatagramSocket(ReceivePort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
    	new Thread(new Runnable() {

    		public void run() {
    			while(true){
    			byte getData1[]=new byte[1024];
//    			byte getData2[]=new byte[1024];
//    			byte getData3[]=new byte[1024];
    			packet1=new DatagramPacket(getData1,getData1.length);
//    			packet2=new DatagramPacket(getData2,getData2.length);
//    			packet3=new DatagramPacket(getData3,getData3.length);
    			
    			try {
					socket.receive(packet1);
//					socket.receive(packet2);
//					socket.receive(packet3);
					System.out.println(new String(packet1.getData(),0,packet1.getLength()));
//					System.out.println(new String(packet2.getData(),0,packet2.getLength()));
//					System.out.println(new String(packet3.getData(),0,packet3.getLength()));
					clientAddress=packet1.getAddress();
					clientPort=packet1.getPort(); 
					request=new String(packet1.getData(),0,packet1.getLength());
					Map<String,Object> map=new HashMap<String,Object>();             //���ü������洢����ͻ���
                    map.put("ip",clientAddress);
                    map.put("port",clientPort);
                    if(!Clients.contains(map)){
                        Clients.add(map);
                    }
                    if(request.equals(clientRequest)) {
                    for(Map map1 :Clients) {
                        //�����µ����ݱ����ش����ͻ���
                    	SendData(socket,(InetAddress)map1.get("ip"),4398);
                    }
                    }

				} catch (IOException e) {
					e.printStackTrace();
				}
    			}
    			}
    		
    		}).start();
    		
    }
    public void SendData(DatagramSocket socket,InetAddress clientAddress,int clientPort) {
    	new Thread(new Runnable() {
    		public void run() {
    			
    			byte sendData1[]=answer.getBytes();
    			byte sendData2[]=answer.getBytes();
    			byte sendData3[]=answer.getBytes();
    			packet1=new DatagramPacket(sendData1,sendData1.length,clientAddress,clientPort);		//ʵ�������ݰ�;
//    			packet2=new DatagramPacket(sendData2,sendData2.length,clientAddress,clientPort);
//    			packet3=new DatagramPacket(sendData3,sendData3.length,clientAddress,clientPort);
    			try {
					socket.send(packet1);
//					socket.send(packet2);
//					socket.send(packet3);
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    		
    	}).start();
    }
}
