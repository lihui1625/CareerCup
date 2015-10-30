package leetcode10.doublepointer;

import java.util.Arrays;
import java.util.Random;

public class Exam_62 {
	
	public static int getMax(int[] a){
		if(a==null || a.length<2){
			return -1;
		}
		
		int min = a[0];
		int minIndex = 0; 
		 
		int maxIndex = 0;
		
		int profit = 0;
		for(int i=1; i< a.length;i++){ 
			if(a[i]<min){
				min = a[i]; 
				minIndex = i;
			}  
			if(profit < a[i] - min){ 
				  maxIndex = i;
				  profit = a[i] - min;
			}
		}
		System.out.println("a["+maxIndex+"] ("+ a[maxIndex] + ") - a[" + minIndex+"] ("+ a[minIndex] + ") = " +profit );
		return profit;
		
	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 20;
		int[] im = new int[N];
		for (int i = 0; i < N; i++) {
			im[i] = r.nextInt(80);
		}
		System.out.println(Arrays.toString(im));
		System.out.println(getMax(  im));

	}

}
