package transfort;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String args[]){
/*		ServerNoEcho server1=new ServerNoEcho();
		UDPClient client1=new UDPClient("1","2","3","4","5","6","7");
		client1.SendData();
		server1.getAndsendData();
		server1.print();*/
//		UDPServer u1=new UDPServer();
//		u1.getAndsendData();
		
//		RequestServerUdp reqServer=new RequestServerUdp();
//		RequestClientUdp reqClient=new RequestClientUdp();
//		reqClient.SendData();
//		reqServer.getData();
//		reqClient.getData();
		List<String> data=new ArrayList<String>();
		data.add("我是弟弟");
//		data.add("我是哥哥");
//		data.add("我是爸爸");
		UDPReceiver client=new UDPReceiver();
		ServerNoEcho server=new ServerNoEcho();
		client.sendData(data);
		server.getAndsendData();
		client.reciveData();
}
}
