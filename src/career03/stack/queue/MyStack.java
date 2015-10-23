package career03.stack.queue;

 

public class MyStack {
	
	private MyLinkNode head ; 
	private int size;
	
	public MyStack()
	{
		head = null; 
		size =0;
	}
	
	public void push(Object obj)
	{
		MyLinkNode node = new MyLinkNode(obj); 
		if(head==null)
		{
			head = node;
		}
		else
		{
			node.next = head;
			head = node;
		}	 
		size++;
	}
	
	public Object pop()
	{
		if(head==null){
			return null;
		}
		MyLinkNode node = head;
		head = node.next;
		node.next = null; 
		size--;
		return node.val;
	}
	
	public Object peek() {
		if(head==null){
			return null;
		} 
		return head.val;
	}
	
	public int size(){
		return size;
	}
	
	public void print()
	{
		head.print();
	}

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		myStack.print();
		myStack.pop();
		myStack.push(100);
		myStack.print();

	}

	

}
