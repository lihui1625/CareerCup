package career03.stack.queue;

public class MyQueue {

  private MyLinkNode head;
  private MyLinkNode tail;

  public MyQueue() {
    head = null;
    tail = null;
  }

  public void enqueue(Object obj) {
    MyLinkNode node = new MyLinkNode(obj);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
  }

  public Object dequeue() {
    if (head == null) {
      return null;
    }
    MyLinkNode node = head;
    head = node.next;
    node.next = null;
    return node.val;
  }

  public Object top() {
    if (head == null) {
      return null;
    }
    return head.val;
  }

  public void print() {
    head.print();
  }

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.enqueue(1);
    myQueue.enqueue(2);
    myQueue.enqueue(3);
    myQueue.enqueue(4);
    myQueue.enqueue(5);
    myQueue.enqueue(6);
    myQueue.print();
    myQueue.dequeue();
    myQueue.enqueue(100);
    myQueue.print();

  }

}
