package career14.java;

public class CircularArray<T> {
	private int maxSize;
	private Object[] array;
	private int point;

	public CircularArray(int maxSize) {
		this.maxSize = maxSize;
		array = new Object[maxSize];
		point = 0;
	}

	public void add(T t) {
		if (point == maxSize - 1) {
			int oldSize = this.maxSize;
			Object[] oldArray = array;
			this.maxSize = 2 * this.maxSize;
			array = new Object[maxSize];
			System.arraycopy(oldArray, 0, array, 0, oldSize);
 		}
		array[point++] = t;
	}
	
	public void spin(int step)
	{
		step = step % (1+point) ;
		if(step==0)
		{
			return;
		}
		if(step>0)
		{
			//右移
		}
		else
		{
			//左移
		}
		
	}
	
	public void print()
	{ 
		System.out.print(" [ ");
		for(int i=0; i<= point ;i++)
		{
			System.out.print(array[i]+ " \t ");
		}		
		System.out.println(" ] ");
	}

	public static void main(String[] args)
	{
		CircularArray<String> c = new CircularArray<String>(100);
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		c.add("e");
		c.add("f");
		c.add("g");
		c.add("h");
		
		c.spin(4);
		
	}
}
