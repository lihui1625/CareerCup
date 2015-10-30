package zcy02.linktable;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Exam_023 {

	public static void main(String[] args) {
		Random r = new Random();
		MyLinkList linkList = new MyLinkList();
		for (int i = 1; i <= 23; i++) {
			linkList.insertOnLast(r.nextInt(10));
		}
		linkList.print();
		linkList.head = removeDuplicated(linkList.head);
		linkList.print();
	}

	private static MyLinkNode removeDuplicated(MyLinkNode head) {
		Set<Integer> set = new HashSet<>();
		MyLinkNode p = head;
		MyLinkNode pre = p;
		while (p != null) {
			if (set.contains(p.val)) {
				pre.next = p.next;
			} else {
				set.add(p.val);
				pre = p;
			}
			p = p.next;
		}

		return head;
	}

}
