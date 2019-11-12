package transfort;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

import java.io.IOException;

public class UDPReceiver{
	private DatagramSocket socket=null;										//UDP套接字,用于发送和接受数据包
    private List<DatagramPacket> datagramPackets;
    private int serverPort=4399;												//服务器端口
    private int ReceivePort=4398;
    private InetAddress address=null;										//封装IP
    DatagramPacket datagramPacket;
    String s1="";
    public UDPReceiver(){
        datagramPackets=new ArrayList<DatagramPacket>();
    }

    public void sendData(final List<String> data) {//鍙戦�佽处鍙�
        try {
            socket=new DatagramSocket(ReceivePort);										//UDP濂楁帴瀛�,鐢ㄤ簬鍙戦�佸拰鎺ュ彈鏁版嵁鍖�
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
        datagramPackets.clear();//清除之前所有的数据
        for(int i=0;i<data.size();i++){
            datagramPackets.add(new DatagramPacket(data.get(i).getBytes(),data.get(i).getBytes().length,address,serverPort));//打包并添加
        }

    }
    public void reciveData() {
//      try {
//          //address= InetAddress.getByName("192.168.43.76");
//
//      } catch (Exception e) {
//          e.printStackTrace();
//      }

      new Thread(new Runnable() {
          public void run() {
              while(true) {
                  //for(int i=0;i<1;i++) {
                      try {
//                          Log.i("receive", "启动线程");
                          //packets.clear();
                          //sleep(2000); //让它好好休息一会儿
//                          socket=new DatagramSocket(ReceivePort);
                          //Log.i("recover",packets.size());
                          //packets.add(new DatagramPacket(new byte[1024],new byte[1024].length));
                          byte[] b=new byte[1024];
                          datagramPacket=new DatagramPacket(b,b.length);
                          socket.receive(datagramPacket);
//                          Log.i("receive", datagramPacket.getAddress().toString());
//                          Log.i("receive", Integer.toString(datagramPacket.getPort()));

                          //socket.receive(packets.get(0));
                          //s1=new String(packets.get(0).getData(),0,packets.get(0).getLength());
                          //sleep(1000);
                          s1=new String(datagramPacket.getData(),0,datagramPacket.getLength());
                          System.out.println(s1);
                          //sleep(1000);
//                          socket.close();
                      } catch (Exception e) {
                          e.printStackTrace();
                          break;
                      }
//                  Log.i("receive", "线程结束");
                  //}
                  //Log.i("recover",new String(packets.get(0).getData(),0,packets.get(0).getLength()));
              }
          }
      }).start();

      //Log.i("recover",s1);
//      Log.i("receive",s1);

  }
}