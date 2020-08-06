package MISC;
class thread implements Runnable{
	Thread t;
	String name;
	public thread(String name) {
		this.name = name;
		t = new Thread(this,name);
		t.start();
	}
	@Override
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				System.out.println("thread is->" +t.getName() + "value is ->" +i );
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("interuppted exception");
		}
		
	}
	
}
public class Threads_concept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		thread ob1 = new thread("one");
		thread ob2 = new thread("two");
		thread ob3 = new thread("three");
		System.out.println("thread one is alive"+ ob1.t.isAlive());
		System.out.println("thread two is alive"+ ob2.t.isAlive());
		System.out.println("thread three is alive"+ ob2.t.isAlive());
	}

}
