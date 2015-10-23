package career02.linkList;

//两个指针遍历链表

public class Exam_2_5 {

	public static LinkNode add(LinkNode l1, LinkNode l2) {
		LinkNode head = null;
		int carry = 0;
		int result = 0;
		LinkNode lastNode = null;
		while (l1 != null || l2 != null || carry != 0) {
			int v1 = (l1 == null ? 0 : l1.val);
			int v2 = (l2 == null ? 0 : l2.val);

			result = v1 + v2 + carry;
			carry = result / 10;
			result = result % 10;

			LinkNode linkNode = new LinkNode(result);
			if (head == null) {
				head = linkNode;
				lastNode = linkNode;
			} else {
				lastNode.next = linkNode;
				lastNode = linkNode;
			}
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		return head;
	}

	public static LinkNode reverseLinkTable(LinkNode head) {
		LinkNode p1 = head;
		if (p1 == null) {
			return null;
		}
		LinkNode p2 = p1.next;
		if (p2 == null) {
			return p1;
		}
		LinkNode old = null;
		while (true) {
			old = p1;
			p1 = p2;
			p2 = p2.next;			
			p1.next = old;
			if(old==head)
			{
				old.next = null;
			} 
			if(p2==null)
			{
				return p1;
			}
		}
	}

	public static void main(String[] args) {

		LinkList linkList1 = new LinkList();
		linkList1.insertOnFirdst(9);
		linkList1.insertOnFirdst(9);
		linkList1.insertOnFirdst(8);
		linkList1.insertOnFirdst(9);

		LinkList linkList2 = new LinkList();
		linkList2.insertOnFirdst(8);
		linkList2.insertOnFirdst(6);
		linkList2.insertOnFirdst(4);

		LinkNode node = add(linkList1.head, linkList2.head);
		node.print();
		
		LinkList linkList3 = new LinkList();
		linkList3.insertOnFirdst(1);
		linkList3.insertOnFirdst(2);
		linkList3.insertOnFirdst(3);
		linkList3.insertOnFirdst(4);
		linkList3.insertOnFirdst(5);
		linkList3.head.print();
		LinkNode reverseHead = reverseLinkTable(linkList3.head);		
		reverseHead.print();		

	}

}
