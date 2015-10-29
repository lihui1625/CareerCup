package zcy02.linktable;

public class Exam_014 {

	public static void main(String[] args) {
		MyLinkList linkList = new MyLinkList();
		linkList.insertOnFirst(1);
		linkList.insertOnFirst(2);
		linkList.insertOnFirst(3);
		// linkList.insertOnFirst(4);
		// linkList.insertOnFirst(5);
		// linkList.insertOnFirst(6);
		// linkList.insertOnFirst(7);
		// linkList.insertOnFirst(8);
		linkList.print();
		linkList.head = reverseSingle(linkList.head);
		linkList.print();

		MyLinkList linkList2 = new MyLinkList();
		linkList2.insertOnFirst(1);
		linkList2.insertOnFirst(2);
		linkList2.insertOnFirst(3);
		linkList2.print();
		linkList2.head = reverseDouble(linkList2.head);
		linkList2.print();

	}

	private static MyLinkNode reverseDouble(MyLinkNode head) {
		MyLinkNode cur = head;
		if (cur == null) {
			return null;
		}

		while (true) {
			MyLinkNode next = cur.next;
			cur.next = cur.previous;
			cur.previous = next;
			if (next == null) {
				break;
			}
			cur = next;
		}
		return cur;

	}

	private static MyLinkNode reverseSingle(MyLinkNode head) {
 		if (head == null || head.next==null) {
			return head;
		}
 		MyLinkNode pre = head;
 		head = head.next;  		
		MyLinkNode next = head.next; 
		pre.next = null;  
		while (true) {
			head.next = pre;
			if (next == null) {
				break;
			}			
			pre = head;
			head = next;
			next = next.next;	
		}
		return head;

	}

}
