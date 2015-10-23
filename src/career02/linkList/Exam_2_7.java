package career02.linkList;

import java.util.Stack;

// 遍历一遍，分别放入一份栈和队列，然后比较。

public class Exam_2_7 {
	
	public static boolean isHuiwen(LinkNode head)
	{
		if(head==null)
		{
			return false;
			
		}
		if(head.next==null)
		{
			return true;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		LinkNode p1 = head;
		LinkNode p2 = head;
		while(p2!=null && p2.next!=null)
		{
			stack.push(p1.val);
			p1 = p1.next;
			p2 = p2.next.next;
 		}  
		if(p2!=null) //偶数
		{
			p1 = p1.next;
		}
		while(!stack.isEmpty())
		{
			Integer i = stack.pop();
			if(i.intValue() != p1.val)
			{
				return false;
			}
			p1 = p1.next;
		}
		return true;
		
	}

	public static void main(String[] args) {

		LinkList linkList3 = new LinkList();
		linkList3.insertOnFirdst(1);
		linkList3.insertOnFirdst(2);
		linkList3.insertOnFirdst(3);
		//linkList3.insertOnFirdst(4);
		linkList3.insertOnFirdst(3);
		linkList3.insertOnFirdst(2);
		linkList3.insertOnFirdst(1); 
		System.out.println(isHuiwen(linkList3.head));
	}
}
