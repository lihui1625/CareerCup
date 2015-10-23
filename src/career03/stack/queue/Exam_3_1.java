package career03.stack.queue;

public class Exam_3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class StackGroup
{
	private int MAX_SIZE = 100; 
	private Object[] array = new Object[MAX_SIZE];
	
	private int HEAP_1_START = 0;
	private int HEAP_1_END = MAX_SIZE/3;
	private int HEAP_2_START = HEAP_1_END + 1;
	private int HEAP_2_END = 2*MAX_SIZE/3;
	private int HEAP_3_START = HEAP_2_END + 1;
	private int HEAP_3_END = MAX_SIZE-1;
	
	private int point_1 = HEAP_1_END;
	private int point_2 = HEAP_2_END;
	private int point_3 = HEAP_3_END;
	
	public boolean push_to_1(Object obj){
		if(point_1==HEAP_1_START)
		{
			return false;
		}
		array[point_1] = obj;
		point_1 -- ;
		return true;		
	}
	
	public boolean push_to_2(Object obj){
		if(point_2==HEAP_2_START)
		{
			return false;
		}
		array[point_2] = obj;
		point_2 -- ;
		return true;		
	}
	
	public boolean push_to_3(Object obj){
		if(point_3==HEAP_3_START)
		{
			return false;
		}
		array[point_3] = obj;
		point_3 -- ;
		return true;		
	}
	
	public Object pop_1(){
		if(point_1==HEAP_1_END)
		{
			return null;
		}
		Object obj = array[point_1-1] ;
		array[point_1-1] = null;
		point_1 ++ ;
		return obj;		
	}
	
	public Object pop_2(){
		if(point_2==HEAP_2_END)
		{
			return null;
		}
		Object obj = array[point_2-1] ;
		array[point_2-1] = null;
		point_2 ++ ;
		return obj;		
	}
	
	public Object pop_3(){
		if(point_3==HEAP_3_END)
		{
			return null;
		}
		Object obj = array[point_3-1] ;
		array[point_3-1] = null;
		point_3 ++ ;
		return obj;		
	}
}