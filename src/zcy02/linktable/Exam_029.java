package zcy02.linktable;

public class Exam_029 {

	public static void main(String[] args) {
		MyLinkList linkList = new MyLinkList();
		linkList.insertOnLast(1);
		linkList.insertOnLast(4);
		linkList.insertOnLast(8);
		linkList.insertOnLast(9);
		linkList.insertOnLast(10);
		linkList.insertOnLast(12);
		linkList.insertOnLast(15);
		linkList.print();

		MyLinkList linkList2 = new MyLinkList();
		linkList2.insertOnLast(2);
		linkList2.insertOnLast(3);
		linkList2.insertOnLast(7);

		linkList2.print();

		MyLinkNode sum2 = merge(linkList.head, linkList2.head);
		sum2.print();

	}

	private static MyLinkNode merge(MyLinkNode head1, MyLinkNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		MyLinkNode newHead = null;
		MyLinkNode newTail = null;

		MyLinkNode p1 = head1;
		MyLinkNode p2 = head2;

		while (p1 != null && p2 != null) {
			MyLinkNode p = null;
			if (p1.val < p2.val) {
				p = p1;
				p1 = p1.next;
			} else {
				p = p2;
				p2 = p2.next;
			}
			if (newHead == null) {
				newHead = newTail = p;
			} else {
				newTail.next = p;
				newTail = p;
			}
			newTail.next = null;
		}
		MyLinkNode p = (p1 == null ? p2 : p1);
		while (p != null) {
			newTail.next = p;
			newTail = p;
			p = p.next;
			newTail.next = null;
		}

		return newHead;
	}

}
