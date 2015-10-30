package career16.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exam_16_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Philospher_Old extends Thread {
	private int Num = 100;
	private Lock leftLock;
	private Lock rightLock;

	public Philospher_Old(Lock leftLock, Lock rightLock) {

		this.leftLock = leftLock;
		this.rightLock = rightLock;
	}

	public void run() {
		for (int i = 0; i < Num; i++) {
			try {
				leftLock.lock();
				try {
					rightLock.lock();
					System.out.println("-eat:" + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} finally {
					rightLock.unlock();
				}
			} finally {
				leftLock.unlock();
			}
		}
	}

}

class Philospher_New extends Thread {
	private int Num = 100;
	private Lock leftLock;
	private Lock rightLock;

	public Philospher_New(Lock leftLock, Lock rightLock) {

		this.leftLock = leftLock;
		this.rightLock = rightLock;
	}

	public void run() {
		for (int i = 0; i < Num;) {
			if (leftLock.tryLock()) {
				boolean leftRelease = false;
				try {
					if (rightLock.tryLock()) {
						try {
							System.out.println("-eat:" + i);
							i++;
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						} finally {
							rightLock.unlock();
						}
					} else {
						leftLock.unlock();
						leftRelease = true;
					}

				} finally {
					if (!leftRelease)
						leftLock.unlock();
				}
			}
		}
	}
}
