import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.List;
public class ServerThread extends Thread{
	Socket s2;			//与客户端连接的套接字
	List<Socket> clients;		//连接到客户端的所有套接字
	String ClientHostAddress;	//客户端的IP地址
	int ClientPort;				//客户端的端口号
	public ServerThread(Socket s2,List<Socket> clients) {
		super();
		this.s2=s2;
		this.clients=clients;
	}
	//执行线程，接受来自客户端的信息，发送给列表中的客户端
	public void run() {
		// 获取与服务器连接的当前客户端的Socket地址
		InetSocketAddress ClientAddress=(InetSocketAddress)s2.getRemoteSocketAddress();
		//获取与服务器连接的客户端Socket的IP地址
		ClientHostAddress=ClientAddress.getHostName();
		//获取与服务器连接的客户端Socket的端口号
		ClientPort=ClientAddress.getPort();
		System.out.println("第"+clients.size()+"个客户端成功连接"+"Ip："+ClientHostAddress+"端口："+ClientPort);
		try {
			//定义输入流
			InputStream is =s2.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader buf=new BufferedReader(isr);
			String s;
			//接受客户端的消息，回传给客户端
			while((s=buf.readLine())!=null) {
				System.out.println("客户端"+ClientHostAddress+":"+ClientPort+"发来消息："+s);
				//使用for循环将信息返送回所有客户端
				for(Socket s1:clients) {
					if(s1!=null) {
						//定义输出流
						OutputStream os=s1.getOutputStream();
						OutputStreamWriter osw=new OutputStreamWriter(os);
						BufferedWriter bw=new BufferedWriter(osw);
						bw.write("客户端"+ClientHostAddress+":"+ClientPort+"发来消息："+s);
						bw.newLine();
						bw.flush();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			// 当客户端关闭连接，服务器端无法发送接收数据发生异常
						System.err.println("客户端"+ClientHostAddress + ":" + ClientPort + "退出了。");
		}
		
	}
}
