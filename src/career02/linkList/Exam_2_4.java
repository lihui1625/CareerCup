package career02.linkList;

public class Exam_2_4 {

	public static LinkNode partion(LinkNode head, int x) {
		LinkNode left = head;
		LinkNode right = head.next;
		if (right == null) {
			return head;
		}

		while (left != null && right != null) {
			if (left.val >= x) {

				right = left.next;

				while (right != null && right.val >= x) {
					right = right.next;
				}
				if (right != null) {
					swapValue(left, right);
				} else {
					break;
				}
			}
			left = left.next;
		}

		return head;
	}

	static private void swapValue(LinkNode a, LinkNode b) {
		int c = a.val;
		a.val = b.val;
		b.val = c;
	}

	public static LinkNode partion2(LinkNode head, int x) {
		LinkNode smallhead = null;
		LinkNode bighead = null;
		LinkNode smalltail = null;
		LinkNode node = head;

		while (node != null) {
			LinkNode next = node.next;
			if (node.val < x) {
				node.next = smallhead;
				smallhead = node;
				if (smalltail == null) {
					smalltail = smallhead;
				}
			} else {
				node.next = bighead;
				bighead = node;
			}
			node = next;
		}
		if (smallhead == null) {
			return bighead;
		}
		smalltail.next = bighead;
		return smallhead;
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
		// LinkNode head1 = partion2(linkList.head, 11);
		// head1.print();
		//LinkNode head2 = partion2(linkList.head, 13);
		//head2.print();
		//LinkNode head3 = partion2(linkList.head, 4);
		//head3.print();
		LinkNode head4 = partion2(linkList.head, 3);
		head4.print();
	}

}
