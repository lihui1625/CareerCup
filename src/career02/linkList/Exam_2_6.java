package career02.linkList;

//两个指针。

public class Exam_2_6 {

	public static boolean hasCycle(LinkNode head) {
		if (head == null)
			return false;
		LinkNode p1 = head;
		LinkNode p2 = head;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				return true;
			} 
		}
		return false;
	}

	public static LinkNode returnCycle(LinkNode head) {
		if (head == null)
			return null;
		LinkNode p1 = head;
		LinkNode p2 = head;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				p1 = head;
				while (true) {
					if (p1 == p2) {
						return p1;
					}
					p1 = p1.next;
					p2 = p2.next.next;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {

		LinkList linkList3 = new LinkList();
		linkList3.insertOnFirdst(1);
		linkList3.insertOnFirdst(2);
		linkList3.insertOnFirdst(3);
		linkList3.insertOnFirdst(4);
		linkList3.insertOnFirdst(5);
		linkList3.insertOnFirdst(5);
		//boolean b3 = hasCycle(linkList3.head);
		//System.out.println(b3);
		System.out.println(returnCycle(linkList3.head));

		LinkList linkList4 = new LinkList();
		linkList4.insertOnFirdst(1);
		linkList4.insertOnFirdst(2);
		linkList4.insertOnFirdst(3);
		linkList4.insertOnFirdst(4);
		linkList4.insertOnFirdst(5);
		linkList4.insertOnFirdst(5);
		linkList4.tail.next = linkList4.head;
		//boolean b4 = hasCycle(linkList4.head);
		//System.out.println(b4);
		System.out.println(returnCycle(linkList4.head).val);

	}

}
