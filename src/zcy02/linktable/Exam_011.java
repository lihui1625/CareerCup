package zcy02.linktable;

public class Exam_011 {

	public static void printCommon(MyLinkNode head1, MyLinkNode head2){
		MyLinkNode p1 = head1;
		MyLinkNode p2 = head2;
		
		while(p1!=null && p2!=null){
			if(p1.val < p2.val){
				p1 = p1.next;
			}
			else if(p1.val > p2.val){
				p2 = p2.next;
			}
			else { 
				System.out.print(  p1.val + "-->"); 
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		MyLinkList linkList = new MyLinkList();
		linkList.insertOnLast(1);
		linkList.insertOnLast(2);
		linkList.insertOnLast(3);
		linkList.insertOnLast(4); 
		linkList.insertOnLast(6); 
		linkList.print();
		
		MyLinkList linkList2 = new MyLinkList();  
		linkList2.insertOnLast(4);
		linkList2.insertOnLast(5);
		linkList2.insertOnLast(6);
		linkList2.insertOnLast(7);
		linkList2.insertOnLast(8);
		linkList2.insertOnLast(9);
		linkList2.print();
		
		linkList2.tail = linkList.tail;
		
		printCommon(linkList.head, linkList2.head);

	}

}
