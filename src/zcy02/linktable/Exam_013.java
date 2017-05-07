package zcy02.linktable;

public class Exam_013 {

  public static void main(String[] args) {
    MyLinkList linkList = new MyLinkList();
    linkList.insertOnFirst(1);
    linkList.insertOnFirst(4);
    linkList.insertOnFirst(2);
    linkList.insertOnFirst(13);
    linkList.insertOnFirst(3);
    linkList.insertOnFirst(11);
    linkList.insertOnFirst(41);
    linkList.insertOnFirst(15);
    linkList.insertOnFirst(111);
    linkList.insertOnFirst(141);
    linkList.insertOnFirst(115);
    linkList.print();
    removeMiddle(linkList.head);
    linkList.print();
    removeMiddle(linkList.head);
    linkList.print();
    removeMiddle(linkList.head);
    linkList.print();

  }

  private static void removeMiddle(MyLinkNode head) {
    if (head == null) {
      return;
    }
    if (head.next == null) {
      head = null;
      return;
    }
    MyLinkNode p1 = head;
    MyLinkNode p2 = head.next.next;
    while (p2 != null && p2.next != null) {
      p2 = p2.next.next;
      p1 = p1.next;
    }
    p1.next = p1.next.next;
  }

}
