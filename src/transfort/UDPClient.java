package transfort;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
    private DatagramSocket socket=null;										//UDP�׽���,���ڷ��ͺͽ������ݰ�
    private DatagramPacket packet1=null;   									//UDP���ݰ�����װ���ݺ�IP��ַ�Ͷ˿�
    private DatagramPacket packet2=null;
    private DatagramPacket packet3=null;
    private DatagramPacket packet4=null;
    private DatagramPacket packet5=null;
    private DatagramPacket packet6=null;
    private DatagramPacket packet7=null;
    private int serverPort=4399;													//�������˿�
    private String str1;														//���͵��ַ���
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    private String str6;
    private String str7;
    InetAddress address=null;												//��װIP
    public UDPClient(String str1,String str2,String str3,String str4,String str5,String str6,String str7) {
        this.str1=str1;
        this.str2=str2;
        this.str3=str3;
        this.str4=str4;
        this.str5=str5;
        this.str6=str6;
        this.str7=str7;
    }
    //�����˷�������
    public void SendData() {
        try {
            socket=new DatagramSocket();										//UDP�׽���,���ڷ��ͺͽ������ݰ�
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            public void run() {
                byte sendData1[]=str1.getBytes();										//������ת��Ϊ�ֽ�
                byte sendData2[]=str2.getBytes();
                byte sendData3[]=str3.getBytes();
                byte sendData4[]=str4.getBytes();
                byte sendData5[]=str5.getBytes();
                byte sendData6[]=str6.getBytes();
                byte sendData7[]=str7.getBytes();
                try {
                    address=InetAddress.getByName("localhost");							//��������ȡ��Ӧ��InetAddress����
                    packet1=new DatagramPacket(sendData1,sendData1.length,address,serverPort);		//ʵ�������ݰ�;
                    packet2=new DatagramPacket(sendData2,sendData2.length,address,serverPort);
                    packet3=new DatagramPacket(sendData3,sendData3.length,address,serverPort);
                    packet4=new DatagramPacket(sendData4,sendData4.length,address,serverPort);
                    packet5=new DatagramPacket(sendData5,sendData5.length,address,serverPort);
                    packet6=new DatagramPacket(sendData6,sendData6.length,address,serverPort);
                    packet7=new DatagramPacket(sendData7,sendData7.length,address,serverPort);
                    socket.send(packet1);												//�������ݰ�
                    socket.send(packet2);
                    socket.send(packet3);
                    socket.send(packet4);
                    socket.send(packet5);
                    socket.send(packet6);
                    socket.send(packet7);



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
            socket=new DatagramSocket();											//UDP�׽���,���ڷ��ͺͽ������ݰ�
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
                    packet1=new DatagramPacket(getData1,getData1.length);				//�����յ����ݱ������ڽ�������
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
                        String s1=new String(packet1.getData(),0,packet1.getLength());
                        String s2=new String(packet2.getData(),0,packet2.getLength());
                        String s3=new String(packet3.getData(),0,packet3.getLength());
                        String s4=new String(packet4.getData(),0,packet4.getLength());
                        String s5=new String(packet5.getData(),0,packet5.getLength());
                        String s6=new String(packet6.getData(),0,packet6.getLength());
                        String s7=new String(packet7.getData(),0,packet7.getLength());
                        System.out.println("�ͻ����յ���������"+packet1.getAddress().getHostAddress()+":"+packet1.getPort()+"�ش���Ϣ:"+s1.trim());
                        System.out.println("�ͻ����յ���������"+packet1.getAddress().getHostAddress()+":"+packet1.getPort()+"�ش���Ϣ:"+s2.trim());
                        System.out.println("�ͻ����յ���������"+packet1.getAddress().getHostAddress()+":"+packet1.getPort()+"�ش���Ϣ:"+s3.trim());
                        System.out.println("�ͻ����յ���������"+packet1.getAddress().getHostAddress()+":"+packet1.getPort()+"�ش���Ϣ:"+s4.trim());
                        System.out.println("�ͻ����յ���������"+packet1.getAddress().getHostAddress()+":"+packet1.getPort()+"�ش���Ϣ:"+s5.trim());
                        System.out.println("�ͻ����յ���������"+packet1.getAddress().getHostAddress()+":"+packet1.getPort()+"�ش���Ϣ:"+s6.trim());
                        System.out.println("�ͻ����յ���������"+packet1.getAddress().getHostAddress()+":"+packet1.getPort()+"�ش���Ϣ:"+s7.trim());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}


