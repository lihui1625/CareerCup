package zcy02.linktable;

public class Exam_015 {

  public static void main(String[] args) {
    MyLinkList linkList = new MyLinkList();
    linkList.insertOnFirst(1);
    linkList.insertOnFirst(2);
    linkList.insertOnFirst(3);
    linkList.insertOnFirst(4);
    linkList.insertOnFirst(5);
    linkList.insertOnFirst(6);
    linkList.insertOnFirst(7);
    linkList.insertOnFirst(8);
    linkList.print();
    linkList.head = reverseSingle(linkList.head, 2, 6);
    linkList.print();

  }

  private static MyLinkNode reverseSingle(MyLinkNode head, int from, int to) {

    if (from <= 0 || to <= 0 || from >= to) {
      return head;
    }
    boolean isFromHead = (from == 1);
    MyLinkNode pFrom = head;
    MyLinkNode pTo = head;
    MyLinkNode preFrom = pFrom;
    while (to > 1 || from > 1) {
      if (to > 1) {
        pTo = pTo.next;
        if (pTo == null) {
          return head;
        }
        to--;
      }
      if (from > 1) {
        preFrom = pFrom;
        pFrom = pFrom.next;
        from--;
      }
    }
    MyLinkNode nextFrom = pFrom.next;
    if (isFromHead) {
      head = pTo;
    } else {
      preFrom.next = pTo;
    }
    pFrom.next = pTo.next;
    pTo.next = null;

    while (true) {
      MyLinkNode newNext = nextFrom.next;
      nextFrom.next = pFrom;
      pFrom = nextFrom;
      nextFrom = newNext;
      if (nextFrom == null) {
        break;
      }
    }
    return head;
  }

}
