package algorithm.collections;

public class ObjectTest {

	public synchronized static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		boolean b = obj.equals("");
		Class<?> c = obj.getClass();
		int code = obj.hashCode();
		String str = obj.toString();
		synchronized (ObjectTest.class) {
			obj.notify();
			obj.notifyAll();

			obj.wait(100);
			obj.wait(900, 90);
			obj.wait();
		}

	}
}
