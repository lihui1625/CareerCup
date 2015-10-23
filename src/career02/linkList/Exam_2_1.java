package career02.linkList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Exam_2_1 {

	public static LinkNode removeRedumplated(LinkNode head) { 
		if (head == null) {
			return head;
		}
		Set<Integer> set = new HashSet<>();		
		LinkNode node = head;
		LinkNode previousNode = null;
		while (node != null) {
			if ( set.contains(node.val)) {
				previousNode.next = node.next;
				node.next = null;
				node = previousNode.next;
			} else {
				set.add(node.val);
				previousNode = node;
				node = node.next;
			} 
		}
		return head;
	}

	public static LinkNode removeRedumplated2(LinkNode head) { 
		
		if (head == null) {
			return head;
		}
		LinkNode node1 = head;
		LinkNode node2 = node1.next;
		LinkNode previousNode = node1;
		while (node1.next != null) {
			while (node2 != null) {
				if (node2.val == node1.val) {
					previousNode.next = node2.next;
					node2.next = null;
					node2 = previousNode.next;
				} else {
					previousNode = node2;
					node2 = node2.next;
				}
			}
			node1 = node1.next;
			previousNode = node1;
			node2 = node1.next;
		}
		return head;
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
		linkList.insertOnFirdst(11);
		linkList.print();
		removeRedumplated(linkList.head);
		//removeRedumplated2(linkList.head);
		linkList.print();
 
		
	}

}
