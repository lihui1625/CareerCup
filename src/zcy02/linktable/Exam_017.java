package zcy02.linktable;

import java.util.Stack;

public class Exam_017 {

  public static boolean isHW1(MyLinkNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    int count = 0;
    MyLinkNode cur = head;
    while (cur != null) {
      cur = cur.next;
      count++;
    }
    Stack<Integer> stack = new Stack<>();
    cur = head;
    for (int i = 1; i <= count / 2; i++) {
      stack.push(cur.val);
      cur = cur.next;
    }
    if (count % 2 != 0) {
      cur = cur.next;
    }
    while (!stack.isEmpty()) {
      if (stack.pop().intValue() != cur.val.intValue()) {
        return false;
      }
      cur = cur.next;
    }
    return true;
  }

  public static boolean isHW2(MyLinkNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    int count = 0;
    MyLinkNode cur = head;
    while (cur != null) {
      cur = cur.next;
      count++;
    }
    head = reverseSingle(head, 1, count / 2);
    cur = head;
    for (int i = 1; i <= (count + 1) / 2; i++) {
      cur = cur.next;
    }
    MyLinkNode pre = head;
    while (cur != null) {
      if (pre.val.intValue() != cur.val.intValue()) {
        return false;
      }
      pre = pre.next;
      cur = cur.next;
    }

    return true;
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

  public static void main(String[] args) {
    MyLinkList linkList = new MyLinkList();
    linkList.insertOnFirst(1);
    linkList.insertOnFirst(4);
    linkList.insertOnFirst(2);
    linkList.insertOnFirst(4);
    linkList.insertOnFirst(1);
    linkList.print();
    System.out.println(isHW1(linkList.head));
    System.out.println(isHW2(linkList.head));
  }

}
