package zcy01.stack.queue;

public class MyLinkNode {
	public Object val;
	public MyLinkNode next;

	public MyLinkNode(Object val) {
		this.val = val;
		this.next = null;
	}
	
	public void print()
	{
		MyLinkNode p = this;
		System.out.print("[ ");
		while(p!=null)
		{
			System.out.print(p.val+" --> ");
			p = p.next;
		}
		System.out.println(" ] ");
	}
}