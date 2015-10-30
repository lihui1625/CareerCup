package zcy02.linktable;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exam_022 {

	public static void main(String[] args) {
		MyLinkList linkList = new MyLinkList();
		for (int i = 1; i <= 23; i++) {
			linkList.insertOnLast(i);
		}
		linkList.print();
		linkList.head = reverseEvery(linkList.head, 3);
		linkList.print();

	}

	public static MyLinkNode reverseEvery(MyLinkNode head, int k) {
		if (head == null || head.next == null || k <= 1) {
			return head;
		}

		Stack<MyLinkNode> stack = new Stack<MyLinkNode>();
		Queue<MyLinkNode> queue = new LinkedList<MyLinkNode>();
		MyLinkNode p = head;
		while (p != null) {
			int num = k;
			stack.clear();
			MyLinkNode lastP = p;
			while (num > 0) {
				stack.push(p);
				num--;
				p = p.next;
				if (p == null) {
					break;
				}
			}
			if (num > 0) {
				p = lastP;
				while (p != null) {
					queue.add(p);
					p = p.next;
				}
				break;
			} else {
				while (!stack.isEmpty()) {
					queue.add(stack.pop());
				}
			}
		}
		head = queue.poll();
		MyLinkNode p2 = head;
		while (!queue.isEmpty()) {
			MyLinkNode newNode = queue.poll();
			p2.next = newNode;
			p2 = p2.next;
		}
		p2.next = null;
		return head;
	}

}
