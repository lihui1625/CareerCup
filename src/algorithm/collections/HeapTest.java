package algorithm.collections;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class HeapTest {

  public static void priorityQueueTest() {
    Queue<String> queue = new PriorityQueue<String>(100);

  }

  public static void priorityBlockingQueueTest() {
    Queue<String> queue1 = new PriorityBlockingQueue<String>(100);
    BlockingQueue<String> queue2 = new PriorityBlockingQueue<String>(100);

  }

}
