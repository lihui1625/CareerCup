package algorithm.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TransferQueue;

public class QueueTest {

	public static void queueTest() {
		Queue<String> queue = new LinkedList<>();
		Queue<String> queue2 = new ConcurrentLinkedQueue<>();
	}

	public static void arrayBlockingQueueTest() {
		Queue<String> queue = new ArrayBlockingQueue<String>(100);
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(
				100);

	}

	public static void linkedBlockingQueueTest() {
		Queue<String> queue = new LinkedBlockingQueue<String>(100);
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(
				100);
	}

	public static void delayQueueTest() {
		Queue<Delayed> queue = new DelayQueue<Delayed>();
		BlockingQueue<Delayed> blockingQueue = new DelayQueue<Delayed>();
	}

	public static void priorityQueueTest() {
		Queue<String> queue = new PriorityQueue<String>(100);

	}

	public static void priorityBlockingQueueTest() {
		Queue<String> queue1 = new PriorityBlockingQueue<String>(100);
		BlockingQueue<String> queue2 = new PriorityBlockingQueue<String>(100);

	}

	public static void synchronousQueueQueueTest() {
		Queue<String> queue1 = new SynchronousQueue<String>();
		BlockingQueue<String> queue2 = new SynchronousQueue<String>();

	}

	public static void linkedTransferQueueTest() {
		Queue<String> queue1 = new LinkedTransferQueue<String>();
		BlockingQueue<String> queue2 = new LinkedTransferQueue<String>();
		TransferQueue<String> queue3 = new LinkedTransferQueue<String>();
	}

	public static void deQueueTest() {
		Deque<String> deque1 = new LinkedList<>();
		Deque<String> deque2 = new ArrayDeque<>();
		Deque<String> deque3 = new ConcurrentLinkedDeque<>();
		Deque<String> deque4 = new LinkedBlockingDeque<>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
