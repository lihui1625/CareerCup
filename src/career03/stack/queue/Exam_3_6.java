package career03.stack.queue;

public class Exam_3_6 {

	public static void main(String[] args) {
		SortedStack myStack = new SortedStack();
		myStack.push(158);
		myStack.push(32);
		myStack.push(57);
		myStack.push(6); 
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		myStack.push(100); 
		myStack.push(3);
		myStack.push(4);
		System.out.println(myStack.pop());
	
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());

	}

}

class SortedStack{
	
	private MyStack stack1;
	private MyStack stack2;

	public SortedStack() {
		stack1 = new MyStack();
		stack2 = new MyStack();
	}
	
	public void push(Integer obj)
	{
		while(this.peek()!=null && this.peek().intValue()>obj.intValue())
		{
			this.stack2.push(this.stack1.pop());
		}
		this.stack1.push(obj);
		while(this.stack2.size()>0)
		{
			this.stack1.push(this.stack2.pop());
		}
	}
	
	public Integer pop()
	{
		return (Integer)stack1.pop();
		
	}
	
	public Integer peek()
	{
		return (Integer)stack1.peek();
		
	}
	
	public int size()
	{
		return stack1.size();
		
	}
	
}