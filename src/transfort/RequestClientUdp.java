package transfort;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class RequestClientUdp {
	 private DatagramSocket socket=null;										//UDP套接字,用于发送和接受数据包
	 private DatagramPacket packet1=null;   									//UDP数据包，封装数据和IP地址和端口
	 private DatagramPacket packet2=null;
	 private DatagramPacket packet3=null;   									
	 private DatagramPacket receivepacket1=null;   
	 private DatagramPacket receivepacket2=null;   
	 private DatagramPacket receivepacket3=null;   
	 InetAddress address;													//封装IP
	 private int serverPort=4399;													//服务器端口
	 String request="注册";
	 String s1="111",s2="222";
	//向服务端发送数据
    public void SendData() {
        try {
            socket=new DatagramSocket();										//UDP套接字,用于发送和接受数据包
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            public void run() {
                byte sendData1[]=request.getBytes();										//将数据转换为字节
                byte sendData2[]=s1.getBytes();		
                byte sendData3[]=s2.getBytes();		
                try {
                    address=InetAddress.getByName("localhost");							//据主机获取对应的InetAddress对象
                    packet1=new DatagramPacket(sendData1,sendData1.length,address,serverPort);		//实例化数据包; 
                    packet2=new DatagramPacket(sendData2,sendData2.length,address,serverPort);		//实例化数据包; 
                    packet3=new DatagramPacket(sendData3,sendData3.length,address,serverPort);		//实例化数据包; 
                    System.out.println(new String(packet1.getData(),0,packet1.getLength()));
                    System.out.println(new String(packet2.getData(),0,packet2.getLength()));
                    System.out.println(new String(packet3.getData(),0,packet3.getLength()));
                    socket.send(packet1);												//发送数据包
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
    //接受服务器端数据
    public void getData() {
        try {
            socket=new DatagramSocket(4398);											//UDP套接字,用于发送和接受数据包
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    byte getData1[]=new byte[1024];
                    byte getData2[]=new byte[1024];
                    byte getData3[]=new byte[1024];
                    receivepacket1=new DatagramPacket(getData1,getData1.length);				//创建空的数据报，用于接受数据
//                    receivepacket2=new DatagramPacket(getData2,getData2.length);				//创建空的数据报，用于接受数据
//                    receivepacket3=new DatagramPacket(getData3,getData3.length);				//创建空的数据报，用于接受数据
                    try {
                        socket.receive(receivepacket1);
//                        socket.receive(receivepacket2);
//                        socket.receive(receivepacket3);
                        String s1=new String(receivepacket1.getData(),0,receivepacket1.getLength());
//                        String s2=new String(receivepacket2.getData(),0,receivepacket2.getLength());
//                        String s3=new String(receivepacket3.getData(),0,receivepacket3.getLength());
                        System.out.println("客户端收到服务器："+receivepacket1.getAddress().getHostAddress()+":"+receivepacket1.getPort()+"回传消息:"+s1.trim());
//                        System.out.println("客户端收到服务器："+receivepacket1.getAddress().getHostAddress()+":"+receivepacket1.getPort()+"回传消息:"+s2.trim());
//                        System.out.println("客户端收到服务器："+receivepacket1.getAddress().getHostAddress()+":"+receivepacket1.getPort()+"回传消息:"+s3.trim());
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
