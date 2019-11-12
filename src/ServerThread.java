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
	Socket s2;			//��ͻ������ӵ��׽���
	List<Socket> clients;		//���ӵ��ͻ��˵������׽���
	String ClientHostAddress;	//�ͻ��˵�IP��ַ
	int ClientPort;				//�ͻ��˵Ķ˿ں�
	public ServerThread(Socket s2,List<Socket> clients) {
		super();
		this.s2=s2;
		this.clients=clients;
	}
	//ִ���̣߳��������Կͻ��˵���Ϣ�����͸��б��еĿͻ���
	public void run() {
		// ��ȡ����������ӵĵ�ǰ�ͻ��˵�Socket��ַ
		InetSocketAddress ClientAddress=(InetSocketAddress)s2.getRemoteSocketAddress();
		//��ȡ����������ӵĿͻ���Socket��IP��ַ
		ClientHostAddress=ClientAddress.getHostName();
		//��ȡ����������ӵĿͻ���Socket�Ķ˿ں�
		ClientPort=ClientAddress.getPort();
		System.out.println("��"+clients.size()+"���ͻ��˳ɹ�����"+"Ip��"+ClientHostAddress+"�˿ڣ�"+ClientPort);
		try {
			//����������
			InputStream is =s2.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader buf=new BufferedReader(isr);
			String s;
			//���ܿͻ��˵���Ϣ���ش����ͻ���
			while((s=buf.readLine())!=null) {
				System.out.println("�ͻ���"+ClientHostAddress+":"+ClientPort+"������Ϣ��"+s);
				//ʹ��forѭ������Ϣ���ͻ����пͻ���
				for(Socket s1:clients) {
					if(s1!=null) {
						//���������
						OutputStream os=s1.getOutputStream();
						OutputStreamWriter osw=new OutputStreamWriter(os);
						BufferedWriter bw=new BufferedWriter(osw);
						bw.write("�ͻ���"+ClientHostAddress+":"+ClientPort+"������Ϣ��"+s);
						bw.newLine();
						bw.flush();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			// ���ͻ��˹ر����ӣ����������޷����ͽ������ݷ����쳣
						System.err.println("�ͻ���"+ClientHostAddress + ":" + ClientPort + "�˳��ˡ�");
		}
		
	}
}
