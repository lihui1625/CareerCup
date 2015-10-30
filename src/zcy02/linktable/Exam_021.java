package zcy02.linktable;

public class Exam_021 {

	public static boolean isCycle(MyLinkNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		MyLinkNode p1 = head;
		MyLinkNode p2 = head;
		while (p1 != null && p1.next != null) {
			p1 = p1.next.next;
			p2 = p2.next;
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}

	public static MyLinkNode firstCommonNode(MyLinkNode head1, MyLinkNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		MyLinkNode p1 = head1;
		MyLinkNode p2 = head2;
		int len1 = 1;
		int len2 = 1;
		while (p1.next != null) {
			p1 = p1.next;
			len1++;
		}
		while (p2.next != null) {
			p2 = p2.next;
			len2++;
		}
		if (p1 != p2) {
			return null;
		}
		p1 = head1;
		p2 = head2;
		while (len1 > len2) {

			p1 = p1.next;
			len1--;
		}
		while (len1 > len2) {
			p2 = p2.next;
			len2--;

		}

		while (p1 != null) {
			if (p1 == p2) {
				return p1;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
