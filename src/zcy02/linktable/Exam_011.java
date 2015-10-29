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
			else{
				p1.print();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
