package zcy01.stack.queue;

public class MyLinkList {

  public MyLinkNode head;
  public MyLinkNode tail;

  public MyLinkList() {
    head = null;
    tail = null;
  }

  public boolean insertOnFirdst(int val) {
    MyLinkNode node = new MyLinkNode(val);
    node.next = head;
    head = node;
    if (tail == null) {
      tail = node;
    }
    return true;
  }

  public boolean remove(Object val) {
    if (head == null)
      return false;
    if (head.val.equals(val)) {
      if (head == tail) {
        tail = null;
      }
      MyLinkNode node = head.next;
      head.next = null;
      head = node;
      return true;
    }
    MyLinkNode previous = head;
    MyLinkNode p = head.next;
    while (p != null) {
      if (p.val == val) {
        if (p == tail) {
          tail = previous;
        }
        MyLinkNode q = p.next;
        previous.next = q.next;
        p.next = null;
        p = previous;

      } else {
        previous = p;
        p = p.next;
      }
    }

    return false;
  }

  public void print() {
    MyLinkNode p = head;
    System.out.print("[ ");
    while (p != null) {
      System.out.print(p.val + " --> ");
      p = p.next;
    }
    System.out.println(" ] ");
  }

  public static void main(String[] args) {
    MyLinkList linkList = new MyLinkList();
    linkList.insertOnFirdst(1);
    linkList.insertOnFirdst(4);
    linkList.insertOnFirdst(2);
    linkList.insertOnFirdst(13);
    linkList.insertOnFirdst(3);
    linkList.insertOnFirdst(11);
    linkList.insertOnFirdst(41);
    linkList.insertOnFirdst(15);
    linkList.print();
    linkList.remove(13);
    linkList.print();

  }

}
