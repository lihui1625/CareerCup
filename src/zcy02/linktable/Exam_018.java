package zcy02.linktable;

import java.util.Random;

public class Exam_018 {

  public static MyLinkNode partion(MyLinkNode head, int v) {
    if (head == null || head.next == null) {
      return head;
    }
    MyLinkNode bigHead = null;
    MyLinkNode bigTail = null;
    MyLinkNode midHead = null;
    MyLinkNode midTail = null;
    MyLinkNode smallHead = null;
    MyLinkNode smallTail = null;

    MyLinkNode cur = head;
    while (cur != null) {
      if (cur.val < v) {
        if (smallHead == null) {
          smallHead = smallTail = cur;
        } else {
          smallTail.next = cur;
          smallTail = smallTail.next;
        }
      } else if (cur.val > v) {
        if (bigHead == null) {
          bigHead = bigTail = cur;
        } else {
          bigTail.next = cur;
          bigTail = bigTail.next;
        }
      } else {
        if (midHead == null) {
          midHead = midTail = cur;
        } else {
          midTail.next = cur;
          midTail = midTail.next;
        }
      }
      cur = cur.next;
    }
    head = (smallHead != null ? smallHead
        : (midHead != null ? midHead : bigHead));
    if (smallTail != null) {
      smallTail.next = midHead != null ? midHead : bigHead;
    }
    if (midTail != null) {
      midTail.next = bigHead;
    }
    if (bigTail != null) {
      bigTail.next = null;
    }

    return head;
  }

  public static void main(String[] args) {
    Random r = new Random();
    MyLinkList linkList = new MyLinkList();
    int totalNo = 40;
    for (int i = 1; i <= totalNo; i++) {
      linkList.insertOnLast(r.nextInt(10));
    }
    linkList.print();
    MyLinkNode head = partion(linkList.head, 5);
    head.print();

  }

}
