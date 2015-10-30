package zcy02.linktable;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Exam_024 {

	public static void main(String[] args) {
		Random r = new Random();
		MyLinkList linkList = new MyLinkList();
		for (int i = 1; i <= 23; i++) {
			linkList.insertOnLast(r.nextInt(3));
		}
		linkList.print();
		linkList.head = removeV(linkList.head, 2);
		linkList.print();
	}

	private static MyLinkNode removeV(MyLinkNode head, int v) {
		if (head == null) {
			return null;
		}
		MyLinkNode p = head;
		MyLinkNode pre = p;
		while (p != null) {
			if (p.val.intValue() == v) {
				if (p == head) {
					head = p.next;
					pre = head;
				} else {
					pre.next = p.next; 
				}

			} else {
				pre = p; 
			}
			p = p.next;
		}

		return head;
	}

}
