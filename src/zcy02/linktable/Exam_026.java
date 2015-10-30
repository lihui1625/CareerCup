package zcy02.linktable;

import java.util.Random;

public class Exam_026 {

	public static void main(String[] args) {
		Random r = new Random();
		MyLinkList linkList = new MyLinkList();
		for (int i = 1; i <= 10; i++) {
			linkList.insertOnLast(r.nextInt(20));
		}
		linkList.print();
		linkList.head = order(linkList.head);
		linkList.print();
	}

	private static MyLinkNode order(MyLinkNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		MyLinkNode newTail = null;
		MyLinkNode newHead = null;

		while (head != null) {
			MyLinkNode p1Pre = null;
			MyLinkNode p1 = head;
			MyLinkNode minPre = p1Pre;
			MyLinkNode min = p1;
			while (p1 != null) {
				if (p1.val > min.val) {
					minPre = p1Pre;
					min = p1;
				}
				p1Pre = p1;
				p1 = p1.next;
			}
			if (min == head) {
				head = head.next;  
			} 
			else {
				minPre.next = min.next; 
			}
			
			min.next = null;
			if(newHead==null){
				newHead =newTail= min;
			}
			else{
				newTail.next = min;
				newTail = min;
			}
		} 
		return newHead;
	}

}
