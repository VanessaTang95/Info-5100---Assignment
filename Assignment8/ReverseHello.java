package assignment8;

public class ReverseHello extends Thread{
	private int num;
	final private int MAX=51;
	ReverseHello(int num){
		super("Thread "+num);
		this.num=num;
	}
	
	@Override
	public void run() {
		num++;
		if(num<=MAX) {
			ReverseHello new_thread=new ReverseHello(num);
			new_thread.start();
		try {
		new_thread.join();
		System.out.println("Hello from "+getName());
		}catch(Exception e) {
			
		}
		
	}
	}
	
	public static void main(String[] args) {
		new ReverseHello(1).start();
	}

}
