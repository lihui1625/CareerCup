package leetcode17.bit;

public class Exam_134 {

	public static int devide(int a, int b){
		if(b==0){
			throw new RuntimeException("b==0");
		}
		int x = Math.abs(a);
		int y = Math.abs(b);
		
		int c = 0;
		while(x>y){
			x -= y;
			c++;
		} 
		c= (!((a>0)^(b>0)))?c:-c;
		return c;
		
	} 
	
	public static void main(String[] args) {
		System.out.println(devide(100,7));
		System.out.println(devide(-100,7));
		System.out.println(devide(100,-7));
		System.out.println(devide(-100,-7));

	}

}
