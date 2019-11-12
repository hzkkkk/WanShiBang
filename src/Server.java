import java.io.*;
import java.net.*;
import java.util.*;
public class Server{
	ServerSocket s1;
	//创建ArrayList列表存放多个客服端
	List<Socket> clients=new ArrayList<Socket>();
	public Server(){
		try {
		//绑定与客户端相同的套接字端口,建立服务器套接字
		s1=new ServerSocket(4399);
		while(true) {
			//监听请求，创建与客户端连接的套接字
			Socket s2=s1.accept();
			//将形成连接的套接字存入列表
			clients.add(s2);
			//启动线程与客户端进行通信
			ServerThread t1=new ServerThread(s2,clients);
			t1.start();
		}		
	}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server server=new Server();
	}
}
