package career02.linkList;

class LinkNode {
  public int val;
  public LinkNode next;

  public LinkNode(int val) {
    this.val = val;
    this.next = null;
  }

  public void print() {
    LinkNode p = this;
    System.out.print("[ ");
    while (p != null) {
      System.out.print(p.val + " --> ");
      p = p.next;
    }
    System.out.println(" ] ");
  }
}

public class LinkList {

  public LinkNode head;
  public LinkNode tail;

  public LinkList() {
    head = null;
    tail = null;
  }

  public boolean insertOnFirdst(int val) {
    LinkNode node = new LinkNode(val);
    node.next = head;
    head = node;
    if (tail == null) {
      tail = node;
    }
    return true;
  }

  public boolean remove(int val) {
    if (head == null)
      return false;
    if (head.val == val) {
      if (head == tail) {
        tail = null;
      }
      LinkNode node = head.next;
      head.next = null;
      head = node;
      return true;
    }
    LinkNode previous = head;
    LinkNode p = head.next;
    while (p != null) {
      if (p.val == val) {
        if (p == tail) {
          tail = previous;
        }
        LinkNode q = p.next;
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
    LinkNode p = head;
    System.out.print("[ ");
    while (p != null) {
      System.out.print(p.val + " --> ");
      p = p.next;
    }
    System.out.println(" ] ");
  }

  public static void main(String[] args) {
    LinkList linkList = new LinkList();
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
