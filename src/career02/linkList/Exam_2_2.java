package career02.linkList;

public class Exam_2_2 {

  public static LinkNode getLastN(LinkNode head, int n) {
    if (head == null) {
      return null;
    }
    LinkNode node1 = head;
    LinkNode node2 = head;
    while (n > 1) {
      node1 = node1.next;
      if (node1 == null) {
        return null;
      }
      n--;
    }
    while (node1.next != null) {
      node1 = node1.next;
      node2 = node2.next;
    }
    return node2;
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
    linkList.insertOnFirdst(2);
    linkList.insertOnFirdst(13);
    linkList.insertOnFirdst(3);
    linkList.insertOnFirdst(11);
    linkList.print();
    LinkNode node = getLastN(linkList.head, 5);
    System.out.println("  val:  " + node.val);

  }

}
