import java.io.*;
import java.net.*;
import java.util.*;
public class Server{
	ServerSocket s1;
	//����ArrayList�б��Ŷ���ͷ���
	List<Socket> clients=new ArrayList<Socket>();
	public Server(){
		try {
		//����ͻ�����ͬ���׽��ֶ˿�,�����������׽���
		s1=new ServerSocket(4399);
		while(true) {
			//�������󣬴�����ͻ������ӵ��׽���
			Socket s2=s1.accept();
			//���γ����ӵ��׽��ִ����б�
			clients.add(s2);
			//�����߳���ͻ��˽���ͨ��
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
