package zcy02.linktable;

public class MyLinkNode {
	public Integer val;
	public MyLinkNode next;
	public MyLinkNode previous;

	public MyLinkNode(Integer val) {
		this.val = val;
		this.next = null;
		this.previous = null;
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

	@Override
	public String toString() {
		return "MyLinkNode [val=" + val + "]";
	}
	
	
}