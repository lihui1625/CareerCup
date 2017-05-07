package zcy02.linktable;

public class Exam_030 {

  public static void main(String[] args) {
    MyLinkList linkList = new MyLinkList();
    linkList.insertOnLast(1);
    linkList.insertOnLast(2);
    linkList.insertOnLast(3);
    linkList.insertOnLast(4);
    linkList.insertOnLast(5);
    // linkList.insertOnLast(6);
    linkList.print();
    MyLinkNode sum = partition(linkList.head);
    sum.print();

    MyLinkList linkList2 = new MyLinkList();
    linkList2.insertOnLast(1);
    linkList2.insertOnLast(2);
    linkList2.insertOnLast(3);
    linkList2.insertOnLast(4);
    linkList2.insertOnLast(5);
    linkList2.insertOnLast(6);
    linkList2.print();

    MyLinkNode sum2 = partition(linkList2.head);
    sum2.print();
  }

  private static MyLinkNode partition(MyLinkNode head) {

    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    MyLinkNode leftHead = null;
    MyLinkNode leftTail = null;

    MyLinkNode p1 = head;
    int count = 0;
    while (p1 != null) {
      p1 = p1.next;
      count++;
    }

    p1 = head;
    MyLinkNode p2 = head;
    int index = 1;
    while (index <= count / 2) {
      p2 = p2.next;
      index++;
    }
    index = 1;
    while (index <= count / 2) {
      if (leftHead == null) {
        leftHead = p1;
      } else {
        leftTail.next = p1;
      }
      leftTail = p1;
      p1 = p1.next;
      leftTail.next = null;

      leftTail.next = p2;
      leftTail = p2;
      p2 = p2.next;
      leftTail.next = null;
      index++;
    }
    if (count % 2 != 0) {
      leftTail.next = p2;
      leftTail = p2;
      leftTail.next = null;
    }
    return leftHead;
  }

}
