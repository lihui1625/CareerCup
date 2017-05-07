package zcy02.linktable;

import java.util.Stack;

public class Exam_020 {

  public static MyLinkNode add(MyLinkNode head1, MyLinkNode head2) {
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    MyLinkNode newHead = null;

    int jw = 0;
    head1 = reverseSingle(head1);
    // head1.print();
    head2 = reverseSingle(head2);
    // head2.print();
    while (head1 != null || head2 != null || jw != 0) {
      int v = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val)
          + jw;
      jw = v / 10;
      v = v % 10;
      MyLinkNode newNode = new MyLinkNode(v);
      if (newHead == null) {
        newHead = newNode;
      } else {
        newNode.next = newHead;
        newHead = newNode;
      }
      head1 = (head1 == null ? null : head1.next);
      head2 = (head2 == null ? null : head2.next);
    }

    return newHead;
  }

  public static MyLinkNode add2(MyLinkNode head1, MyLinkNode head2) {
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    MyLinkNode newHead = null;

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    while (head1 != null) {
      stack1.push(head1.val);
      head1 = head1.next;
    }
    while (head2 != null) {
      stack2.push(head2.val);
      head2 = head2.next;
    }

    int jw = 0;

    while (!stack1.isEmpty() || !stack2.isEmpty() || jw != 0) {
      int v = (stack1.isEmpty() ? 0 : stack1.pop())
          + (stack2.isEmpty() ? 0 : stack2.pop()) + jw;
      jw = v / 10;
      v = v % 10;
      MyLinkNode newNode = new MyLinkNode(v);
      if (newHead == null) {
        newHead = newNode;
      } else {
        newNode.next = newHead;
        newHead = newNode;
      }
    }
    return newHead;
  }

  private static MyLinkNode reverseSingle(MyLinkNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    MyLinkNode pre = head;
    head = head.next;
    MyLinkNode next = head.next;
    pre.next = null;
    while (true) {
      head.next = pre;
      if (next == null) {
        break;
      }
      pre = head;
      head = next;
      next = next.next;
    }
    return head;

  }

  public static void main(String[] args) {
    MyLinkList linkList = new MyLinkList();
    linkList.insertOnLast(6);
    linkList.insertOnLast(4);
    linkList.print();

    MyLinkList linkList2 = new MyLinkList();
    linkList2.insertOnLast(9);
    linkList2.insertOnLast(9);
    linkList2.insertOnLast(9);
    linkList2.insertOnLast(8);
    linkList2.print();
    // MyLinkNode sum = add(linkList.head, linkList2.head);
    // sum.print();
    MyLinkNode sum2 = add2(linkList.head, linkList2.head);
    sum2.print();
  }

}
