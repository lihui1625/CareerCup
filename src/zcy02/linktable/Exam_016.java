package zcy02.linktable;

public class Exam_016 {

  private static int getLive(int totalNo, int toKill) {
    if (totalNo <= 0) {
      throw new java.lang.IllegalArgumentException(" n should greater than 0!");
    }
    if (totalNo == 1) {
      return 1;
    }
    return (getLive(totalNo - 1, toKill) + toKill - 1) % totalNo + 1;

  }

  public static MyLinkNode getLive(MyLinkNode head, int toKill) {
    if (head == null || head.next == null || head.next == head || toKill < 1) {
      return head;
    }

    MyLinkNode cur = head.next;
    int totalNo = 1;
    while (cur != head) {
      cur = cur.next;
      totalNo++;
    }
    System.out.println(totalNo);
    int liveNo = getLive(totalNo, toKill);
    System.out.println(liveNo);
    cur = head;
    while (liveNo > 1) {
      cur = cur.next;
      liveNo--;
    }
    return cur;
  }

  public static void main(String[] args) {

    MyLinkList linkList = new MyLinkList();
    int totalNo = 5;
    for (int i = 1; i <= totalNo; i++) {
      linkList.insertOnLast(i);
    }
    linkList.tail.next = linkList.head;

    MyLinkNode live = getLive(linkList.head, 3);

    System.out.println(live);

  }

}
