package testDemo;


public class Counter {
 
	private static int x =0;
	
	// ��������
	public void count() {
		for(int i=0;i<=10;i++) {
			x = x+i;
		}
		System.out.println(Thread.currentThread().getName()+"--"+x);
	}
	
	public static void main(String[] args) {
		// �����߳�ʵ�ֽӿ�
		Runnable runnable = new Runnable(){
			Counter counter = new Counter();
			@Override
			public void run() {
				counter.count();
			}
		};
		// ����10���߳�
		for(int i=0;i<10;i++) {
			new Thread(runnable).start();
		}
		System.out.print(x);
	}
}
