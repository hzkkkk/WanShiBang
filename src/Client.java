import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
	public Client(){
		try {
			Socket s1=new Socket("",4399);
			//��ȡ����������ַ������IP
			InetAddress ladd=s1.getLocalAddress();
			String ip=ladd.getHostAddress();
			//��ȡ���ض˿ں�
			int port=s1.getLocalPort();
			System.out.print("���ӳɹ�:");
			//����ͻ��˵�ַ
			System.out.println("�ͻ��˵�ַ:"+ip+":"+port);
			//���������
			OutputStream os=s1.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			BufferedWriter bw=new BufferedWriter(osw);
			//����������
			InputStream is=s1.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader buf=new BufferedReader(isr);
			//�Ӽ�������һ������
			Scanner input=new Scanner(System.in);
			//�ͻ����������������Ϣ
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
			//�ͻ��˽��ܷ�������Ϣ
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
