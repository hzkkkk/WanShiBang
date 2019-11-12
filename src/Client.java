import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
	public Client(){
		try {
			Socket s1=new Socket("",4399);
			//获取本地主机地址，主机IP
			InetAddress ladd=s1.getLocalAddress();
			String ip=ladd.getHostAddress();
			//获取本地端口号
			int port=s1.getLocalPort();
			System.out.print("连接成功:");
			//输出客户端地址
			System.out.println("客户端地址:"+ip+":"+port);
			//定义输出流
			OutputStream os=s1.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			BufferedWriter bw=new BufferedWriter(osw);
			//定义输入流
			InputStream is=s1.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader buf=new BufferedReader(isr);
			//从键盘输入一行数据
			Scanner input=new Scanner(System.in);
			//客户端向服务器发送信息
			new Thread(new Runnable() {
				public void run() {
					String s1;
					try {
					while((s1=input.nextLine())!=null) {
						
							bw.write(s1);
							bw.newLine();
							bw.flush();
				} 
					}
						catch (IOException e) {
							e.printStackTrace();
							System.exit(1);
						}
						
				}
			}).start();
			//客户端接受服务器信息
			new Thread(new Runnable() {		
				public void run() {
					String s2;
					try {
					while((s2=buf.readLine())!=null) {
							System.out.println(s2);
						}
					} 
					catch (IOException e) {
						e.printStackTrace();
						System.exit(1);
					}
				}
			}).start();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Client client=new Client();
	}
}
