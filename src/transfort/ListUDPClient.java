package transfort;
import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ListUDPClient{
    private DatagramSocket socket=null;										//UDP濂楁帴瀛�,鐢ㄤ簬鍙戦�佸拰鎺ュ彈鏁版嵁鍖�
    private List<DatagramPacket> datagramPackets=new ArrayList<DatagramPacket>();
//    private DatagramPacket packet1=null;   									//UDP鏁版嵁鍖咃紝灏佽鏁版嵁鍜孖P鍦板潃鍜岀鍙�
//    private DatagramPacket packet2=null;
//    private DatagramPacket packet3=null;
    private DatagramPacket receivepacket1=null;   									//UDP鏁版嵁鍖咃紝灏佽鏁版嵁鍜孖P鍦板潃鍜岀鍙�
    private DatagramPacket receivepacket2=null;
    private DatagramPacket receivepacket3=null;

    public String editaccount;														//鍙戦�佺殑瀛楃涓�
    public String editpassword;
    public String order;

    private int serverPort=4399;													//鏈嶅姟鍣ㄧ鍙�
    InetAddress address=null;												//灏佽IP

    public void sendData(final List<String> data) {//鍙戦�佽处鍙�
        try {
            socket=new DatagramSocket();										//UDP濂楁帴瀛�,鐢ㄤ簬鍙戦�佸拰鎺ュ彈鏁版嵁鍖�
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            public void run() {
                //byte sendData1[]=acn.getBytes();										//灏嗘暟鎹浆鎹负瀛楄妭
                try {
                    address= InetAddress.getByName("localhost");//鎹富鏈鸿幏鍙栧搴旂殑InetAddress瀵硅薄
                    makeDP(data);
                    //packet1=new DatagramPacket(sendData1,sendData1.length,address,serverPort);//瀹炰緥鍖栨暟鎹寘;
                    for(int i=0;i<datagramPackets.size();i++)
                    {
                        socket.send(datagramPackets.get(i));//寰幆鍙戦�佹暟鎹寘
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
       
    }

    public void makeDP(List<String> data){
    		
        datagramPackets.clear();
        for(int i=0;i<data.size();i++){
            datagramPackets.add(new DatagramPacket(data.get(i).getBytes(),data.get(i).getBytes().length,address,serverPort));
        }
    		}
   
}

