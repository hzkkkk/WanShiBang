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
public class UDPServer {
    private DatagramSocket socket=null;									//UDP�׽���,���ڷ��ͺͽ������ݰ�
    private DatagramPacket packet1=null;   									//UDP���ݰ�����װ���ݺ�IP��ַ�Ͷ˿�
    private DatagramPacket packet2=null;
    private DatagramPacket packet3=null;
    private DatagramPacket packet4=null;
    private DatagramPacket packet5=null;
    private DatagramPacket packet6=null;
    private DatagramPacket packet7=null;
    private int ReceivePort=4399;										//ָ�����ܶ˿�Ϊ4399
    List<Map<String,Object>> Clients=new ArrayList<Map<String,Object>>();

    //���ܿͻ������ݺͻش�
    public void getAndsendData() {
        try {
            socket=new DatagramSocket(ReceivePort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    byte getData1[]=new byte[1024];
                    byte getData2[]=new byte[1024];
                    byte getData3[]=new byte[1024];
                    byte getData4[]=new byte[1024];
                    byte getData5[]=new byte[1024];
                    byte getData6[]=new byte[1024];
                    byte getData7[]=new byte[1024];

                    packet1=new DatagramPacket(getData1,getData1.length);                  //�����յ����ݱ������ڽ�������
                    packet2=new DatagramPacket(getData2,getData2.length);
                    packet3=new DatagramPacket(getData3,getData3.length);
                    packet4=new DatagramPacket(getData4,getData4.length);
                    packet5=new DatagramPacket(getData5,getData5.length);
                    packet6=new DatagramPacket(getData6,getData6.length);
                    packet7=new DatagramPacket(getData7,getData7.length);

                    try {
                        socket.receive(packet1);
                        socket.receive(packet2);
                        socket.receive(packet3);
                        socket.receive(packet4);
                        socket.receive(packet5);
                        socket.receive(packet6);
                        socket.receive(packet7);
                        InetAddress ClientAddress=packet1.getAddress();                  //��ȡ�ͻ��˵�ַ
                        System.out.println(ClientAddress);
                        int ClientPort=packet1.getPort();                                //��ȡ�ͻ��˶˿�
                        Map<String,Object> map=new HashMap<String,Object>();             //���ü������洢����ͻ���
                        map.put("ip",ClientAddress);
                        map.put("port",ClientPort);
                        if(!Clients.contains(map)){
                            Clients.add(map);
                        }
                        System.out.println("�������յ��ͻ���:"+map.get("ip")+":"+map.get("port")+"������Ϣ��"+new String(packet1.getData(),0,packet1.getLength()).trim());
                        System.out.println("�������յ��ͻ���:"+map.get("ip")+":"+map.get("port")+"������Ϣ��"+new String(packet2.getData(),0,packet2.getLength()).trim());
                        System.out.println("�������յ��ͻ���:"+map.get("ip")+":"+map.get("port")+"������Ϣ��"+new String(packet3.getData(),0,packet3.getLength()).trim());
                        System.out.println("�������յ��ͻ���:"+map.get("ip")+":"+map.get("port")+"������Ϣ��"+new String(packet4.getData(),0,packet4.getLength()).trim());
                        System.out.println("�������յ��ͻ���:"+map.get("ip")+":"+map.get("port")+"������Ϣ��"+new String(packet5.getData(),0,packet5.getLength()).trim());
                        System.out.println("�������յ��ͻ���:"+map.get("ip")+":"+map.get("port")+"������Ϣ��"+new String(packet6.getData(),0,packet6.getLength()).trim());
                        System.out.println("�������յ��ͻ���:"+map.get("ip")+":"+map.get("port")+"������Ϣ��"+new String(packet7.getData(),0,packet7.getLength()).trim());

                        for(Map map1 :Clients) {
                            //�����µ����ݱ����ش����ͻ���
                            packet1=new DatagramPacket(packet1.getData(),packet1.getLength(),(InetAddress)map1.get("ip"),(int)map1.get("port"));
                            packet2=new DatagramPacket(packet2.getData(),packet2.getLength(),(InetAddress)map1.get("ip"),(int)map1.get("port"));
                            packet3=new DatagramPacket(packet3.getData(),packet3.getLength(),(InetAddress)map1.get("ip"),(int)map1.get("port"));
                            packet4=new DatagramPacket(packet4.getData(),packet4.getLength(),(InetAddress)map1.get("ip"),(int)map1.get("port"));
                            packet5=new DatagramPacket(packet5.getData(),packet5.getLength(),(InetAddress)map1.get("ip"),(int)map1.get("port"));
                            packet6=new DatagramPacket(packet6.getData(),packet6.getLength(),(InetAddress)map1.get("ip"),(int)map1.get("port"));
                            packet7=new DatagramPacket(packet7.getData(),packet7.getLength(),(InetAddress)map1.get("ip"),(int)map1.get("port"));
                            socket.send(packet1);
                            socket.send(packet2);
                            socket.send(packet3);
                            socket.send(packet4);
                            socket.send(packet5);
                            socket.send(packet6);
                            socket.send(packet7);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    
    
    
}

