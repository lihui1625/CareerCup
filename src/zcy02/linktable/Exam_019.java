package zcy02.linktable;

import java.util.HashMap;
import java.util.Map;

public class Exam_019 {

  public static LinkNodeWithRand copyLinkListWithRand(LinkNodeWithRand head) {

    Map<LinkNodeWithRand, LinkNodeWithRand> map = new HashMap<LinkNodeWithRand, LinkNodeWithRand>();
    LinkNodeWithRand oldNode = head;
    while (oldNode != null) {
      LinkNodeWithRand newNode = new LinkNodeWithRand(oldNode.val);
      map.put(oldNode, newNode);
      oldNode = (LinkNodeWithRand) oldNode.next;
    }

    oldNode = head;
    while (oldNode != null) {
      LinkNodeWithRand newNode = map.get(oldNode);
      newNode.next = map.get(oldNode.next);
      newNode.rand = map.get(oldNode.rand);
      oldNode = (LinkNodeWithRand) oldNode.next;
    }

    LinkNodeWithRand newHead = map.get(head);
    return newHead;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class LinkNodeWithRand extends MyLinkNode {

  LinkNodeWithRand rand;

  public LinkNodeWithRand(Integer val) {
    super(val);
    this.rand = null;
  }

}