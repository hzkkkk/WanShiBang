package transfort;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class RequestClientUdp {
	 private DatagramSocket socket=null;										//UDP�׽���,���ڷ��ͺͽ������ݰ�
	 private DatagramPacket packet1=null;   									//UDP���ݰ�����װ���ݺ�IP��ַ�Ͷ˿�
	 private DatagramPacket packet2=null;
	 private DatagramPacket packet3=null;   									
	 private DatagramPacket receivepacket1=null;   
	 private DatagramPacket receivepacket2=null;   
	 private DatagramPacket receivepacket3=null;   
	 InetAddress address;													//��װIP
	 private int serverPort=4399;													//�������˿�
	 String request="ע��";
	 String s1="111",s2="222";
	//�����˷�������
    public void SendData() {
        try {
            socket=new DatagramSocket();										//UDP�׽���,���ڷ��ͺͽ������ݰ�
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            public void run() {
                byte sendData1[]=request.getBytes();										//������ת��Ϊ�ֽ�
                byte sendData2[]=s1.getBytes();		
                byte sendData3[]=s2.getBytes();		
                try {
                    address=InetAddress.getByName("localhost");							//��������ȡ��Ӧ��InetAddress����
                    packet1=new DatagramPacket(sendData1,sendData1.length,address,serverPort);		//ʵ�������ݰ�; 
                    packet2=new DatagramPacket(sendData2,sendData2.length,address,serverPort);		//ʵ�������ݰ�; 
                    packet3=new DatagramPacket(sendData3,sendData3.length,address,serverPort);		//ʵ�������ݰ�; 
                    System.out.println(new String(packet1.getData(),0,packet1.getLength()));
                    System.out.println(new String(packet2.getData(),0,packet2.getLength()));
                    System.out.println(new String(packet3.getData(),0,packet3.getLength()));
                    socket.send(packet1);												//�������ݰ�
                    socket.send(packet2);
                    socket.send(packet3);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }).start();
    }
    //���ܷ�����������
    public void getData() {
        try {
            socket=new DatagramSocket(4398);											//UDP�׽���,���ڷ��ͺͽ������ݰ�
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    byte getData1[]=new byte[1024];
                    byte getData2[]=new byte[1024];
                    byte getData3[]=new byte[1024];
                    receivepacket1=new DatagramPacket(getData1,getData1.length);				//�����յ����ݱ������ڽ�������
//                    receivepacket2=new DatagramPacket(getData2,getData2.length);				//�����յ����ݱ������ڽ�������
//                    receivepacket3=new DatagramPacket(getData3,getData3.length);				//�����յ����ݱ������ڽ�������
                    try {
                        socket.receive(receivepacket1);
//                        socket.receive(receivepacket2);
//                        socket.receive(receivepacket3);
                        String s1=new String(receivepacket1.getData(),0,receivepacket1.getLength());
//                        String s2=new String(receivepacket2.getData(),0,receivepacket2.getLength());
//                        String s3=new String(receivepacket3.getData(),0,receivepacket3.getLength());
                        System.out.println("�ͻ����յ���������"+receivepacket1.getAddress().getHostAddress()+":"+receivepacket1.getPort()+"�ش���Ϣ:"+s1.trim());
//                        System.out.println("�ͻ����յ���������"+receivepacket1.getAddress().getHostAddress()+":"+receivepacket1.getPort()+"�ش���Ϣ:"+s2.trim());
//                        System.out.println("�ͻ����յ���������"+receivepacket1.getAddress().getHostAddress()+":"+receivepacket1.getPort()+"�ش���Ϣ:"+s3.trim());
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
