package leetcode11.dynamicprogram;

import java.util.Random;

public class Longest_Increasing_Subquence {

	public static int[] lis(int[] array) {

		int totalCount = array.length;
		int maxLen = 1;
		int[] lenArray = new int[totalCount];
		for (int i = 0; i < totalCount; i++) {
			lenArray[i] = 1;
		}

		for (int i = 0; i < totalCount; i++) {
			for (int j = 0; j < i; j++) {
				if ((array[i] > array[j]) && (lenArray[i] < lenArray[j] + 1)) {
					lenArray[i] = lenArray[j] + 1;
					if (lenArray[i] > maxLen) {
						maxLen = lenArray[i];
					}

				}
			}
		}
		
		outputLIS(array,lenArray, totalCount-1, maxLen);

		return null;
	}
	
	
	private static void outputLIS(int[] array, int[] lenArray, int index, int len){
		boolean isLIS = false;
		
		if(index<0 || len==0){
			return;
		}
		
		if(lenArray[index] == len ){
			len --;
			isLIS = true;
		}
		index -- ;
		outputLIS(array, lenArray, index, len);
		if(isLIS)
		{
			System.out.print(array[index+1] + ", ");
		}
		
	}
	

	public static void main(String[] args) {
		Random r = new Random();
		int N = 50;
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = r.nextInt(100) - 60;
		}
		lis(array);

	}

}
