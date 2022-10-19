package threadSynchronisation;

class sync {
	synchronized public void test(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception Caught!!!");
			}
		}
	}
}

class NewThread extends Thread {
	sync t;

	NewThread(sync t) {
		this.t = t;
	}

	public void run() {
		t.test(10);
	}
}

class MyThread extends Thread {
	sync t;

	MyThread(sync t) {
		this.t = t;
	}

	public void run() {
		t.test(100);
	}
}

public class synchronize {

	public static void main(String[] args) {
		sync obj = new sync();
		NewThread n = new NewThread(obj);
		MyThread m = new MyThread(obj);
		n.start();
		m.start();

	}

}
