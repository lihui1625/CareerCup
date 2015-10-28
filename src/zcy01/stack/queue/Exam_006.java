package zcy01.stack.queue;

public class Exam_006 {

	private static class Counter {
		public long totalStep = 0;

		public void increase() {
			totalStep++;
		}

		public long get() {
			return totalStep;
		}
	}

	public static void hano(int n) {
		String from = "S1";
		String buffer = "S2";
		String to = "S3";
		Counter counter = new Counter();
		hano(n, from, to, buffer, counter);
	}

	private static void hano(int n, String from, String to, String buffer,
			Counter counter) {
		if (n <= 0) {
			return;
		}
		hano(n - 1, from, buffer, to, counter);
		move(n, from, to, counter);
		hano(n - 1, buffer, to, from, counter);
	}

	private static void move(int n, String from, String to, Counter counter) {
		counter.increase();
		System.out.println(n + ":" + from + "-->" + to + ", " + counter.get());
	}

	public static void main(String[] args) {
		System.out.println();
		hano(20);
		System.out.println();
//		hano(2);
//		System.out.println();
//		hano(3);
//		System.out.println();
//		hano(4);
//		System.out.println();
//		hano(5);
//		System.out.println();
//		hano(6);
//		System.out.println();
//		hano(7);
//		System.out.println();
//		hano(8);
//		System.out.println();
//		hano(9);
//		System.out.println();
//		hano(10);
//		System.out.println();
//		hano(11);
//		System.out.println();
//		hano(12);
//		System.out.println();

	}

}
