package zcy02.linktable;

public class Exam_028 {

	public static MyLinkNode insertCycleLT(MyLinkNode head, int num) {
		MyLinkNode node = new MyLinkNode(num);
		if (head == null) {
			head = node;
			node.next = head;
		} else if (head.val >= num) {
			MyLinkNode tail = head;
			while (tail.next != head) {
				tail = tail.next;
			} 
			node.next = head;
			head = node; 
			tail.next = head;
		} else {
			MyLinkNode pre = head;
			MyLinkNode p = head.next;
			while (p.val < num && p != head) {
				pre = p;
				p = p.next;
			} 
			pre.next = node ;
			node.next = p; 
		}
		return head;

	}

	public static void print(MyLinkNode head) {
		System.out.print(head.val + "->"); 
		MyLinkNode p = head.next; 
		while (p != head ) {
			System.out.print(p.val + "->"); 
			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyLinkNode head = null;
		head = insertCycleLT(  head, 6);
		print(  head);
		head = insertCycleLT(  head, 1);
		print(  head);
		head = insertCycleLT(  head, 8);
		print(  head);
		head = insertCycleLT(  head, 2);
		print(  head);
		head = insertCycleLT(  head, 9);
		print(  head);
		head = insertCycleLT(  head, 4);
		print(  head);
		head = insertCycleLT(  head, 7);
		print(  head);
		head = insertCycleLT(  head, 5);
		print(  head);
		head = insertCycleLT(  head, 6);
		print(  head);
		head = insertCycleLT(  head, 1);
		print(  head);
		head = insertCycleLT(  head, 8);
		print(  head);
		head = insertCycleLT(  head, 2);
		print(  head);
		head = insertCycleLT(  head, 9);
		print(  head);
		head = insertCycleLT(  head, 4);
		print(  head);
		head = insertCycleLT(  head, 7);
		print(  head);
		head = insertCycleLT(  head, 5);
		print(  head);

	}

}
