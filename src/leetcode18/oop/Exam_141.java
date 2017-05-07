package leetcode18.oop;

import java.util.LinkedList;
import java.util.Queue;

public class Exam_141 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class MyBlockingQueue<T> {
  private Queue<T> queue;
  private int maxSize;

  public MyBlockingQueue(int maxSize) {
    this.queue = new LinkedList<>();
    this.maxSize = maxSize;
  }

  public void add(T t) {
    this.notifyAll();
    while (this.queue.size() == this.maxSize) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    this.queue.add(t);
  }

  public T poll() {
    this.notifyAll();
    while (this.queue.size() == 0) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return this.queue.poll();
  }

  public T peek() {
    this.notifyAll();
    while (this.queue.size() == 0) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return this.queue.peek();
  }

}