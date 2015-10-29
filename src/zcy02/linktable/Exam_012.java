package zcy02.linktable;

public class Exam_012 {

	public static void removeSingleLast(MyLinkNode head, int k) {

		if (head == null || k <= 0) {
			return;
		}
		MyLinkNode p1 = head;
		MyLinkNode p2 = head;
		while (k > 1) {
			p1 = p1.next;
			if (p1 == null) {
				return;
			}
			k--;
		}
		MyLinkNode p2_pre = p2;
		while (p1.next != null) {
			p1 = p1.next;
			p2_pre = p2;
			p2 = p2.next;
		}
		if (p2 == p2_pre) {	 
			head.val = p2.next==null? null:p2.next.val;
			head.next = p2.next==null? null:p2.next.next;
			p2 = null;
			return;
		} else {
			p2_pre.next = p2.next;
			p2 = null;
		}

	}

	public static void removeDoubleLast(MyLinkNode head, int k) {
		if (head == null || k <= 0) {
			return;
		}
		MyLinkNode p1 = head;
		MyLinkNode p2 = head;
		while (k > 1) {
			p1 = p1.next;
			if (p1 == null) {
				return;
			}
			k--;
		}
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		if (p2.previous == null) { 
			head.val = p2.next==null? null:p2.next.val;
			head.next = p2.next==null? null:p2.next.next;
			p2 = null;
			return;
		} else {
			p2.previous.next = p2.next;
			if (p2.next != null) {
				p2.next.previous = p2.previous;
			}
			p2 = null;
		}
	}

	public static void main(String[] args) {
		MyLinkList linkList = new MyLinkList();
		linkList.insertOnFirst(1);
		linkList.insertOnFirst(4);
		linkList.insertOnFirst(2);
		linkList.insertOnFirst(13);
		linkList.insertOnFirst(3);
		linkList.insertOnFirst(11);
		linkList.insertOnFirst(41);
		linkList.insertOnFirst(15);
		linkList.insertOnFirst(111);
		linkList.insertOnFirst(141);
		linkList.insertOnFirst(115);
		linkList.print();
		removeSingleLast(linkList.head, 11);
		linkList.print();
		removeDoubleLast(linkList.head, 10);
		linkList.print();
		removeSingleLast(linkList.head, 1);
		linkList.print();
		removeDoubleLast(linkList.head, 1);
		linkList.print();
		removeSingleLast(linkList.head, 7);
		linkList.print();
		removeDoubleLast(linkList.head, 6);
		linkList.print();

	}

}
